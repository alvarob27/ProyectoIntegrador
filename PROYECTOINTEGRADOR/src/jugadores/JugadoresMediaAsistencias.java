package jugadores;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JugadoresMediaAsistencias extends JFrame {
	private JTable table;
	private JComboBox<String> comboEquipos;
	private JComboBox<String> comboJugadores;

	public JugadoresMediaAsistencias() {
		setBounds(100, 100, 861, 578);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(119, 136, 153));
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblJugadores = new JLabel("JUGADORES");
		lblJugadores.setForeground(new Color(255, 255, 255));
		lblJugadores.setBounds(344, 95, 120, 20);
		panel.add(lblJugadores);

		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String jugadorSeleccionado = comboJugadores.getSelectedItem().toString();
				buscarJugador(jugadorSeleccionado);
			}
		});

		btnBuscar.setForeground(new Color(0, 0, 0));
		btnBuscar.setBounds(593, 95, 85, 21);
		panel.add(btnBuscar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(86, 146, 674, 39);
		panel.add(scrollPane);

		table = new JTable();
		table.setBackground(new Color(240, 248, 255));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"JUGADOR", "PARTIDOS JUGADOS", "ASISTENCIAS", "MEDIA ASISTENCIAS"
			}
		));
		scrollPane.setViewportView(table);

		comboJugadores = new JComboBox<String>();
		comboJugadores.setBounds(428, 95, 120, 21);
		panel.add(comboJugadores);

		JLabel lblEquipos = new JLabel("EQUIPOS");
		lblEquipos.setForeground(new Color(255, 255, 255));
		lblEquipos.setBackground(new Color(255, 255, 255));
		lblEquipos.setBounds(101, 99, 120, 13);
		panel.add(lblEquipos);

		comboEquipos = new JComboBox<String>();
		comboEquipos.setBounds(181, 95, 120, 21);
		panel.add(comboEquipos);

		JLabel lblTitulo = new JLabel("media de asistencias de jugadores");
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setFont(new Font("Star Jedi", Font.PLAIN, 21));
		lblTitulo.setBounds(194, 35, 522, 47);
		panel.add(lblTitulo);

		try {
			Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/apuestas", "root", "");
			Statement miStatement = miConexion.createStatement();
			ResultSet miResultSet = miStatement.executeQuery("SELECT nombre FROM equipo");

			while (miResultSet.next()) {
				comboEquipos.addItem(miResultSet.getString("nombre"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("No se ha podido conectar con la base de datos");
		}

		comboEquipos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String equipoSeleccionado = comboEquipos.getSelectedItem().toString();
				int codEquipo = obtenerCodEquipo(equipoSeleccionado);

				comboJugadores.removeAllItems();

				try {
					Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/apuestas", "root",
							"");
					Statement miStatement = miConexion.createStatement();
					ResultSet miResultSet = miStatement
							.executeQuery("SELECT nombre,apellidos FROM jugadores WHERE cod_equipo = " + codEquipo);

					while (miResultSet.next()) {
						String nombre = miResultSet.getString("nombre");
						String apellidos = miResultSet.getString("apellidos");
						String nombreCompleto = nombre;

						if (apellidos != null && !apellidos.isEmpty()) {
							nombreCompleto += " " + apellidos;
						}

						comboJugadores.addItem(nombreCompleto);
					}
				} catch (SQLException ex) {
					ex.printStackTrace();
					System.out.println("No se ha podido conectar con la base de datos");
				}
			}
		});
	}

	private void buscarJugador(String nombreCompletoJugador) {
	    String equipoSeleccionado = comboEquipos.getSelectedItem().toString();
	    int codEquipo = obtenerCodEquipo(equipoSeleccionado);

	    String[] nombres = nombreCompletoJugador.split(" ");

	    String nombre = nombres[0];
	    String apellidos = "";
	    if (nombres.length > 1) {
	        StringBuilder apellidosBuilder = new StringBuilder();
	        for (int i = 1; i < nombres.length; i++) {
	            apellidosBuilder.append(nombres[i]);
	            if (i < nombres.length - 1) {
	                apellidosBuilder.append(" ");
	            }
	        }
	        apellidos = apellidosBuilder.toString();
	    }

	    try {
	        Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/apuestas", "root", "");
	        PreparedStatement miStatement = miConexion.prepareStatement("SELECT * FROM jugadores WHERE nombre = ? AND apellidos = ? AND cod_equipo = ?");
	        miStatement.setString(1, nombre);
	        miStatement.setString(2, apellidos);
	        miStatement.setInt(3, codEquipo);
	        ResultSet miResultSet = miStatement.executeQuery();

	        DefaultTableModel model = (DefaultTableModel) table.getModel();
	        model.setRowCount(0);
			while (miResultSet.next()) {
				String jugador = nombreCompletoJugador;
				int partidosJugados = miResultSet.getInt("partidos_jugados");
				int asistencias = miResultSet.getInt("asistencias");
				double mediaAsistencias = asistencias / (double) partidosJugados;
	            mediaAsistencias = Math.round(mediaAsistencias * 100.0) / 100.0;

				Object[] row = { jugador, partidosJugados, asistencias, mediaAsistencias };
				model.addRow(row);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("No se ha podido conectar con la base de datos");
		}
	}

	// Método para obtener el cod_equipo a partir del nombre del equipo seleccionado
	private int obtenerCodEquipo(String nombreEquipo) {
		int codEquipo = 0;

		try {
			Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/apuestas", "root", "");
			Statement miStatement = miConexion.createStatement();
			ResultSet miResultSet = miStatement
					.executeQuery("SELECT cod_equipo FROM equipo WHERE nombre = '" + nombreEquipo + "'");

			if (miResultSet.next()) {
				codEquipo = miResultSet.getInt("cod_equipo");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("No se ha podido obtener el cod_equipo");
		}

		return codEquipo;
	}

	public static void main(String[] args) {
		JugadoresMediaAsistencias jugadores = new JugadoresMediaAsistencias();
		jugadores.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jugadores.setSize(800, 600);
		jugadores.setVisible(true);
	}
}

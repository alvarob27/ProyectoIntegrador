package estadisticas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class GolesEquipos extends JFrame {
	private JTable table;

	public GolesEquipos() {
		setBounds(100, 100, 861, 578);
		JPanel panelGolesEquipos = new JPanel();
		panelGolesEquipos.setBackground(new Color(119, 136, 153));
		getContentPane().add(panelGolesEquipos, BorderLayout.CENTER);
		panelGolesEquipos.setLayout(null);

		JLabel lblGolesEquipos = new JLabel("goles equipos");
		lblGolesEquipos.setFont(new Font("Star Jedi", Font.PLAIN, 21));
		lblGolesEquipos.setForeground(new Color(255, 255, 255));
		lblGolesEquipos.setBounds(311, 45, 203, 29);
		panelGolesEquipos.add(lblGolesEquipos);

		JComboBox<String> comboEquipos = new JComboBox<>();
		comboEquipos.setBounds(286, 100, 122, 21);
		panelGolesEquipos.add(comboEquipos);

		JButton btnGolesEquipos = new JButton("BUSCAR");
		btnGolesEquipos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String equipoSeleccionado = (String) comboEquipos.getSelectedItem();

		        try {
		            Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/apuestas", "root", "");
		            Statement miStatement = miConexion.createStatement();

		            String consultaLocal = "SELECT SUM(goles_local) as golesLocal FROM resultados WHERE equipo_local LIKE '" + equipoSeleccionado + "%'";
		            String consultaVisitante = "SELECT SUM(goles_visitante) as golesVisitante FROM resultados WHERE equipo_visitante LIKE '" + equipoSeleccionado + "%'";

		            int golesLocal = 0;
		            int golesVisitante = 0;

		            ResultSet miResultSetLocal = miStatement.executeQuery(consultaLocal);
		            if (miResultSetLocal.next()) {
		            	golesLocal = miResultSetLocal.getInt("golesLocal");
		            }
		            miResultSetLocal.close();

		            ResultSet miResultSetVisitante = miStatement.executeQuery(consultaVisitante);
		            if (miResultSetVisitante.next()) {
		            	golesVisitante = miResultSetVisitante.getInt("golesVisitante");
		            }
		            miResultSetVisitante.close();

		            String consulta = "SELECT nombre, partidos_jugados FROM equipo WHERE nombre='" + equipoSeleccionado + "'";
		            ResultSet miResultSetEquipo = miStatement.executeQuery(consulta);

		            if (miResultSetEquipo.next()) {
		                String nombreEquipo = miResultSetEquipo.getString("nombre");
		                int partidosJugados = miResultSetEquipo.getInt("partidos_jugados");

		                String consultaPartidosLocal = "SELECT COUNT(*) as partidosLocal FROM resultados WHERE equipo_local LIKE '" + equipoSeleccionado + "%'";
		                String consultaPartidosVisitante = "SELECT COUNT(*) as partidosVisitante FROM resultados WHERE equipo_visitante LIKE '" + equipoSeleccionado + "%'";

		                int partidosLocal = 0;
		                int partidosVisitante = 0;

		                ResultSet miResultSetPartidosLocal = miStatement.executeQuery(consultaPartidosLocal);
		                if (miResultSetPartidosLocal.next()) {
		                    partidosLocal = miResultSetPartidosLocal.getInt("partidosLocal");
		                }
		                miResultSetPartidosLocal.close();

		                ResultSet miResultSetPartidosVisitante = miStatement.executeQuery(consultaPartidosVisitante);
		                if (miResultSetPartidosVisitante.next()) {
		                    partidosVisitante = miResultSetPartidosVisitante.getInt("partidosVisitante");
		                }
		                miResultSetPartidosVisitante.close();

		                double mediaGolesLocal = (partidosLocal != 0) ? (golesLocal / (double) partidosLocal) : 0.0;
		                double mediaGolesVisitante = (partidosVisitante != 0) ? (golesVisitante / (double) partidosVisitante) : 0.0;

		                // Redondear los valores a 2 decimales
		                mediaGolesLocal = Math.round(mediaGolesLocal * 100.0) / 100.0;
		                mediaGolesVisitante = Math.round(mediaGolesVisitante * 100.0) / 100.0;

		                // Crear el DefaultTableModel con las columnas necesarias
		                DefaultTableModel model = new DefaultTableModel();
		                model.addColumn("Equipo");
		                model.addColumn("Partidos Local");
		                model.addColumn("Goles Local");
		                model.addColumn("Media Local");		                	               
		                model.addColumn("Partidos Visitante");		
		                model.addColumn("Goles Visitante");	
		                model.addColumn("Media Visitante");

		                // Agregar los datos al modelo
		                model.addRow(new Object[]{nombreEquipo, partidosLocal, golesLocal, mediaGolesLocal, partidosVisitante, golesVisitante, mediaGolesVisitante});

		                // Asignar el modelo a la tabla
		                table.setModel(model);
		            }

		            miResultSetEquipo.close();
		            miStatement.close();
		            miConexion.close();
		        } catch (SQLException ex) {
		            ex.printStackTrace();
		            System.out.println("No se ha podido conectar con la base de datos");
		        }
			}
		});
		btnGolesEquipos.setBounds(429, 100, 85, 21);
		panelGolesEquipos.add(btnGolesEquipos);

		JScrollPane scrollPaneGolesEquipos = new JScrollPane();
		scrollPaneGolesEquipos.setBounds(29, 145, 739, 37);
		panelGolesEquipos.add(scrollPaneGolesEquipos);

		table = new JTable();
		table.setBackground(new Color(240, 248, 255));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"Equipo", "Partidos Local", "Goles Local", "Media Local", "Partidos Visitante", "Goles Visitante", "Media Visitante"
			}
		));
		scrollPaneGolesEquipos.setViewportView(table);

		JLabel lblNewLabel = new JLabel("EQUIPOS");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(196, 104, 80, 13);
		panelGolesEquipos.add(lblNewLabel);

		// AÑADIR AL COMBO DE EQUIPOS CADA EQUIPO
		try {
			Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/apuestas", "root", "");
			Statement miStatement = miConexion.createStatement();
			ResultSet miResultSet = miStatement.executeQuery("SELECT nombre FROM equipo");

			while (miResultSet.next()) {
				comboEquipos.addItem(miResultSet.getString("nombre"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("No se ha podido conectar con la base de datos");
		}
	}
	
	

	public static void main(String[] args) {
		GolesEquipos golesEquipos = new GolesEquipos();
		golesEquipos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		golesEquipos.setSize(800, 600);
		golesEquipos.setVisible(true);
	}
}

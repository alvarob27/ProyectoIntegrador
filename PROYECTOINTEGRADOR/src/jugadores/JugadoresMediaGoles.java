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

public class JugadoresMediaGoles extends JFrame {
    private JTable table;
    private JComboBox comboEquipos;
    private JComboBox<String> comboJugadores;

    public JugadoresMediaGoles() {
    	setBounds(100, 100, 861, 578);
        JPanel panel = new JPanel();
        panel.setBackground(new Color(119, 136, 153));
        getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("JUGADORES");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setBounds(371, 100, 92, 20);
        panel.add(lblNewLabel);


        JButton btnNewButton = new JButton("BUSCAR");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String jugadorSeleccionado = comboJugadores.getSelectedItem().toString();
				buscarJugador(jugadorSeleccionado);
        	}
        });
        btnNewButton.setBounds(642, 100, 85, 21);
        panel.add(btnNewButton);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(86, 165, 674, 38);
        panel.add(scrollPane);

        table = new JTable();
        table.setBackground(new Color(240, 248, 255));
        table.setModel(new DefaultTableModel(
        	new Object[][] {
        		{null, null, null, null},
        	},
        	new String[] {
        		"JUGADOR", "PARTIDOS JUGADOS", "GOLES", "MEDIA GOLES"
        	}
        ));
        scrollPane.setViewportView(table);
        
        comboJugadores = new JComboBox<String>();
        comboJugadores.setBounds(452, 100, 151, 21);
        panel.add(comboJugadores);
        
        JLabel lblNewLabel_1 = new JLabel("EQUIPOS");
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setBounds(113, 104, 85, 13);
        panel.add(lblNewLabel_1);
        
        comboEquipos = new JComboBox();
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
        comboEquipos.setBounds(195, 100, 142, 21);
        panel.add(comboEquipos);
        
        JLabel lblNewLabel_2 = new JLabel("media goles de jugadores");
        lblNewLabel_2.setForeground(new Color(255, 255, 255));
        lblNewLabel_2.setFont(new Font("Star Jedi", Font.PLAIN, 21));
        lblNewLabel_2.setBounds(231, 25, 465, 59);
        panel.add(lblNewLabel_2);
        
        //RELLENAR COMBO EQUIPOS
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
				int goles = miResultSet.getInt("goles");
				double mediaGoles = goles / (double) partidosJugados;
				mediaGoles = Math.round(mediaGoles * 100.0) / 100.0;

				Object[] row = { jugador, partidosJugados, goles, mediaGoles };
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
        JugadoresMediaGoles jugadores = new JugadoresMediaGoles();
        jugadores.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jugadores.setSize(800, 600);
        jugadores.setVisible(true);
    }
}

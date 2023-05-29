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

public class JugadorTirosPuertaPorPartido extends JFrame {
    private JTable table;
    private JComboBox<String> comboJugadores;
    private JComboBox<String> comboEquipos;

    public JugadorTirosPuertaPorPartido() {
    	setBounds(100,100,861,578);
        JPanel panelPasesJugadorPartido = new JPanel();
        panelPasesJugadorPartido.setBackground(new Color(119, 136, 153));
        getContentPane().add(panelPasesJugadorPartido, BorderLayout.CENTER);
        panelPasesJugadorPartido.setLayout(null);

        JLabel lblPasesJugadorPartido = new JLabel("tiros a puerta de jugadores");
        lblPasesJugadorPartido.setForeground(new Color(255, 255, 255));
        lblPasesJugadorPartido.setFont(new Font("Star Jedi", Font.PLAIN, 21));
        lblPasesJugadorPartido.setBounds(182, 42, 454, 37);
        panelPasesJugadorPartido.add(lblPasesJugadorPartido);

        comboEquipos = new JComboBox<>();
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
        comboEquipos.setBounds(205, 104, 120, 21);
        panelPasesJugadorPartido.add(comboEquipos);

        JButton btnPasesJugadorPartido = new JButton("BUSCAR");
        btnPasesJugadorPartido.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		String jugadorSeleccionado = comboJugadores.getSelectedItem().toString();
				buscarJugador(jugadorSeleccionado);
        	}
        });
        btnPasesJugadorPartido.setBounds(576, 104, 85, 21);
        panelPasesJugadorPartido.add(btnPasesJugadorPartido);

        JScrollPane scrollPanePasesJugadorPartido = new JScrollPane();
        scrollPanePasesJugadorPartido.setBounds(55, 153, 674, 37);
        panelPasesJugadorPartido.add(scrollPanePasesJugadorPartido);

        table = new JTable();
        table.setBackground(new Color(240, 248, 255));
        table.setModel(new DefaultTableModel(
        	new Object[][] {
        		{null, null, null, null},
        	},
        	new String[] {
        		"Jugador", "Partidos Jugados", "Tiros a Puerta", "Media de tiros a puerta"
        	}
        ));
        scrollPanePasesJugadorPartido.setViewportView(table);
        
        comboJugadores = new JComboBox<String>();
        comboJugadores.setBounds(434, 104, 120, 21);
        panelPasesJugadorPartido.add(comboJugadores);
        
        JLabel lblNewLabel = new JLabel("EQUIPOS");
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setBackground(Color.WHITE);
        lblNewLabel.setBounds(132, 108, 102, 13);
        panelPasesJugadorPartido.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("JUGADORES");
        lblNewLabel_1.setForeground(Color.WHITE);
        lblNewLabel_1.setBounds(348, 108, 110, 13);
        panelPasesJugadorPartido.add(lblNewLabel_1);
        
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
				int tirosPuerta = miResultSet.getInt("tiros_puerta");
				double mediaTirosPuerta = tirosPuerta / (double) partidosJugados;
				mediaTirosPuerta = Math.round(mediaTirosPuerta * 100.0) / 100.0;

				Object[] row = { jugador, partidosJugados, tirosPuerta, mediaTirosPuerta };
				model.addRow(row);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("No se ha podido conectar con la base de datos");
		}
	}



    public static void main(String[] args) {
        JugadorTirosPuertaPorPartido jugadorPasesPorPartido = new JugadorTirosPuertaPorPartido();
        jugadorPasesPorPartido.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jugadorPasesPorPartido.setSize(800, 600);
        jugadorPasesPorPartido.setVisible(true);
    }
}


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

public class JugadorTirosPorPartido extends JFrame {
    private JTable table;
    private JComboBox<String> comboEquipos;
    private JComboBox<String> comboJugadores;

    public JugadorTirosPorPartido() {
    	
    	setBounds(100,100,861,578);
        JPanel panelTirosPuerta = new JPanel();
        panelTirosPuerta.setBackground(new Color(119, 136, 153));
        getContentPane().add(panelTirosPuerta, BorderLayout.CENTER);
        panelTirosPuerta.setLayout(null);

        JLabel lblTirosPuerta = new JLabel("tiros de jugadores");
        lblTirosPuerta.setForeground(new Color(255, 255, 255));
        lblTirosPuerta.setFont(new Font("Star Jedi", Font.PLAIN, 21));
        lblTirosPuerta.setBounds(275, 35, 390, 29);
        panelTirosPuerta.add(lblTirosPuerta);

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
        comboEquipos.setBounds(238, 92, 120, 21);
        panelTirosPuerta.add(comboEquipos);

        JButton btnTirosPuerta = new JButton("BUSCAR");
        btnTirosPuerta.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		String jugadorSeleccionado = comboJugadores.getSelectedItem().toString();
				buscarJugador(jugadorSeleccionado);
        	}
        });
        btnTirosPuerta.setBounds(629, 92, 85, 21);
        panelTirosPuerta.add(btnTirosPuerta);

        JScrollPane scrollPaneTirosPuerta = new JScrollPane();
        scrollPaneTirosPuerta.setBounds(67, 145, 674, 36);
        panelTirosPuerta.add(scrollPaneTirosPuerta);

        table = new JTable();
        table.setBackground(new Color(240, 248, 255));
        table.setModel(new DefaultTableModel(
        	new Object[][] {
        		{null, null, null, null},
        	},
        	new String[] {
        			"Jugador", "Partidos Jugados", "Tiros", "Media de tiros"
        	}
        ));
        scrollPaneTirosPuerta.setViewportView(table);
        
        comboJugadores = new JComboBox<String>();
        comboJugadores.setBounds(479, 92, 120, 21);
        panelTirosPuerta.add(comboJugadores);
        
        JLabel lblNewLabel = new JLabel("EQUIPOS");
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setBounds(137, 96, 91, 13);
        panelTirosPuerta.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("JUGADORES");
        lblNewLabel_1.setForeground(Color.WHITE);
        lblNewLabel_1.setBounds(391, 96, 113, 13);
        panelTirosPuerta.add(lblNewLabel_1);
        
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
				int tiros = miResultSet.getInt("tiros");
				double mediaTiros = tiros / (double) partidosJugados;
				mediaTiros = Math.round(mediaTiros * 100.0) / 100.0;

				Object[] row = { jugador, partidosJugados, tiros, mediaTiros };
				model.addRow(row);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("No se ha podido conectar con la base de datos");
		}
	}

    public static void main(String[] args) {
        JugadorTirosPorPartido tirosPuertaPorPartido = new JugadorTirosPorPartido();
        tirosPuertaPorPartido.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tirosPuertaPorPartido.setSize(800, 600);
        tirosPuertaPorPartido.setVisible(true);
    }
}

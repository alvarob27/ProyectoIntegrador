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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TirosPorPartido extends JFrame {
    private JTable table;
    private JComboBox<String> comboEquipos;

    public TirosPorPartido() {
    	setBounds(100,100,861,578);
        JPanel panelTirosPartidos = new JPanel();
        panelTirosPartidos.setBackground(new Color(119, 136, 153));
        getContentPane().add(panelTirosPartidos, BorderLayout.CENTER);
        panelTirosPartidos.setLayout(null);

        JLabel lblTirosPartidos = new JLabel("tiros de equipos");
        lblTirosPartidos.setFont(new Font("Star Jedi", Font.PLAIN, 21));
        lblTirosPartidos.setForeground(new Color(255, 255, 255));
        lblTirosPartidos.setBounds(303, 60, 284, 43);
        panelTirosPartidos.add(lblTirosPartidos);

        comboEquipos = new JComboBox<>();
        comboEquipos.setBounds(290, 124, 151, 21);
        panelTirosPartidos.add(comboEquipos);

        JButton btnTirosPartidos = new JButton("BUSCAR");
        btnTirosPartidos.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		String equipoSeleccionado = (String) comboEquipos.getSelectedItem();

		        try {
		            Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/apuestas", "root", "");
		            Statement miStatement = miConexion.createStatement();

		            String consultaLocal = "SELECT SUM(tiros_local) as tirosLocal FROM resultados WHERE equipo_local LIKE '" + equipoSeleccionado + "%'";
		            String consultaVisitante = "SELECT SUM(tiros_visitante) as tirosVisitante FROM resultados WHERE equipo_visitante LIKE '" + equipoSeleccionado + "%'";

		            int tirosLocal = 0;
		            int tirosVisitante = 0;

		            ResultSet miResultSetLocal = miStatement.executeQuery(consultaLocal);
		            if (miResultSetLocal.next()) {
		            	tirosLocal = miResultSetLocal.getInt("tirosLocal");
		            }
		            miResultSetLocal.close();

		            ResultSet miResultSetVisitante = miStatement.executeQuery(consultaVisitante);
		            if (miResultSetVisitante.next()) {
		            	tirosVisitante = miResultSetVisitante.getInt("tirosVisitante");
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

		                double mediaTirosLocal = (partidosLocal != 0) ? (tirosLocal / (double) partidosLocal) : 0.0;
		                double mediaTirosVisitante = (partidosVisitante != 0) ? (tirosVisitante / (double) partidosVisitante) : 0.0;

		                // Redondear los valores a 2 decimales
		                mediaTirosLocal = Math.round(mediaTirosLocal * 100.0) / 100.0;
		                mediaTirosVisitante = Math.round(mediaTirosVisitante * 100.0) / 100.0;

		                // Crear el DefaultTableModel con las columnas necesarias
		                DefaultTableModel model = new DefaultTableModel();
		                model.addColumn("Equipo");
		                model.addColumn("Partidos Local");
		                model.addColumn("Tiros Local");
		                model.addColumn("Media Local");		                	               
		                model.addColumn("Partidos Visitante");		
		                model.addColumn("Tiros Visitante");	
		                model.addColumn("Media Visitante");

		                // Agregar los datos al modelo
		                model.addRow(new Object[]{nombreEquipo, partidosLocal, tirosLocal, mediaTirosLocal, partidosVisitante, tirosVisitante, mediaTirosVisitante});

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
        btnTirosPartidos.setBounds(462, 124, 85, 21);
        panelTirosPartidos.add(btnTirosPartidos);

        JScrollPane scrollPaneTirosPartidos = new JScrollPane();
        scrollPaneTirosPartidos.setBounds(86, 167, 674, 36);
        panelTirosPartidos.add(scrollPaneTirosPartidos);

        table = new JTable();
        table.setBackground(new Color(240, 248, 255));
        table.setModel(new DefaultTableModel(
        	new Object[][] {
        		{null, null, null, null},
        	},
        	new String[] {
        			"Equipo", "Partidos Local", "Tiros Local", "Media Local", "Partidos Visitante", "Tiros Visitante", "Media Visitante"
        	}
        ));
        scrollPaneTirosPartidos.setViewportView(table);
        
        JLabel lblNewLabel = new JLabel("EQUIPOS");
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setBounds(208, 120, 85, 29);
        panelTirosPartidos.add(lblNewLabel);
        
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
        TirosPorPartido tirosPorPartido = new TirosPorPartido();
        tirosPorPartido.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tirosPorPartido.setSize(800, 600);
        tirosPorPartido.setVisible(true);
    }
}

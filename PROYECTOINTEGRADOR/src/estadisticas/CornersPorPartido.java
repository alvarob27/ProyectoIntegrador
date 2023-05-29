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

public class CornersPorPartido extends JFrame {
    private JTable table;
    private JComboBox<String> comboEquipos;

    public CornersPorPartido() {
    	setBounds(100,100,861,578);
        JPanel panelCornersPartido = new JPanel();
        panelCornersPartido.setBackground(new Color(119, 136, 153));
        getContentPane().add(panelCornersPartido, BorderLayout.CENTER);
        panelCornersPartido.setLayout(null);

        JLabel lblCornersPartido = new JLabel("corners de equipos");
        lblCornersPartido.setFont(new Font("Star Jedi", Font.PLAIN, 21));
        lblCornersPartido.setForeground(new Color(255, 255, 255));
        lblCornersPartido.setBounds(285, 36, 276, 39);
        panelCornersPartido.add(lblCornersPartido);

        JButton btnCornersPartido = new JButton("BUSCAR");
        btnCornersPartido.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		String equipoSeleccionado = (String) comboEquipos.getSelectedItem();

		        try {
		            Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/apuestas", "root", "");
		            Statement miStatement = miConexion.createStatement();

		            String consultaLocal = "SELECT SUM(corners_local) as cornersLocal FROM resultados WHERE equipo_local LIKE '" + equipoSeleccionado + "%'";
		            String consultaVisitante = "SELECT SUM(corners_visitante) as cornersVisitante FROM resultados WHERE equipo_visitante LIKE '" + equipoSeleccionado + "%'";

		            int cornersLocal = 0;
		            int cornersVisitante = 0;

		            ResultSet miResultSetLocal = miStatement.executeQuery(consultaLocal);
		            if (miResultSetLocal.next()) {
		            	cornersLocal = miResultSetLocal.getInt("cornersLocal");
		            }
		            miResultSetLocal.close();

		            ResultSet miResultSetVisitante = miStatement.executeQuery(consultaVisitante);
		            if (miResultSetVisitante.next()) {
		            	cornersVisitante = miResultSetVisitante.getInt("cornersVisitante");
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

		                double mediaCornersLocal = (partidosLocal != 0) ? (cornersLocal / (double) partidosLocal) : 0.0;
		                double mediaCornersVisitante = (partidosVisitante != 0) ? (cornersVisitante / (double) partidosVisitante) : 0.0;

		                // Redondear los valores a 2 decimales
		                mediaCornersLocal = Math.round(mediaCornersLocal * 100.0) / 100.0;
		                mediaCornersVisitante = Math.round(mediaCornersVisitante * 100.0) / 100.0;

		                // Crear el DefaultTableModel con las columnas necesarias
		                DefaultTableModel model = new DefaultTableModel();
		                model.addColumn("Equipo");
		                model.addColumn("Partidos Local");
		                model.addColumn("Corners Local");
		                model.addColumn("Media Local");		                	               
		                model.addColumn("Partidos Visitante");		
		                model.addColumn("Corners Visitante");	
		                model.addColumn("Media Visitante");

		                // Agregar los datos al modelo
		                model.addRow(new Object[]{nombreEquipo, partidosLocal, cornersLocal, mediaCornersLocal, partidosVisitante, cornersVisitante, mediaCornersVisitante});

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
        btnCornersPartido.setBounds(506, 96, 85, 21);
        panelCornersPartido.add(btnCornersPartido);

        JScrollPane scrollPaneCornersPartido = new JScrollPane();
        scrollPaneCornersPartido.setBounds(60, 153, 674, 39);
        panelCornersPartido.add(scrollPaneCornersPartido);

        table = new JTable();
		table.setBackground(new Color(240, 248, 255));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"Equipo", "Partidos Local", "Corners Local", "Media Local", "Partidos Visitante", "Corners Visitante", "Media Visitante"
			}
		));
        scrollPaneCornersPartido.setViewportView(table);

        comboEquipos = new JComboBox<String>();
        comboEquipos.setBounds(317, 96, 152, 21);
        panelCornersPartido.add(comboEquipos);
        
        JLabel lblNewLabel = new JLabel("EQUIPOS");
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setBounds(230, 100, 120, 13);
        panelCornersPartido.add(lblNewLabel);
        
        try {
			Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/apuestas","root","");
			Statement miStatement = miConexion.createStatement();
			ResultSet miResultSet = miStatement.executeQuery("SELECT nombre FROM equipo");
			
			
			while(miResultSet.next()) {
				comboEquipos.addItem(miResultSet.getString("nombre"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("No se ha podido conectar con la base de datos");
		}
    }
    


    public static void main(String[] args) {
        CornersPorPartido estadio = new CornersPorPartido();
        estadio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        estadio.setSize(800, 600);
        estadio.setVisible(true);
    }
}

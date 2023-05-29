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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PasesTotalesEquipos extends JFrame {
    private JTable table;

    public PasesTotalesEquipos() {
    	setBounds(100,100,861,578);
        JPanel panelPasesTotales = new JPanel();
        panelPasesTotales.setBackground(new Color(119, 136, 153));
        getContentPane().add(panelPasesTotales, BorderLayout.CENTER);
        panelPasesTotales.setLayout(null);

        JLabel lblPasesTotales = new JLabel("pases de equipos");
        lblPasesTotales.setForeground(new Color(255, 255, 255));
        lblPasesTotales.setFont(new Font("Star Jedi", Font.PLAIN, 21));
        lblPasesTotales.setBounds(277, 52, 315, 29);
        panelPasesTotales.add(lblPasesTotales);

        JComboBox<String> comboEquipos = new JComboBox<>();
        comboEquipos.setBounds(311, 108, 148, 21);
        panelPasesTotales.add(comboEquipos);

        JButton btnPasesTotales = new JButton("BUSCAR");
        btnPasesTotales.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		String equipoSeleccionado = (String) comboEquipos.getSelectedItem();

		        try {
		            Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/apuestas", "root", "");
		            Statement miStatement = miConexion.createStatement();

		            String consultaLocal = "SELECT SUM(pases_local) as pasesLocal FROM resultados WHERE equipo_local LIKE '" + equipoSeleccionado + "%'";
		            String consultaVisitante = "SELECT SUM(pases_visitante) as pasesVisitante FROM resultados WHERE equipo_visitante LIKE '" + equipoSeleccionado + "%'";

		            int pasesLocal = 0;
		            int pasesVisitante = 0;

		            ResultSet miResultSetLocal = miStatement.executeQuery(consultaLocal);
		            if (miResultSetLocal.next()) {
		            	pasesLocal = miResultSetLocal.getInt("pasesLocal");
		            }
		            miResultSetLocal.close();

		            ResultSet miResultSetVisitante = miStatement.executeQuery(consultaVisitante);
		            if (miResultSetVisitante.next()) {
		            	pasesVisitante = miResultSetVisitante.getInt("pasesVisitante");
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

		                double mediaPasesLocal = (partidosLocal != 0) ? (pasesLocal / (double) partidosLocal) : 0.0;
		                double mediaPasesVisitante = (partidosVisitante != 0) ? (pasesVisitante / (double) partidosVisitante) : 0.0;

		                // Redondear los valores a 2 decimales
		                mediaPasesLocal = Math.round(mediaPasesLocal * 100.0) / 100.0;
		                mediaPasesVisitante = Math.round(mediaPasesVisitante * 100.0) / 100.0;

		                // Crear el DefaultTableModel con las columnas necesarias
		                DefaultTableModel model = new DefaultTableModel();
		                model.addColumn("Equipo");
		                model.addColumn("Partidos Local");
		                model.addColumn("Pases Local");
		                model.addColumn("Media Local");		                	               
		                model.addColumn("Partidos Visitante");		
		                model.addColumn("Pases Visitante");	
		                model.addColumn("Media Visitante");

		                // Agregar los datos al modelo
		                model.addRow(new Object[]{nombreEquipo, partidosLocal, pasesLocal, mediaPasesLocal, partidosVisitante, pasesVisitante, mediaPasesVisitante});

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
        btnPasesTotales.setBounds(487, 108, 85, 21);
        panelPasesTotales.add(btnPasesTotales);

        JScrollPane scrollPanePasesTotales = new JScrollPane();
        scrollPanePasesTotales.setBounds(86, 146, 674, 35);
        panelPasesTotales.add(scrollPanePasesTotales);

        table = new JTable();
        table.setBackground(new Color(240, 248, 255));
        table.setModel(new DefaultTableModel(
        	new Object[][] {
        		{null, null, null, null},
        	},
        	new String[] {
        			"Equipo", "Partidos Local", "Pases Local", "Media Local", "Partidos Visitante", "Pases Visitante", "Media Visitante"
        	}
        ));
        scrollPanePasesTotales.setViewportView(table);
        
        JLabel lblNewLabel = new JLabel("EQUIPOS");
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setBounds(249, 101, 71, 35);
        panelPasesTotales.add(lblNewLabel);
        
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
        PasesTotalesEquipos pasesTotalesEquipos = new PasesTotalesEquipos();
        pasesTotalesEquipos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pasesTotalesEquipos.setSize(800, 600);
        pasesTotalesEquipos.setVisible(true);
    }
}

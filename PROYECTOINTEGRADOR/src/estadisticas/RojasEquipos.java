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

public class RojasEquipos extends JFrame {
	private JTable table;
	private JComboBox<String> comboEquipos;

	public RojasEquipos() {
		setBounds(100, 100, 861, 578);
		JPanel panelRojas = new JPanel();
		panelRojas.setBackground(new Color(119, 136, 153));
		getContentPane().add(panelRojas, BorderLayout.CENTER);
		panelRojas.setLayout(null);

		JLabel lblRojas = new JLabel("rojas de equipos");
		lblRojas.setForeground(new Color(255, 255, 255));
		lblRojas.setFont(new Font("Star Jedi", Font.PLAIN, 21));
		lblRojas.setBounds(292, 71, 307, 55);
		panelRojas.add(lblRojas);

		JButton btnRojas = new JButton("BUSCAR");
		btnRojas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				 String equipoSeleccionado = (String) comboEquipos.getSelectedItem();

			        try {
			            Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/apuestas", "root", "");
			            Statement miStatement = miConexion.createStatement();

			            String consultaLocal = "SELECT SUM(rojas_local) as rojasLocal FROM resultados WHERE equipo_local LIKE '" + equipoSeleccionado + "%'";
			            String consultaVisitante = "SELECT SUM(rojas_visitante) as rojasVisitante FROM resultados WHERE equipo_visitante LIKE '" + equipoSeleccionado + "%'";

			            int rojasLocal = 0;
			            int rojasVisitante = 0;

			            ResultSet miResultSetLocal = miStatement.executeQuery(consultaLocal);
			            if (miResultSetLocal.next()) {
			            	rojasLocal = miResultSetLocal.getInt("rojasLocal");
			            }
			            miResultSetLocal.close();

			            ResultSet miResultSetVisitante = miStatement.executeQuery(consultaVisitante);
			            if (miResultSetVisitante.next()) {
			            	rojasVisitante = miResultSetVisitante.getInt("rojasVisitante");
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

			                double mediaRojasLocal = (partidosLocal != 0) ? (rojasLocal / (double) partidosLocal) : 0.0;
			                double mediaRojasVisitante = (partidosVisitante != 0) ? (rojasVisitante / (double) partidosVisitante) : 0.0;

			                // Redondear los valores a 2 decimales
			                mediaRojasLocal = Math.round(mediaRojasLocal * 100.0) / 100.0;
			                mediaRojasVisitante = Math.round(mediaRojasVisitante * 100.0) / 100.0;

			                // Crear el DefaultTableModel con las columnas necesarias
			                DefaultTableModel model = new DefaultTableModel();
			                model.addColumn("Equipo");
			                model.addColumn("Partidos Local");
			                model.addColumn("Rojas Local");
			                model.addColumn("Media Local");		                	               
			                model.addColumn("Partidos Visitante");		
			                model.addColumn("Rojas Visitante");	
			                model.addColumn("Media Visitante");

			                // Agregar los datos al modelo
			                model.addRow(new Object[]{nombreEquipo, partidosLocal, rojasLocal, mediaRojasLocal, partidosVisitante, rojasVisitante, mediaRojasVisitante});

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
		btnRojas.setBounds(437, 148, 85, 21);
		panelRojas.add(btnRojas);

		JScrollPane scrollPaneRojas = new JScrollPane();
		scrollPaneRojas.setBounds(86, 210, 674, 37);
		panelRojas.add(scrollPaneRojas);

		table = new JTable();
		table.setBackground(new Color(240, 248, 255));
		table.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, },
				new String[] { "Equipo", "Partidos Local", "Rojas Local", "Media Local", "Partidos Visitante", "Rojas Visitante", "Media Visitante" }));
		scrollPaneRojas.setViewportView(table);

		comboEquipos = new JComboBox<String>();
		comboEquipos.setBounds(292, 148, 120, 21);
		panelRojas.add(comboEquipos);

		JLabel lblNewLabel = new JLabel("EQUIPOS");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(205, 145, 77, 27);
		panelRojas.add(lblNewLabel);

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
		RojasEquipos estadio = new RojasEquipos();
		estadio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		estadio.setSize(800, 600);
		estadio.setVisible(true);
	}
}

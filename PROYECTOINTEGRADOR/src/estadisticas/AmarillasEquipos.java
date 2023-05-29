package estadisticas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AmarillasEquipos extends JFrame {

	private JPanel contentPane;
	private JTable table;

	public static void main(String[] args) {

		AmarillasEquipos frame = new AmarillasEquipos();
		frame.setVisible(true);

	}

	public AmarillasEquipos() {
		setBounds(100, 100, 786, 612);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(119, 136, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 166, 752, 39);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setBackground(new Color(240, 248, 255));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"Equipo", "Partidos Local", "Amarillas Local", "Media Local", "Partidos Visitante", "Amarillas Visitante", "Media Visitante"
			}
		));
		scrollPane.setViewportView(table);

		JLabel lblNewLabel = new JLabel("amarillas de equipos");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Star Jedi", Font.PLAIN, 21));
		lblNewLabel.setBounds(243, 39, 320, 73);
		contentPane.add(lblNewLabel);

		JComboBox comboEquipos = new JComboBox();
		comboEquipos.setBounds(299, 122, 157, 21);
		contentPane.add(comboEquipos);

		JLabel lblNewLabel_1 = new JLabel("EQUIPOS");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(213, 126, 103, 13);
		contentPane.add(lblNewLabel_1);

		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String equipoSeleccionado = (String) comboEquipos.getSelectedItem();

		        try {
		            Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/apuestas", "root", "");
		            Statement miStatement = miConexion.createStatement();

		            String consultaLocal = "SELECT SUM(amarillas_local) as amarillasLocal FROM resultados WHERE equipo_local LIKE '" + equipoSeleccionado + "%'";
		            String consultaVisitante = "SELECT SUM(amarillas_visitante) as amarillasVisitante FROM resultados WHERE equipo_visitante LIKE '" + equipoSeleccionado + "%'";

		            int amarillasLocal = 0;
		            int amarillasVisitante = 0;

		            ResultSet miResultSetLocal = miStatement.executeQuery(consultaLocal);
		            if (miResultSetLocal.next()) {
		                amarillasLocal = miResultSetLocal.getInt("amarillasLocal");
		            }
		            miResultSetLocal.close();

		            ResultSet miResultSetVisitante = miStatement.executeQuery(consultaVisitante);
		            if (miResultSetVisitante.next()) {
		                amarillasVisitante = miResultSetVisitante.getInt("amarillasVisitante");
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

		                double mediaAmarillasLocal = (partidosLocal != 0) ? (amarillasLocal / (double) partidosLocal) : 0.0;
		                double mediaAmarillasVisitante = (partidosVisitante != 0) ? (amarillasVisitante / (double) partidosVisitante) : 0.0;

		                // Redondear los valores a 2 decimales
		                mediaAmarillasLocal = Math.round(mediaAmarillasLocal * 100.0) / 100.0;
		                mediaAmarillasVisitante = Math.round(mediaAmarillasVisitante * 100.0) / 100.0;

		                // Crear el DefaultTableModel con las columnas necesarias
		                DefaultTableModel model = new DefaultTableModel();
		                model.addColumn("Equipo");
		                model.addColumn("Partidos Local");
		                model.addColumn("Amarillas Local");
		                model.addColumn("Media Local");		                	               
		                model.addColumn("Partidos Visitante");		
		                model.addColumn("Amarillas Visitante");	
		                model.addColumn("Media Visitante");

		                // Agregar los datos al modelo
		                model.addRow(new Object[]{nombreEquipo, partidosLocal, amarillasLocal, mediaAmarillasLocal, partidosVisitante, amarillasVisitante, mediaAmarillasVisitante});

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




		btnBuscar.setBounds(483, 122, 85, 21);
		contentPane.add(btnBuscar);

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
}

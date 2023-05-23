package equipos;

import javax.swing.JFrame;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class EquipoDiferenciaGoles extends JFrame{
	
	private JTable table;
	private JComboBox<String> comboEquipos;
	
	public EquipoDiferenciaGoles() {
		
		
		setBounds(100, 100, 861, 578);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(119, 136, 153));
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblTitulo = new JLabel("diferencia de goles de equipos");
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setFont(new Font("Star Jedi", Font.PLAIN, 21));
		lblTitulo.setBounds(244, 29, 431, 63);
		panel.add(lblTitulo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(113, 152, 602, 37);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(240, 248, 255));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"Equipo", "Goles", "Goles en Contra", "Diferencia"
			}
		));
		scrollPane.setViewportView(table);
		
		JComboBox comboEquipos = new JComboBox();
		comboEquipos.setBounds(321, 102, 151, 21);
		panel.add(comboEquipos);
		
		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String equipoSeleccionado = (String) comboEquipos.getSelectedItem();
		        
		        try {
		            Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/apuestas","root","");
		            Statement miStatement = miConexion.createStatement();
		            String consulta = "SELECT * FROM equipo WHERE nombre = '" + equipoSeleccionado + "'";
		            ResultSet miResultSet = miStatement.executeQuery(consulta);
		            
		            // Crear el DefaultTableModel con las columnas necesarias
		            DefaultTableModel model = new DefaultTableModel();
		            model.addColumn("Equipo");
		            model.addColumn("Goles");
		            model.addColumn("Goles en Contra");
		            model.addColumn("Diferencia");
		            
		            // Iterar sobre los registros del ResultSet y agregarlos al modelo
		            while (miResultSet.next()) {
		                String nombreEquipo = miResultSet.getString("nombre");
		                int goles = miResultSet.getInt("goles_favor");
		                int golesContra = miResultSet.getInt("goles_contra");
		                int diferencia = goles - golesContra;
		                
		                model.addRow(new Object[]{nombreEquipo, goles, golesContra, diferencia});
		            }
		            
		            // Asignar el modelo a la tabla
		            table.setModel(model);
		            
		            miResultSet.close();
		            miStatement.close();
		            miConexion.close();
		        } catch (SQLException ex) {
		            ex.printStackTrace();
		            System.out.println("No se ha podido conectar con la base de datos");
		        }
		    }
		});


		btnBuscar.setBounds(486, 102, 85, 21);
		panel.add(btnBuscar);
		
		JLabel lblNewLabel = new JLabel("Equipos");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(266, 102, 79, 21);
		panel.add(lblNewLabel);
		setVisible(true);
		
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
}

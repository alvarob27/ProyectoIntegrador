package entrenadores;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import arbitro.ArbitDiseño;

import java.awt.Color;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class EntrenadorDiseño extends JFrame {
	private String nombre;
	private String apellidos;
	private int num_tarjetasAmarillas;
	private int num_tarjetasRojas;
	private String estado;
	private int debut;
	private int num_partidosArbitrados;
	private JTable table;
	
	
	public EntrenadorDiseño() {
		setBounds(100,100,861,578);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(119, 136, 153));
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblEntrenadores = new JLabel("entrenadores");
		lblEntrenadores.setForeground(new Color(255, 255, 255));
		lblEntrenadores.setFont(new Font("Star Jedi", Font.PLAIN, 21));
		lblEntrenadores.setBounds(297, 33, 201, 51);
		panel.add(lblEntrenadores);
		
	
		
	
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 130, 755, 38);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Nombre", "Apellidos", "Partidos Dirigidos", "Victorias", "Derrotas", "Empates", "Periodo", "Nacionalidad", "Expulsiones", "Edad"
			}
		));
		scrollPane.setViewportView(table);
		setVisible(true);

//--------------------------------------------------COMBOBOX ENTRENADORES---------------------------------------------------
		JComboBox comboEntrenadores = new JComboBox();
		comboEntrenadores.setBounds(326, 88, 109, 21);
		panel.add(comboEntrenadores);
		
		try {
			Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/apuestas","root","");
			Statement miStatement = miConexion.createStatement();
			ResultSet miResultSet = miStatement.executeQuery("SELECT nombre FROM entrenador");
			
			
			while(miResultSet.next()) {
				comboEntrenadores.addItem(miResultSet.getString("nombre"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("No se ha podido conectar con la base de datos");
		}
		
//-----------------------------------------------BOTON ENTRENADORES-----------------------------------------------------------
		JButton btnEntrenadores = new JButton("BUSCAR");
		btnEntrenadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					String entrenadorSeleccionado = (String) comboEntrenadores.getSelectedItem();
		        
		        try {
		            Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/apuestas","root","");
		            Statement miStatement = miConexion.createStatement();
		            String consulta = "SELECT * FROM entrenador WHERE nombre = '" + entrenadorSeleccionado + "'";
		            ResultSet miResultSet = miStatement.executeQuery(consulta);
		            
		       
		            DefaultTableModel model = new DefaultTableModel();
		            
		            
		            
		            model.addColumn("Nombre");
		            model.addColumn("Apellidos");
		            model.addColumn("Partidos Dirigidos");
		            model.addColumn("Victorias");
		            model.addColumn("Derrotas");
		            model.addColumn("Empates");
		            model.addColumn("Periodo");
		            model.addColumn("Nacionalidad");
		            model.addColumn("Expulsiones");
		            model.addColumn("Edad");
		            
		            
		            // Iterar sobre los registros del ResultSet y agregarlos al modelo
		            while (miResultSet.next()) {
		                String nombreArbitro = miResultSet.getString("nombre");
		                String apellidos = miResultSet.getString("apellidos");
		                int partidos = miResultSet.getInt("partidos_dirigidos");
		                int victorias = miResultSet.getInt("victorias");
		                int derrotas = miResultSet.getInt("derrotas");
		                int empates = miResultSet.getInt("empates");
		                int periodo = miResultSet.getInt("periodo");
		                String nacionalidad = miResultSet.getString("nacionalidad");
		                int expulsiones = miResultSet.getInt("num_expulsiones");
		                int edad = miResultSet.getInt("edad");
		                
		                model.addRow(new Object[]{nombreArbitro,apellidos,partidos,victorias,
		                		derrotas,empates,periodo,nacionalidad,expulsiones,edad});
		            }
		            
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
		btnEntrenadores.setBounds(445, 88, 103, 21);
		panel.add(btnEntrenadores);
		
		JLabel lblNewLabel = new JLabel("Entrenadores:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNewLabel.setBounds(227, 83, 96, 27);
		panel.add(lblNewLabel);
	}
	 public static void main(String[] args) {
	        EntrenadorDiseño entrenadorDiseño = new EntrenadorDiseño();
	        entrenadorDiseño.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        entrenadorDiseño.setSize(800, 600);
	        entrenadorDiseño.setVisible(true);
	    }
}


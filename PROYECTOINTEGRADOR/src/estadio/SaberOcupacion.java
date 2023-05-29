package estadio;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SaberOcupacion extends JFrame {
    private JTable table;

    public SaberOcupacion() {
    	setBounds(100,100,861,578);
        JPanel panel = new JPanel();
        panel.setBackground(new Color(119, 136, 153));
        getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);


        JLabel labelOcupacion = new JLabel("saber ocupacion del estadio");
        labelOcupacion.setFont(new Font("Star Jedi", Font.PLAIN, 21));
        labelOcupacion.setForeground(new Color(255, 255, 255));
        labelOcupacion.setBounds(236, 10, 402, 34);
        panel.add(labelOcupacion);

        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(50, 106, 674, 327);
        panel.add(scrollPane);

        table = new JTable();
        table.setModel(new DefaultTableModel(
                new Object[][] {
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        
                },
                new String[] {
                        "Nombre del Estadio", "Capacidad",  
                }
        ));
        scrollPane.setViewportView(table);
//----------------------------------------INSERTAMOS DATOS EN LA TABLA POR DEFECTO--------------------------------------------------------------------------------------------------
        
        try {
            Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/apuestas","root","");
            Statement miStatement = miConexion.createStatement();
            String consulta = "SELECT nombre,capacidad FROM estadio ORDER BY nombre DESC";
            ResultSet miResultSet = miStatement.executeQuery(consulta);
            
          
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Nombre");
            model.addColumn("Ocupacion");
            
    

            while (miResultSet.next()) {
                String nombre = miResultSet.getString("nombre");
                int capacidad = miResultSet.getInt("capacidad");
                model.addRow(new Object[]{nombre,capacidad});
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
        
//-------------------------------------------COMBO BOX DE LOS ESTADIOS --------------------------------------------------------
        JComboBox<String> comboOcupacion = new JComboBox<String>();
        comboOcupacion.setBounds(347, 54, 120, 21);
        panel.add(comboOcupacion);
        
      //CONEXION A LA BASE DE DATOS
        try {
			
        	Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/apuestas","root","");
			Statement statement = conexion.createStatement();
			ResultSet result = statement.executeQuery("SELECT nombre FROM estadio"); //salen en el combo todos los estadios
			
			while(result.next()) {
				comboOcupacion.addItem(result.getString("nombre"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("No se pudo conectar con la base de datos");
		}
        
        
        
        
        
//------------------------------------------------------------------------------------------------------------------------------------------
        
        JButton botonBuscar = new JButton("BUSCAR");
        botonBuscar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String estadio = (String)comboOcupacion.getSelectedItem();
        		
        		
        		try {
					Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/apuestas","root","");
					Statement miStatement = miConexion.createStatement();
		            String consulta = "SELECT * FROM estadio WHERE nombre = '" + estadio + "'";
		            ResultSet miResultSet = miStatement.executeQuery(consulta);
		            
		            
		            // Crear el DefaultTableModel con las columnas necesarias
		            DefaultTableModel model = new DefaultTableModel();
		            model.addColumn("Nombre del Estadio");
		            model.addColumn("Ocupación");
		            
		            // Iterar sobre los registros del ResultSet y agregarlos al modelo
		            while (miResultSet.next()) {
		                String nombreEstadio = miResultSet.getString("nombre");
		                int ocupacion = miResultSet.getInt("capacidad");
		               
		                
		                model.addRow(new Object[]{nombreEstadio, ocupacion});
		            }
		            // Asignar el modelo a la tabla
		            table.setModel(model);
		            
		            miResultSet.close();
		            miStatement.close();
		            miConexion.close();
		            
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        		
        		
        		
        	}
        });
        botonBuscar.setForeground(new Color(0, 0, 0));
        botonBuscar.setBounds(477, 54, 95, 21);
        panel.add(botonBuscar);
        
        JLabel lblNewLabel = new JLabel("Estadio:");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel.setBounds(287, 54, 75, 21);
        panel.add(lblNewLabel);
        
        
        
        
        
        
        
    }

    


    
    
    
    

    public static void main(String[] args) {
        SaberOcupacion estadio = new SaberOcupacion();
        estadio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        estadio.setSize(800, 600);
        estadio.setVisible(true);
    }
}


package estadio;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import appapuestas.Login;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class EstadioDiseño extends JFrame {

    private JTable table;
    
    public EstadioDiseño() {
		setBounds(100, 100, 861, 578);
		
        JPanel panel = new JPanel();
        panel.setBackground(new Color(119, 136, 153));
        getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JLabel lblEstadio = new JLabel("estadios de la liga");
        lblEstadio.setForeground(new Color(255, 255, 255));
        lblEstadio.setFont(new Font("Star Jedi", Font.PLAIN, 21));
        lblEstadio.setBounds(296, 10, 254, 29);
        panel.add(lblEstadio);


 
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(62, 105, 674, 327);
        panel.add(scrollPane);

        table = new JTable();
        table.setBackground(new Color(240, 248, 255));
        table.setModel(new DefaultTableModel(
                new Object[][] {
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                },
                new String[] {
                        "NOMBRE", "FECHA CONSTRUCCION", "CAPACIDAD",  
                }
        ));
        scrollPane.setViewportView(table);


//----------------------------------------INSERTAMOS DATOS EN LA TABLA POR DEFECTO--------------------------------------------------------------------------------------------------
        
        try {
            Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/apuestas","root","");
            Statement miStatement = miConexion.createStatement();
            String consulta = "SELECT * FROM estadio ORDER BY nombre DESC";
            ResultSet miResultSet = miStatement.executeQuery(consulta);
            
          
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Nombre");
            model.addColumn("Fecha Construccion");
            model.addColumn("Capacidad");
    

            while (miResultSet.next()) {
                String nombre = miResultSet.getString("nombre");
                int fecha = miResultSet.getInt("fecha_construccion");
                int capacidad = miResultSet.getInt("capacidad");
                model.addRow(new Object[]{nombre,fecha,capacidad});
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
    

//--------------------------------------------COMBO BOX + INSERTAR DATOS EN EL COMBO----------------------------------------------------------------------------------------      
        
        JComboBox<String> comboEstadio = new JComboBox<String>();
        comboEstadio.setBounds(338, 50, 120, 21);
        panel.add(comboEstadio);
        
        
        //CONEXION A LA BASE DE DATOS
        try {
			
        	Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/apuestas","root","");
			Statement statement = conexion.createStatement();
			ResultSet result = statement.executeQuery("SELECT nombre FROM estadio"); //salen en el combo todos los estadios
			
			while(result.next()) {
				comboEstadio.addItem(result.getString("nombre"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("No se pudo conectar con la base de datos");
		}
        
        
        
//------------------------------------------SACAR DATOS AL DARLE AL BOTON DE BUSCAR------------------------------------------------------------------------------      
        
        JButton botonBuscar = new JButton("BUSCAR");
        botonBuscar.setForeground(new Color(0, 0, 0));
        botonBuscar.setBounds(468, 49, 85, 32);
        botonBuscar.addActionListener(new ActionListener() {
        	
        	public void actionPerformed(ActionEvent e) {
        		//Boton de busqueda
                String estadioSeleccionado = (String) comboEstadio.getSelectedItem();
                
                try {
        			
                	Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/apuestas","root","");
        			Statement statement = conexion.createStatement();
        			String consulta = "SELECT * FROM estadio where nombre = '" + estadioSeleccionado + "'";
        			ResultSet resultset = statement.executeQuery(consulta);
        			
        			//Crear el default table model con las columnas necesarias
        			DefaultTableModel model = new DefaultTableModel();
        			model.addColumn("Nombre");
        			model.addColumn("Fecha de Construccion");
        			model.addColumn("Capacidad");
        			
        			
        			//Iteramos sobre los resultados encontrados y los agregamos
        			
        			while(resultset.next()) {
        				String estadioNombre = resultset.getString("nombre");
        				int fecha = resultset.getInt("fecha_construccion");
        				int capacidad = resultset.getInt("capacidad");
        				
        				model.addRow(new Object[] {estadioNombre,fecha,capacidad});
        			}
        			
        			
        			//Asignamos el modelo a la tabla
        			table.setModel(model);
        		    resultset.close();
                    statement.close();
                    conexion.close();
        			
        		} catch (SQLException f) {
        			// TODO Auto-generated catch block
        			f.printStackTrace();
        			System.out.println("No se pudo conectar con la base de datos");
        		}
        	}
        
        
        });
        
        
        botonBuscar.setBounds(468, 50, 85, 21);
        panel.add(botonBuscar);
        
        JLabel lblNewLabel = new JLabel("Estadios:");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblNewLabel.setBounds(274, 50, 67, 17);
        panel.add(lblNewLabel);

    }

    public static void main(String[] args) {
  
        EstadioDiseño estadio = new EstadioDiseño();
        estadio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        estadio.setSize(800, 600);
        estadio.setVisible(true);
    }
}


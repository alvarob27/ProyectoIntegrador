package arbitro;

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

public class MediaTarjetas extends JFrame {
    private JTable table;

    public MediaTarjetas() {
    	setBounds(100,100,861,578);
        JPanel panel = new JPanel();
        panel.setBackground(new Color(119, 136, 153));
        getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("media - tarjetas");
        lblNewLabel.setFont(new Font("Star Jedi", Font.PLAIN, 21));
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setBounds(277, 37, 250, 20);
        panel.add(lblNewLabel);

        JComboBox<String> comboTarjetas = new JComboBox<>();
        comboTarjetas.setBounds(312, 86, 120, 21);
        panel.add(comboTarjetas);

   

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(34, 131, 727, 37);
        panel.add(scrollPane);

        table = new JTable();
        table.setBackground(new Color(240, 248, 255));
        table.setModel(new DefaultTableModel(
        	new Object[][] {
        		{null, null, null, null, null, null},
        	},
        	new String[] {
        		"Nombre", "Apellidos", "Numero de Amarillas", "Numero de Rojas", "Numero de Partidos Arbitrados", "Media de Tarjetas/Partido"
        	}
        ));
        scrollPane.setViewportView(table);
        
        try {
        	
			Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/apuestas","root","");
			Statement miStatement = miConexion.createStatement();
			ResultSet miResultSet = miStatement.executeQuery("SELECT nombre FROM arbitro");
			
			while(miResultSet.next()) {
				comboTarjetas.addItem(miResultSet.getString("nombre"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("No se ha podido conectar con la base de datos");
		}    
        
        
        
        JButton btnBuscar = new JButton("BUSCAR");
        btnBuscar.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        		
        		String arbitroSeleccionado = (String) comboTarjetas.getSelectedItem();
        		
        		try {
					
        			Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/apuestas","root","");
					Statement miStatement = miConexion.createStatement();
					String consulta = ("SELECT * FROM arbitro WHERE nombre = '" + arbitroSeleccionado + "'");
					ResultSet miResultSet = miStatement.executeQuery(consulta);
					
					
					//Creamos el default model 
					DefaultTableModel model = new DefaultTableModel();
					model.addColumn("Nombre");
					model.addColumn("Apellidos");
					model.addColumn("Numero de Amarillas");
					model.addColumn("Numero de Rojas");
					model.addColumn("Numero de Partidos Arbitrados");
					model.addColumn("Media de Tarjetas/Partido");
					
					
					//Itera sobre los resultado
					while (miResultSet.next()) {
					    String arbitroNombre = miResultSet.getString("nombre");
					    String apellidos = miResultSet.getString("apellidos");
					    int tarjetasAmarillas = miResultSet.getInt("num_tarjetasAmarillas");
					    int tarjetasRojas = miResultSet.getInt("num_tarjetasRojas");
					    int partidosArbitrados = miResultSet.getInt("partidos_arbitrados");
					    
					    double mediaTarjetas = (tarjetasRojas + tarjetasAmarillas) / (double) partidosArbitrados;
					    mediaTarjetas = Math.round(mediaTarjetas * 100.0) / 100.0;
					    
					    model.addRow(new Object[]{arbitroNombre, apellidos, tarjetasAmarillas, tarjetasRojas, partidosArbitrados, mediaTarjetas});
					}

					
					
					//Asignamos el modelo a la tabla
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
        btnBuscar.setBounds(442, 86, 85, 21);
        panel.add(btnBuscar);
        
        JLabel lblNewLabel_1 = new JLabel("ARBITROS:");
        lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setBounds(231, 86, 95, 17);
        panel.add(lblNewLabel_1);
        
        
        
        
        
        
        
    }

    public static void main(String[] args) {
        MediaTarjetas mediaTarjetas = new MediaTarjetas();
        mediaTarjetas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mediaTarjetas.setSize(800, 600);
        mediaTarjetas.setVisible(true);
    }
}

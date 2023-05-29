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

public class MediaRojasPartido extends JFrame {
    private JTable table;

    public MediaRojasPartido() {
    	setBounds(100,100,861,578);
        JPanel panel = new JPanel();
        panel.setBackground(new Color(119, 136, 153));
        panel.setForeground(new Color(119, 136, 153));
        getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("media rojas - partido");
        lblNewLabel.setFont(new Font("Star Jedi", Font.PLAIN, 21));
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setBounds(254, 41, 309, 30);
        panel.add(lblNewLabel);

       
     

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(39, 147, 682, 42);
        panel.add(scrollPane);

        table = new JTable();
        table.setBackground(new Color(240, 248, 255));
        table.setModel(new DefaultTableModel(
        	new Object[][] {
        		{null, null, null, null, null},
        	},
        	new String[] {
        		"Nombre", "Apellidos", "Tarjetas Rojas", "Partidos Arbitrados", "Media"
        	}
        ));
        scrollPane.setViewportView(table);
        
//------------------------------------------COMBO BOX DE LOS ARBITROS--------------------------------------------------------------------        
        JComboBox<String> comboArb = new JComboBox<>();
        comboArb.setBounds(305, 92, 120, 21);
        panel.add(comboArb);

        try {
			Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/apuestas","root","");
			Statement miStatement = miConexion.createStatement();
			ResultSet miResultSet = miStatement.executeQuery("SELECT nombre FROM arbitro");
			
			
			while(miResultSet.next()) {
				comboArb.addItem(miResultSet.getString("nombre"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("No se ha podido conectar con la base de datos");
		}
        
//------------------------------------------BOTON DE BUSCAR -------------------------------------------------------------------------------------        
        
        JButton btnNewButton = new JButton("BUSCAR");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		String arbitroSeleccionado = (String) comboArb.getSelectedItem();
        		
        		try {
					
        			Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/apuestas","root","");
					Statement miStatement = miConexion.createStatement();
					String consulta = ("SELECT * FROM arbitro WHERE nombre = '" + arbitroSeleccionado + "'");
					ResultSet miResultSet = miStatement.executeQuery(consulta);
					
					
					//Creamos el default model 
					DefaultTableModel model = new DefaultTableModel();
					model.addColumn("Nombre");
					model.addColumn("Apellidos");
					model.addColumn("Numero de Rojas");
					model.addColumn("Partidos Arbitrados");
					model.addColumn("Media de Rojas/Partido");
					
					
					//Itera sobre los resultado
					while(miResultSet.next()) {
						String arbitroNombre = miResultSet.getString("nombre"); 
						String apellidos = miResultSet.getString("apellidos"); 
						int tarjetasRojas = miResultSet.getInt("num_tarjetasRojas"); 
						int partidosArbitrados = miResultSet.getInt("partidos_arbitrados"); 
						double mediaRojas = tarjetasRojas/(float)partidosArbitrados;
						mediaRojas = Math.round(mediaRojas * 100.0) / 100.0;
						
						model.addRow(new Object []{arbitroNombre,apellidos,tarjetasRojas,partidosArbitrados,mediaRojas});
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
        btnNewButton.setBounds(435, 92, 110, 21);
        panel.add(btnNewButton);
        
        JLabel lblNewLabel_1 = new JLabel("ARBITROS:");
        lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setBounds(227, 93, 98, 20);
        panel.add(lblNewLabel_1);
        
        
    }

    public static void main(String[] args) {
        MediaRojasPartido mediaRojasPartido = new MediaRojasPartido();
        mediaRojasPartido.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mediaRojasPartido.setSize(800, 600);
        mediaRojasPartido.setVisible(true);
    }
}

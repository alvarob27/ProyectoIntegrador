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
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ArbitDiseño extends JFrame {
    private JTable tableArbitro;

    public ArbitDiseño() {
        setBounds(100, 100, 861, 578);
        JPanel panel = new JPanel();
        panel.setBackground(new Color(119, 136, 153));
        getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JLabel lblArbitrosPrincipal = new JLabel("arbitros");
        lblArbitrosPrincipal.setForeground(new Color(255, 255, 255));
        lblArbitrosPrincipal.setFont(new Font("Star Jedi", Font.PLAIN, 21));
        lblArbitrosPrincipal.setBounds(335, 29, 133, 51);
        panel.add(lblArbitrosPrincipal);

  

        JScrollPane scrollPaneArbitro = new JScrollPane();
        scrollPaneArbitro.setBounds(60, 144, 674, 42);
        panel.add(scrollPaneArbitro);

        tableArbitro = new JTable();
        tableArbitro.setBackground(new Color(240, 248, 255));
        tableArbitro.setModel(new DefaultTableModel(
                new Object[][] {
                        {null, null, null, null, null, null, null},
                      
                },
                new String[] {
                        "Nombre", "Apellidos", "Tarjetas Amarillas", "Tarjetas Rojas", "Estado", "Debut", "Partidos Arbitrados"
                }
        ));
        
        
        
        JComboBox<String> comboArbitros = new JComboBox<>();
        comboArbitros.setBounds(335, 91, 120, 21);
        panel.add(comboArbitros);

        try {
            Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/apuestas", "root", "");
            Statement miStatement = miConexion.createStatement();
            ResultSet miResultSet = miStatement.executeQuery("SELECT nombre FROM arbitro");

            while (miResultSet.next()) {
                comboArbitros.addItem(miResultSet.getString("nombre"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("No se ha podido conectar con la base de datos");
        }

        JButton btnBuscarArbitro = new JButton("BUSCAR");
        btnBuscarArbitro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String arbitroSeleccionado = (String) comboArbitros.getSelectedItem();

                try {
                    Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/apuestas", "root", "");
                    Statement miStatement = miConexion.createStatement();
                    String consulta = "SELECT * FROM arbitro WHERE nombre = '" + arbitroSeleccionado + "'";
                    ResultSet miResultSet = miStatement.executeQuery(consulta);

                    // Crear el DefaultTableModel con las columnas necesarias
                    DefaultTableModel model = new DefaultTableModel();
                    model.addColumn("nombre");
                    model.addColumn("apellidos");
                    model.addColumn("mediaAmarillas");
                    model.addColumn("mediaPartidosArbitrados");
                    model.addColumn("Media");
                    
                
                    

                    // Iterar sobre los registros del ResultSet y agregarlos al modelo
                    while (miResultSet.next()) {
                        String nombreArbitro = miResultSet.getString("nombre");
                        String apellidoArbitro = miResultSet.getString("apellidos");
                        double mediaAmarillas = miResultSet.getDouble("num_tarjetasAmarillas");
                        double partidos_arbitradosArbitro = miResultSet.getDouble("partidos_arbitrados");
                        double media = mediaAmarillas / partidos_arbitradosArbitro;
                        media = Math.round(media * 100.0) / 100.0;
                        // Agrega los datos correspondientes al modelo
                        model.addRow(new Object[] { nombreArbitro, apellidoArbitro, mediaAmarillas, partidos_arbitradosArbitro, media  });
                    }

                    // Asigna el modelo a la tabla
                    tableArbitro.setModel(model);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    System.out.println("Error al buscar el arbitro");
                }
            }
        });

        btnBuscarArbitro.setBounds(475, 91, 85, 21);
        panel.add(btnBuscarArbitro);
        scrollPaneArbitro.setViewportView(tableArbitro);
        
        JLabel lblNewLabel = new JLabel("ARBITROS:");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblNewLabel.setBounds(256, 90, 133, 23);
        panel.add(lblNewLabel);
    }

    public static void main(String[] args) {
        ArbitDiseño arbitDiseño = new ArbitDiseño();
        arbitDiseño.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        arbitDiseño.setSize(800, 600);
        arbitDiseño.setVisible(true);
    }
}

package arbitro;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class MediaAmarillasPartido extends JFrame {
	private JTable tableMediaTarjetasAmarillas;
    private JComboBox<String> comboArbitros;

    public MediaAmarillasPartido() {
        setBounds(100, 100, 861, 578);
        JPanel panel = new JPanel();
        panel.setBackground(new Color(119, 136, 153));
        getContentPane().add(panel);
        panel.setLayout(null);

        JLabel lblTarjetasAmarillasPartido = new JLabel("Media tarjetas amarillas por partido");
        lblTarjetasAmarillasPartido.setForeground(new Color(255, 255, 255));
        lblTarjetasAmarillasPartido.setFont(new Font("Star Jedi", Font.PLAIN, 21));
        lblTarjetasAmarillasPartido.setBounds(141, 25, 507, 47);
        panel.add(lblTarjetasAmarillasPartido);

        JButton btnBuscarTarjetasAmarillas = new JButton("BUSCAR");
        btnBuscarTarjetasAmarillas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String arbitroSeleccionado = (String) comboArbitros.getSelectedItem();

                try {
                    Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/apuestas", "root", "");
                    Statement miStatement = miConexion.createStatement();
                    String consulta = "SELECT * FROM arbitro WHERE nombre = '" + arbitroSeleccionado + "'";
                    ResultSet miResultSet = miStatement.executeQuery(consulta);

                    DefaultTableModel model = new DefaultTableModel();
                    model.addColumn("Nombre");
                    model.addColumn("Apellidos");
                    model.addColumn("Tarjetas");
                    model.addColumn("Partidos Arbitrados");
                    model.addColumn("Media Amarillas");
                    while (miResultSet.next()) {
                        String nombreArbitro = miResultSet.getString("nombre");
                        String apellidoArbitro = miResultSet.getString("apellidos");
                        double tarjetasAmarillas = miResultSet.getDouble("num_tarjetasAmarillas");
                        int partidosArbitrados =  miResultSet.getInt("partidos_arbitrados");
                        double media = tarjetasAmarillas / partidosArbitrados;
                        model.addRow(new Object[]{nombreArbitro, apellidoArbitro, tarjetasAmarillas,partidosArbitrados, media });
                    }
                    tableMediaTarjetasAmarillas.setModel(model);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    System.out.println("Error al buscar el árbitro");
                }
            }
        });
        btnBuscarTarjetasAmarillas.setBounds(454, 83, 85, 21);
        panel.add(btnBuscarTarjetasAmarillas);

        JScrollPane scrollPaneMediaTarjetasAmarillas = new JScrollPane();
        scrollPaneMediaTarjetasAmarillas.setBounds(60, 141, 674, 37);
        panel.add(scrollPaneMediaTarjetasAmarillas);

        tableMediaTarjetasAmarillas = new JTable();
        tableMediaTarjetasAmarillas.setBackground(new Color(240, 248, 255));
        tableMediaTarjetasAmarillas.setModel(new DefaultTableModel(
        	new Object[][] {
        		{null, null, null, null},
        	},
        	new String[] {
        		"Nombre", "Tarjetas Amarillas", "Partidos Arbitrados", "Media"
        	}
        ));
        scrollPaneMediaTarjetasAmarillas.setViewportView(tableMediaTarjetasAmarillas);

        comboArbitros = new JComboBox<>();
        comboArbitros.setBounds(327, 83, 109, 21);
        panel.add(comboArbitros);
        
        JLabel lblNewLabel = new JLabel("Arbitros:");
        lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setBounds(257, 83, 70, 17);
        panel.add(lblNewLabel);
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
    }

    public static void main(String[] args) {
        MediaAmarillasPartido mediaAmarillasPartido = new MediaAmarillasPartido();
        mediaAmarillasPartido.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mediaAmarillasPartido.setSize(800, 600);
        mediaAmarillasPartido.setVisible(true);
    }
}
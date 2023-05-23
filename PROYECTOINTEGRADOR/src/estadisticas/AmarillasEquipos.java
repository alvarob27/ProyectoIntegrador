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
import java.awt.Color;

public class AmarillasEquipos extends JFrame {
    private JTable tableAmarillasEquipos;

    public AmarillasEquipos() {
    	setBounds(100,100,861,578);
        JPanel panelAmarillaEquipos = new JPanel();
        panelAmarillaEquipos.setBackground(new Color(119, 136, 153));
        getContentPane().add(panelAmarillaEquipos, BorderLayout.CENTER);
        panelAmarillaEquipos.setLayout(null);

        JLabel lblAmarillasEquipos = new JLabel("AMARILLAS - EQUIPOS");
        lblAmarillasEquipos.setForeground(new Color(255, 255, 255));
        lblAmarillasEquipos.setFont(new Font("Tahoma", Font.PLAIN, 24));
        lblAmarillasEquipos.setBounds(269, 10, 278, 30);
        panelAmarillaEquipos.add(lblAmarillasEquipos);

        JButton btnBuscar = new JButton("BUSCAR");
        btnBuscar.setBounds(419, 50, 85, 21);
        panelAmarillaEquipos.add(btnBuscar);

        JScrollPane scrollPaneAmarillasEquipos = new JScrollPane();
        scrollPaneAmarillasEquipos.setBounds(50, 106, 674, 327);
        panelAmarillaEquipos.add(scrollPaneAmarillasEquipos);

        tableAmarillasEquipos = new JTable();
        tableAmarillasEquipos.setForeground(new Color(240, 248, 255));
        tableAmarillasEquipos.setModel(new DefaultTableModel(
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
                        {null, null},
                },
                new String[] {
                        "EQUIPO","AMARILLAS",  
                }
        ));
        scrollPaneAmarillasEquipos.setViewportView(tableAmarillasEquipos);

        JComboBox<String> comboAmarillasEquipos = new JComboBox<String>();
        comboAmarillasEquipos.setBounds(279, 50, 120, 21);
        panelAmarillaEquipos.add(comboAmarillasEquipos);
    }

    public static void main(String[] args) {
        AmarillasEquipos estadio = new AmarillasEquipos();
        estadio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        estadio.setSize(800, 600);
        estadio.setVisible(true);
    }
}

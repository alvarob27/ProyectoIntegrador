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
import java.awt.Color;
import java.awt.Font;

public class PasesTotalesPorEquipos extends JFrame {
    private JTable tablePasesTotales;

    public PasesTotalesPorEquipos() {
    	setBounds(100,100,861,578);
        JPanel panelPasesTotales = new JPanel();
        panelPasesTotales.setBackground(new Color(119, 136, 153));
        getContentPane().add(panelPasesTotales, BorderLayout.CENTER);
        panelPasesTotales.setLayout(null);

        JLabel lblPasesTotales = new JLabel("PASES TOTALES  ENFRENTAMIENTOS EQUIPOS");
        lblPasesTotales.setFont(new Font("Tahoma", Font.PLAIN, 24));
        lblPasesTotales.setForeground(new Color(255, 255, 255));
        lblPasesTotales.setBounds(146, 26, 539, 20);
        panelPasesTotales.add(lblPasesTotales);

        JComboBox<String> comboPasesTotales = new JComboBox<>();
        comboPasesTotales.setBounds(231, 56, 120, 21);
        panelPasesTotales.add(comboPasesTotales);

        JButton btnPasesTotales = new JButton("BUSCAR");
        btnPasesTotales.setBounds(491, 56, 85, 21);
        panelPasesTotales.add(btnPasesTotales);

        JScrollPane scrollPanePasesTotales = new JScrollPane();
        scrollPanePasesTotales.setBounds(76, 105, 674, 327);
        panelPasesTotales.add(scrollPanePasesTotales);

        tablePasesTotales = new JTable();
        tablePasesTotales.setForeground(new Color(240, 248, 255));
        tablePasesTotales.setModel(new DefaultTableModel(
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
                },
                new String[] {
                        "Equipo", "Pases Local", "Pases Visitante", "Total", 
                }
        ));
        scrollPanePasesTotales.setViewportView(tablePasesTotales);
        
        JComboBox<String> comboPasesTotales2 = new JComboBox<String>();
        comboPasesTotales2.setBounds(361, 56, 120, 21);
        panelPasesTotales.add(comboPasesTotales2);
    }

    public static void main(String[] args) {
        PasesTotalesPorEquipos pasesTotalesPorEquipos = new PasesTotalesPorEquipos();
        pasesTotalesPorEquipos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pasesTotalesPorEquipos.setSize(800, 600);
        pasesTotalesPorEquipos.setVisible(true);
    }
}

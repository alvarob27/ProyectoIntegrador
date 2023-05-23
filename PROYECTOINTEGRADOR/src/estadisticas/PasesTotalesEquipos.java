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

public class PasesTotalesEquipos extends JFrame {
    private JTable tablePasesTotales;

    public PasesTotalesEquipos() {
    	setBounds(100,100,861,578);
        JPanel panelPasesTotales = new JPanel();
        panelPasesTotales.setBackground(new Color(119, 136, 153));
        getContentPane().add(panelPasesTotales, BorderLayout.CENTER);
        panelPasesTotales.setLayout(null);

        JLabel lblPasesTotales = new JLabel("PASES TOTALES - EQUIPOS");
        lblPasesTotales.setForeground(new Color(255, 255, 255));
        lblPasesTotales.setFont(new Font("Tahoma", Font.PLAIN, 24));
        lblPasesTotales.setBounds(248, 23, 315, 29);
        panelPasesTotales.add(lblPasesTotales);

        JComboBox<String> comboPasesTotales = new JComboBox<>();
        comboPasesTotales.setBounds(231, 62, 120, 21);
        panelPasesTotales.add(comboPasesTotales);

        JButton btnPasesTotales = new JButton("BUSCAR");
        btnPasesTotales.setBounds(491, 62, 85, 21);
        panelPasesTotales.add(btnPasesTotales);

        JScrollPane scrollPanePasesTotales = new JScrollPane();
        scrollPanePasesTotales.setBounds(50, 106, 674, 327);
        panelPasesTotales.add(scrollPanePasesTotales);

        tablePasesTotales = new JTable();
        tablePasesTotales.setBackground(new Color(240, 248, 255));
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
        comboPasesTotales2.setBounds(361, 62, 120, 21);
        panelPasesTotales.add(comboPasesTotales2);
    }

    public static void main(String[] args) {
        PasesTotalesEquipos pasesTotalesEquipos = new PasesTotalesEquipos();
        pasesTotalesEquipos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pasesTotalesEquipos.setSize(800, 600);
        pasesTotalesEquipos.setVisible(true);
    }
}

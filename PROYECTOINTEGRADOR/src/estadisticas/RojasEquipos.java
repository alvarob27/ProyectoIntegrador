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

public class RojasEquipos extends JFrame {
    private JTable tableRojas;

    public RojasEquipos() {
    	setBounds(100,100,861,578);
        JPanel panelRojas = new JPanel();
        panelRojas.setBackground(new Color(119, 136, 153));
        getContentPane().add(panelRojas, BorderLayout.CENTER);
        panelRojas.setLayout(null);

        JLabel lblRojas = new JLabel("ROJAS POR EQUIPOS");
        lblRojas.setForeground(new Color(255, 255, 255));
        lblRojas.setFont(new Font("Tahoma", Font.PLAIN, 24));
        lblRojas.setBounds(295, 20, 247, 20);
        panelRojas.add(lblRojas);

        JButton btnRojas = new JButton("BUSCAR");
        btnRojas.setBounds(435, 61, 85, 21);
        panelRojas.add(btnRojas);

        JScrollPane scrollPaneRojas = new JScrollPane();
        scrollPaneRojas.setBounds(50, 106, 674, 327);
        panelRojas.add(scrollPaneRojas);

        tableRojas = new JTable();
        tableRojas.setBackground(new Color(240, 248, 255));
        tableRojas.setModel(new DefaultTableModel(
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
                        "EQUIPO", "JUGADOR", "ROJAS",  
                }
        ));
        scrollPaneRojas.setViewportView(tableRojas);

        JComboBox<String> comboRojas = new JComboBox<String>();
        comboRojas.setBounds(295, 61, 120, 21);
        panelRojas.add(comboRojas);
    }

    public static void main(String[] args) {
        RojasEquipos estadio = new RojasEquipos();
        estadio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        estadio.setSize(800, 600);
        estadio.setVisible(true);
    }
}


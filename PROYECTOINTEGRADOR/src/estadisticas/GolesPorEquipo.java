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

public class GolesPorEquipo extends JFrame {
    private JTable tableGolesEJ;

    public GolesPorEquipo() {
    	setBounds(100,100,861,578);
        JPanel panelGolesEJ = new JPanel();
        panelGolesEJ.setBackground(new Color(119, 136, 153));
        getContentPane().add(panelGolesEJ, BorderLayout.CENTER);
        panelGolesEJ.setLayout(null);

        JLabel lbLGolesEJ = new JLabel("GOLES POR EQUIPO Y JUGADOR");
        lbLGolesEJ.setFont(new Font("Tahoma", Font.PLAIN, 24));
        lbLGolesEJ.setForeground(new Color(255, 255, 255));
        lbLGolesEJ.setBounds(217, 10, 370, 20);
        panelGolesEJ.add(lbLGolesEJ);

        JComboBox<String> comboGolesEJ = new JComboBox<>();
        comboGolesEJ.setBounds(217, 40, 122, 21);
        panelGolesEJ.add(comboGolesEJ);

        JButton btnGolesEJ = new JButton("BUSCAR");
        btnGolesEJ.setBounds(481, 40, 85, 21);
        panelGolesEJ.add(btnGolesEJ);

        JScrollPane scrollPaneGolesEJ = new JScrollPane();
        scrollPaneGolesEJ.setBounds(53, 89, 687, 330);
        panelGolesEJ.add(scrollPaneGolesEJ);

        tableGolesEJ = new JTable();
        tableGolesEJ.setBackground(new Color(240, 248, 255));
        tableGolesEJ.setModel(new DefaultTableModel(
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
                        "Nombre", "Apellidos", "Equipo", "Goles"
                }
        ));
        scrollPaneGolesEJ.setViewportView(tableGolesEJ);
        
        JComboBox<String> comboGolesEJ2 = new JComboBox<String>();
        comboGolesEJ2.setBounds(349, 40, 122, 21);
        panelGolesEJ.add(comboGolesEJ2);
    }

    public static void main(String[] args) {
        GolesPorEquipo golesPorEquipo = new GolesPorEquipo();
        golesPorEquipo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        golesPorEquipo.setSize(800, 600);
        golesPorEquipo.setVisible(true);
    }
}


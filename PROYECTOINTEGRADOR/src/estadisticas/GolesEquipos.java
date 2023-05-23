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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GolesEquipos extends JFrame {
    private JTable tableGolesEquipos;

    public GolesEquipos() {
    	setBounds(100,100,861,578);
        JPanel panelGolesEquipos = new JPanel();
        panelGolesEquipos.setBackground(new Color(119, 136, 153));
        getContentPane().add(panelGolesEquipos, BorderLayout.CENTER);
        panelGolesEquipos.setLayout(null);

        JLabel lblGolesEquipos = new JLabel("GOLES EQUIPOS");
        lblGolesEquipos.setFont(new Font("Tahoma", Font.PLAIN, 24));
        lblGolesEquipos.setForeground(new Color(255, 255, 255));
        lblGolesEquipos.setBounds(325, 18, 203, 29);
        panelGolesEquipos.add(lblGolesEquipos);

        JComboBox<String> comboGolesEquipos = new JComboBox<>();
        comboGolesEquipos.setBounds(288, 57, 122, 21);
        panelGolesEquipos.add(comboGolesEquipos);

        JButton btnGolesEquipos = new JButton("BUSCAR");
        btnGolesEquipos.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnGolesEquipos.setBounds(432, 57, 85, 21);
        panelGolesEquipos.add(btnGolesEquipos);

        JScrollPane scrollPaneGolesEquipos = new JScrollPane();
        scrollPaneGolesEquipos.setBounds(25, 113, 739, 328);
        panelGolesEquipos.add(scrollPaneGolesEquipos);

        tableGolesEquipos = new JTable();
        tableGolesEquipos.setBackground(new Color(240, 248, 255));
        tableGolesEquipos.setModel(new DefaultTableModel(
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
                        "Nombre", "Goles a Favor", "Goles en Contra ", "Media"
                }
        ));
        scrollPaneGolesEquipos.setViewportView(tableGolesEquipos);
    }

    public static void main(String[] args) {
        GolesEquipos golesEquipos = new GolesEquipos();
        golesEquipos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        golesEquipos.setSize(800, 600);
        golesEquipos.setVisible(true);
    }
}

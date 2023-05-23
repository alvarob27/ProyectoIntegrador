package jugadores;

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

public class JugadoresMediaGoles extends JFrame {
    private JTable table;

    public JugadoresMediaGoles() {
    	setBounds(100, 100, 861, 578);
        JPanel panel = new JPanel();
        panel.setBackground(new Color(119, 136, 153));
        getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("JUGADORES");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setBounds(333, 100, 92, 20);
        panel.add(lblNewLabel);


        JButton btnNewButton = new JButton("BUSCAR");
        btnNewButton.setBounds(581, 100, 85, 21);
        panel.add(btnNewButton);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(86, 165, 674, 327);
        panel.add(scrollPane);

        table = new JTable();
        table.setBackground(new Color(240, 248, 255));
        table.setModel(new DefaultTableModel(
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
                		"GOLES", "PARTIDOS JUGADOS", "JUGADOR"
                }
        ));
        scrollPane.setViewportView(table);
        
        JComboBox<String> comboBox_1 = new JComboBox<String>();
        comboBox_1.setBounds(435, 100, 107, 21);
        panel.add(comboBox_1);
        
        JLabel lblNewLabel_1 = new JLabel("EQUIPOS");
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setBounds(91, 104, 85, 13);
        panel.add(lblNewLabel_1);
        
        JComboBox comboBox = new JComboBox();
        comboBox.setBounds(186, 100, 107, 21);
        panel.add(comboBox);
        
        JLabel lblNewLabel_2 = new JLabel("media goles de jugadores");
        lblNewLabel_2.setForeground(new Color(255, 255, 255));
        lblNewLabel_2.setFont(new Font("Star Jedi", Font.PLAIN, 21));
        lblNewLabel_2.setBounds(231, 25, 465, 59);
        panel.add(lblNewLabel_2);
    }

    public static void main(String[] args) {
        JugadoresMediaGoles jugadores = new JugadoresMediaGoles();
        jugadores.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jugadores.setSize(800, 600);
        jugadores.setVisible(true);
    }
}

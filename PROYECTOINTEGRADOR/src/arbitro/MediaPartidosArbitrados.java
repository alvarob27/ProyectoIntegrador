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
import java.awt.Color;

public class MediaPartidosArbitrados extends JFrame {
    private JTable table;

    public MediaPartidosArbitrados() {
    	setBounds(100,100,861,578);
    	JPanel panel = new JPanel();
    	panel.setBackground(new Color(119, 136, 153));
        getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("MEDIA - PARTIDOS ARBITRADOS");
        lblNewLabel.setForeground(new Color(240, 248, 255));
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
        lblNewLabel.setBounds(201, 20, 383, 29);
        panel.add(lblNewLabel);

        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.setBounds(244, 61, 120, 21);
        panel.add(comboBox);

        JButton btnNewButton = new JButton("BUSCAR");
        btnNewButton.setBounds(389, 61, 85, 21);
        panel.add(btnNewButton);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(50, 106, 674, 327);
        panel.add(scrollPane);

        table = new JTable();
        table.setForeground(new Color(240, 248, 255));
        table.setModel(new DefaultTableModel(
                new Object[][] {
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                },
                new String[] {
                        "Nombre", "Apellidos", "Partidos Arbitrados", 
                }
        ));
        scrollPane.setViewportView(table);
    }

    public static void main(String[] args) {
        MediaPartidosArbitrados mediaPartidosArbitrados = new MediaPartidosArbitrados();
        mediaPartidosArbitrados.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mediaPartidosArbitrados.setSize(800, 600);
        mediaPartidosArbitrados.setVisible(true);
    }
}

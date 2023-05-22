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

public class GolesPorEquipo extends JFrame {
    private JTable table;

    public GolesPorEquipo() {
        JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("GOLES POR EQUIPO Y JUGADOR");
        lblNewLabel.setBounds(111, 34, 202, 20);
        panel.add(lblNewLabel);

        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.setBounds(340, 34, 122, 21);
        panel.add(comboBox);

        JButton btnNewButton = new JButton("BUSCAR");
        btnNewButton.setBounds(626, 34, 85, 21);
        panel.add(btnNewButton);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(97, 87, 687, 330);
        panel.add(scrollPane);

        table = new JTable();
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
                },
                new String[] {
                        "Nombre", "Apellidos", "Equipo", "Goles"
                }
        ));
        scrollPane.setViewportView(table);
        
        JComboBox<String> comboBox_1 = new JComboBox<String>();
        comboBox_1.setBounds(472, 34, 122, 21);
        panel.add(comboBox_1);
    }

    public static void main(String[] args) {
        GolesPorEquipo golesPorEquipo = new GolesPorEquipo();
        golesPorEquipo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        golesPorEquipo.setSize(800, 600);
        golesPorEquipo.setVisible(true);
    }
}


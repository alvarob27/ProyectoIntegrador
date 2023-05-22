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

public class GolesEquipos extends JFrame {
    private JTable table;

    public GolesEquipos() {
        JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("GOLES EQUIPOS");
        lblNewLabel.setBounds(221, 27, 112, 20);
        panel.add(lblNewLabel);

        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.setBounds(372, 27, 122, 21);
        panel.add(comboBox);

        JButton btnNewButton = new JButton("BUSCAR");
        btnNewButton.setBounds(539, 27, 85, 21);
        panel.add(btnNewButton);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(71, 113, 739, 328);
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
                        "Nombre", "Goles a Favor", "Goles en Contra ", "Media"
                }
        ));
        scrollPane.setViewportView(table);
    }

    public static void main(String[] args) {
        GolesEquipos golesEquipos = new GolesEquipos();
        golesEquipos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        golesEquipos.setSize(800, 600);
        golesEquipos.setVisible(true);
    }
}

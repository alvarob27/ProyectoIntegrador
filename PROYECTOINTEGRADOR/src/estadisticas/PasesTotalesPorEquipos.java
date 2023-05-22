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

public class PasesTotalesPorEquipos extends JFrame {
    private JTable table;

    public PasesTotalesPorEquipos() {
        JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("PASES TOTALES  ENFRENTAMIENTOS EQUIPOS");
        lblNewLabel.setBounds(10, 50, 307, 20);
        panel.add(lblNewLabel);

        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.setBounds(316, 50, 120, 21);
        panel.add(comboBox);

        JButton btnNewButton = new JButton("BUSCAR");
        btnNewButton.setBounds(600, 50, 85, 21);
        panel.add(btnNewButton);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(50, 106, 674, 327);
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
                        "Equipo", "Pases Local", "Pases Visitante", "Total", 
                }
        ));
        scrollPane.setViewportView(table);
        
        JComboBox<String> comboBox_1 = new JComboBox<String>();
        comboBox_1.setBounds(457, 50, 120, 21);
        panel.add(comboBox_1);
    }

    public static void main(String[] args) {
        PasesTotalesPorEquipos pasesTotalesPorEquipos = new PasesTotalesPorEquipos();
        pasesTotalesPorEquipos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pasesTotalesPorEquipos.setSize(800, 600);
        pasesTotalesPorEquipos.setVisible(true);
    }
}

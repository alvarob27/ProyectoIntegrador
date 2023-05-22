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

public class AmarillasJugadores extends JFrame {
    private JTable table;

    public AmarillasJugadores() {
        JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("AmarillasJugador");
        lblNewLabel.setBounds(295, 50, 129, 20);
        panel.add(lblNewLabel);

        JButton btnNewButton = new JButton("BUSCAR");
        btnNewButton.setBounds(573, 50, 85, 21);
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
                        {null, null, null, null},
                },
                new String[] {
                        "JUGADOR", "EQUIPO", "AMARILLAS",  
                }
        ));
        scrollPane.setViewportView(table);

        JComboBox<String> comboBox_1 = new JComboBox<String>();
        comboBox_1.setBounds(422, 50, 120, 21);
        panel.add(comboBox_1);
    }

    public static void main(String[] args) {
        AmarillasJugadores estadio = new AmarillasJugadores();
        estadio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        estadio.setSize(800, 600);
        estadio.setVisible(true);
    }
}

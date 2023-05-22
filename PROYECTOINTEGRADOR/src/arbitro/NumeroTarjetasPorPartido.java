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

public class NumeroTarjetasPorPartido extends JFrame {
    private JTable table;

    public NumeroTarjetasPorPartido() {
        JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("NUMERO TARJETAS PARTIDO");
        lblNewLabel.setBounds(144, 50, 250, 20);
        panel.add(lblNewLabel);

        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.setBounds(376, 50, 120, 21);
        panel.add(comboBox);

        JButton btnNewButton = new JButton("BUSCAR");
        btnNewButton.setBounds(521, 50, 85, 21);
        panel.add(btnNewButton);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(50, 106, 674, 327);
        panel.add(scrollPane);

        table = new JTable();
        table.setModel(new DefaultTableModel(
                new Object[][] {
                        {null, null, null,null,null,null},
                        {null, null, null,null,null,null},
                        {null, null, null,null,null,null},
                        {null, null, null,null,null,null},
                        {null, null, null,null,null,null},
                        {null, null, null,null,null,null},
                        {null, null, null,null,null,null},
                        {null, null, null,null,null,null},
                        {null, null, null,null,null,null},
                        {null, null, null,null,null,null},
                        {null, null, null,null,null,null},
                        {null, null, null,null,null,null},
                        {null, null, null,null,null,null},
                        {null, null, null,null,null,null},
                        {null, null, null,null,null,null},
                        {null, null, null,null,null,null},
                        {null, null, null,null,null,null},
                        {null, null, null,null,null,null},
                        {null, null, null,null,null,null},
                        {null, null, null,null,null,null}
                },
                new String[] {
                        "Nombre", "Apellidos", "Partidos Arbitrados", "Tarjetas Amarillas","Tarjetas Rojas","Saldo"
                }
        ));
        scrollPane.setViewportView(table);
    }

    public static void main(String[] args) {
        NumeroTarjetasPorPartido numeroTarjetasPorPartido = new NumeroTarjetasPorPartido();
        numeroTarjetasPorPartido.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        numeroTarjetasPorPartido.setSize(800, 600);
        numeroTarjetasPorPartido.setVisible(true);
    }
}

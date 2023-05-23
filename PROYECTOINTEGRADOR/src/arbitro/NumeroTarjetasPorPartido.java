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
import java.awt.Color;
import java.awt.Font;

public class NumeroTarjetasPorPartido extends JFrame {
    private JTable table;

    public NumeroTarjetasPorPartido() {
    	setBounds(100,100,861,578);
        JPanel panel = new JPanel();
        panel.setBackground(new Color(119, 136, 153));
        getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("NUMERO TARJETAS PARTIDO");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setBounds(258, 22, 344, 30);
        panel.add(lblNewLabel);

        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.setBounds(286, 62, 120, 21);
        panel.add(comboBox);

        JButton btnNewButton = new JButton("BUSCAR");
        btnNewButton.setBounds(434, 62, 85, 21);
        panel.add(btnNewButton);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(57, 114, 674, 327);
        panel.add(scrollPane);

        table = new JTable();
        table.setBackground(new Color(240, 248, 255));
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

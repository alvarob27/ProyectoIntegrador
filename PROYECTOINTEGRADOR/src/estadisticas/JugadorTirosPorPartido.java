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
import java.awt.Font;
import java.awt.Color;

public class JugadorTirosPorPartido extends JFrame {
    private JTable table;

    public JugadorTirosPorPartido() {
    	
    	setBounds(100,100,861,578);
        JPanel panelTirosPuerta = new JPanel();
        panelTirosPuerta.setBackground(new Color(119, 136, 153));
        getContentPane().add(panelTirosPuerta, BorderLayout.CENTER);
        panelTirosPuerta.setLayout(null);

        JLabel lblTirosPuerta = new JLabel("TIROS A PUERTA POR PARTIDO");
        lblTirosPuerta.setForeground(new Color(255, 255, 255));
        lblTirosPuerta.setFont(new Font("Tahoma", Font.PLAIN, 24));
        lblTirosPuerta.setBounds(228, 10, 390, 29);
        panelTirosPuerta.add(lblTirosPuerta);

        JComboBox<String> comboTirosPuerta = new JComboBox<>();
        comboTirosPuerta.setBounds(228, 50, 120, 21);
        panelTirosPuerta.add(comboTirosPuerta);

        JButton btnTirosPuerta = new JButton("BUSCAR");
        btnTirosPuerta.setBounds(488, 49, 85, 21);
        panelTirosPuerta.add(btnTirosPuerta);

        JScrollPane scrollPaneTirosPuerta = new JScrollPane();
        scrollPaneTirosPuerta.setBounds(72, 105, 674, 327);
        panelTirosPuerta.add(scrollPaneTirosPuerta);

        table = new JTable();
        table.setBackground(new Color(240, 248, 255));
        table.setModel(new DefaultTableModel(
                new Object[][] {
                        {null,null, null, null, null},
                        {null,null, null, null, null},
                        {null,null, null, null, null},
                        {null,null, null, null, null},
                        {null,null, null, null, null},
                        {null,null, null, null, null},
                        {null,null, null, null, null},
                        {null,null, null, null, null},
                        {null,null, null, null, null},
                        {null,null, null, null, null},
                        {null,null, null, null, null},
                        {null,null, null, null, null},
                        {null,null, null, null, null},
                        {null,null, null, null, null},
                        {null,null, null, null, null},
                        {null,null, null, null, null},
                        {null,null, null, null, null},
                        {null,null, null, null, null},
                        {null,null, null, null, null},
                },
                new String[] {
                        "Equipo","Nombre", "Tiros Totales", "Tiros a Puerta", "Porcentaje de Tiros a Puerta", 
                }
        ));
        scrollPaneTirosPuerta.setViewportView(table);
        
        JComboBox<String> comboTirosPuerta2 = new JComboBox<String>();
        comboTirosPuerta2.setBounds(358, 50, 120, 21);
        panelTirosPuerta.add(comboTirosPuerta2);
    }

    public static void main(String[] args) {
        JugadorTirosPorPartido tirosPuertaPorPartido = new JugadorTirosPorPartido();
        tirosPuertaPorPartido.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tirosPuertaPorPartido.setSize(800, 600);
        tirosPuertaPorPartido.setVisible(true);
    }
}

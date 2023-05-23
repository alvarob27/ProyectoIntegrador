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

public class TirosPuertaPorPartido extends JFrame {
    private JTable tableTirosPuerta;

    public TirosPuertaPorPartido() {
    	setBounds(100,100,861,578);
        JPanel panelTirosPuerta = new JPanel();
        panelTirosPuerta.setBackground(new Color(119, 136, 153));
        getContentPane().add(panelTirosPuerta, BorderLayout.CENTER);
        panelTirosPuerta.setLayout(null);

        JLabel lblTirosPuerta = new JLabel("TIROS A PUERTA POR PARTIDO");
        lblTirosPuerta.setFont(new Font("Tahoma", Font.PLAIN, 24));
        lblTirosPuerta.setForeground(new Color(255, 255, 255));
        lblTirosPuerta.setBounds(233, 10, 375, 29);
        panelTirosPuerta.add(lblTirosPuerta);

        JComboBox<String> comboTirosPuerta = new JComboBox<>();
        comboTirosPuerta.setBounds(233, 50, 120, 21);
        panelTirosPuerta.add(comboTirosPuerta);

        JButton btnTirosPuerta = new JButton("BUSCAR");
        btnTirosPuerta.setBounds(493, 50, 85, 21);
        panelTirosPuerta.add(btnTirosPuerta);

        JScrollPane scrollPaneTirosPuerta = new JScrollPane();
        scrollPaneTirosPuerta.setBounds(50, 106, 674, 327);
        panelTirosPuerta.add(scrollPaneTirosPuerta);

        tableTirosPuerta = new JTable();
        tableTirosPuerta.setBackground(new Color(240, 248, 255));
        tableTirosPuerta.setModel(new DefaultTableModel(
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
                        "Equipo", "Tiros a Puerta", "Numero de Partidos", "Porcentaje de Tiros a Puerta", 
                }
        ));
        scrollPaneTirosPuerta.setViewportView(tableTirosPuerta);
        
        JComboBox<String> comboTirosPuerta2 = new JComboBox<String>();
        comboTirosPuerta2.setBounds(363, 50, 120, 21);
        panelTirosPuerta.add(comboTirosPuerta2);
    }

    public static void main(String[] args) {
        TirosPuertaPorPartido tirosPuertaPorPartido = new TirosPuertaPorPartido();
        tirosPuertaPorPartido.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tirosPuertaPorPartido.setSize(800, 600);
        tirosPuertaPorPartido.setVisible(true);
    }
}

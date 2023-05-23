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

public class TirosPorPartido extends JFrame {
    private JTable tableTirosPartidos;

    public TirosPorPartido() {
    	setBounds(100,100,861,578);
        JPanel panelTirosPartidos = new JPanel();
        panelTirosPartidos.setBackground(new Color(119, 136, 153));
        getContentPane().add(panelTirosPartidos, BorderLayout.CENTER);
        panelTirosPartidos.setLayout(null);

        JLabel lblTirosPartidos = new JLabel("TIROS POR PARTIDO");
        lblTirosPartidos.setFont(new Font("Tahoma", Font.PLAIN, 24));
        lblTirosPartidos.setForeground(new Color(255, 255, 255));
        lblTirosPartidos.setBounds(278, 10, 269, 30);
        panelTirosPartidos.add(lblTirosPartidos);

        JComboBox<String> comboTirosPartidos = new JComboBox<>();
        comboTirosPartidos.setBounds(229, 50, 120, 21);
        panelTirosPartidos.add(comboTirosPartidos);

        JButton btnTirosPartidos = new JButton("BUSCAR");
        btnTirosPartidos.setBounds(489, 50, 85, 21);
        panelTirosPartidos.add(btnTirosPartidos);

        JScrollPane scrollPaneTirosPartidos = new JScrollPane();
        scrollPaneTirosPartidos.setBounds(50, 106, 674, 327);
        panelTirosPartidos.add(scrollPaneTirosPartidos);

        tableTirosPartidos = new JTable();
        tableTirosPartidos.setBackground(new Color(240, 248, 255));
        tableTirosPartidos.setModel(new DefaultTableModel(
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
                        "Equipo", "Tiros Totales", "Partidos", "Porcentaje de Tiros", 
                }
        ));
        scrollPaneTirosPartidos.setViewportView(tableTirosPartidos);
        
        JComboBox<String> comboTirosPartidos2 = new JComboBox<String>();
        comboTirosPartidos2.setBounds(359, 50, 120, 21);
        panelTirosPartidos.add(comboTirosPartidos2);
    }

    public static void main(String[] args) {
        TirosPorPartido tirosPorPartido = new TirosPorPartido();
        tirosPorPartido.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tirosPorPartido.setSize(800, 600);
        tirosPorPartido.setVisible(true);
    }
}

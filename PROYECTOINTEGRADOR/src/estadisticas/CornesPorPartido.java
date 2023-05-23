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

public class CornesPorPartido extends JFrame {
    private JTable tableCornersPartido;

    public CornesPorPartido() {
    	setBounds(100,100,861,578);
        JPanel panelCornersPartido = new JPanel();
        panelCornersPartido.setBackground(new Color(119, 136, 153));
        getContentPane().add(panelCornersPartido, BorderLayout.CENTER);
        panelCornersPartido.setLayout(null);

        JLabel lblCornersPartido = new JLabel("CORNERS POR PARTIDO");
        lblCornersPartido.setFont(new Font("Tahoma", Font.PLAIN, 24));
        lblCornersPartido.setForeground(new Color(255, 255, 255));
        lblCornersPartido.setBounds(273, 10, 276, 39);
        panelCornersPartido.add(lblCornersPartido);

        JButton btnCornersPartido = new JButton("BUSCAR");
        btnCornersPartido.setBounds(428, 59, 85, 21);
        panelCornersPartido.add(btnCornersPartido);

        JScrollPane scrollPaneCornersPartido = new JScrollPane();
        scrollPaneCornersPartido.setBounds(50, 106, 674, 327);
        panelCornersPartido.add(scrollPaneCornersPartido);

        tableCornersPartido = new JTable();
        tableCornersPartido.setBackground(new Color(240, 248, 255));
        tableCornersPartido.setModel(new DefaultTableModel(
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
                        "PARTIDO", "EQUIPO", "CORNERS",  
                }
        ));
        scrollPaneCornersPartido.setViewportView(tableCornersPartido);

        JComboBox<String> comboCornersPartido = new JComboBox<String>();
        comboCornersPartido.setBounds(295, 59, 120, 21);
        panelCornersPartido.add(comboCornersPartido);
    }

    public static void main(String[] args) {
        CornesPorPartido estadio = new CornesPorPartido();
        estadio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        estadio.setSize(800, 600);
        estadio.setVisible(true);
    }
}

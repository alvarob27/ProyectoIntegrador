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

public class PosesionPorEquipos extends JFrame {
    private JTable table;

    public PosesionPorEquipos() {
    	setBounds(100,100,861,578);
        JPanel panelPosesionBalon = new JPanel();
        panelPosesionBalon.setBackground(new Color(119, 136, 153));
        getContentPane().add(panelPosesionBalon, BorderLayout.CENTER);
        panelPosesionBalon.setLayout(null);

        JLabel lblPosesionBalon = new JLabel("POSESIÓN DE BALÓN - EQUIPOS");
        lblPosesionBalon.setForeground(new Color(255, 255, 255));
        lblPosesionBalon.setFont(new Font("Tahoma", Font.PLAIN, 24));
        lblPosesionBalon.setBounds(228, 11, 362, 29);
        panelPosesionBalon.add(lblPosesionBalon);

        JComboBox<String> comboPosesionBalon = new JComboBox<>();
        comboPosesionBalon.setBounds(238, 50, 120, 21);
        panelPosesionBalon.add(comboPosesionBalon);

        JButton btnPosesionBalon = new JButton("BUSCAR");
        btnPosesionBalon.setBounds(498, 50, 85, 21);
        panelPosesionBalon.add(btnPosesionBalon);

        JScrollPane scrollPanePosesionBalon = new JScrollPane();
        scrollPanePosesionBalon.setBounds(65, 106, 674, 327);
        panelPosesionBalon.add(scrollPanePosesionBalon);

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
                        "Equipo", "Tiempo de Posesión", "Tiempos Muertos", "Porcentaje de Posesión", 
                }
        ));
        scrollPanePosesionBalon.setViewportView(table);
        
        JComboBox<String> comboPosesionBalon2 = new JComboBox<String>();
        comboPosesionBalon2.setBounds(368, 50, 120, 21);
        panelPosesionBalon.add(comboPosesionBalon2);
    }

    public static void main(String[] args) {
        PosesionPorEquipos posesionPorEquipos = new PosesionPorEquipos();
        posesionPorEquipos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        posesionPorEquipos.setSize(800, 600);
        posesionPorEquipos.setVisible(true);
    }
}

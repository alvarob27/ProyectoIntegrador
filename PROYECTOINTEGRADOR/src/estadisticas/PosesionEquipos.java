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

public class PosesionEquipos extends JFrame {
    private JTable tablePosesion;

    public PosesionEquipos() {
    	setBounds(100,100,861,578);
        JPanel panelPosesion = new JPanel();
        panelPosesion.setBackground(new Color(119, 136, 153));
        getContentPane().add(panelPosesion, BorderLayout.CENTER);
        panelPosesion.setLayout(null);

        JLabel lblPosesion = new JLabel("POSESIÓN DE BALÓN - EQUIPOS");
        lblPosesion.setForeground(new Color(255, 255, 255));
        lblPosesion.setBackground(new Color(255, 255, 255));
        lblPosesion.setFont(new Font("Tahoma", Font.PLAIN, 24));
        lblPosesion.setBounds(230, 10, 381, 29);
        panelPosesion.add(lblPosesion);

        JComboBox<String> comboPosesion = new JComboBox<>();
        comboPosesion.setBounds(240, 50, 120, 21);
        panelPosesion.add(comboPosesion);

        JButton btnPosesion = new JButton("BUSCAR");
        btnPosesion.setBounds(500, 49, 85, 21);
        panelPosesion.add(btnPosesion);

        JScrollPane scrollPanePosesion = new JScrollPane();
        scrollPanePosesion.setBounds(71, 106, 674, 327);
        panelPosesion.add(scrollPanePosesion);

        tablePosesion = new JTable();
        tablePosesion.setModel(new DefaultTableModel(
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
                        "Equipo", "Posesion Local", "Posesion Visitante", "Porcentaje de Posesión", 
                }
        ));
        scrollPanePosesion.setViewportView(tablePosesion);
        
        JComboBox<String> comboPosesion2 = new JComboBox<String>();
        comboPosesion2.setBounds(370, 50, 120, 21);
        panelPosesion.add(comboPosesion2);
    }

    public static void main(String[] args) {
        PosesionEquipos posesionEquipos = new PosesionEquipos();
        posesionEquipos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        posesionEquipos.setSize(800, 600);
        posesionEquipos.setVisible(true);
    }
}

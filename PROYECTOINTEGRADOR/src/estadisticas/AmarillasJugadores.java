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

public class AmarillasJugadores extends JFrame {
    private JTable tableAmarillasJugador;
    private JLabel lblAmarillasJugador;

    public AmarillasJugadores() {
    	setBounds(100,100,861,578);
        JPanel panelAmarillasJugador = new JPanel();
        panelAmarillasJugador.setBackground(new Color(119, 136, 153));
        getContentPane().add(panelAmarillasJugador, BorderLayout.CENTER);
        panelAmarillasJugador.setLayout(null);

        lblAmarillasJugador = new JLabel("AMARILLAS - JUGADOR");
        lblAmarillasJugador.setFont(new Font("Tahoma", Font.PLAIN, 24));
        lblAmarillasJugador.setForeground(new Color(255, 255, 255));
        lblAmarillasJugador.setBounds(260, 22, 298, 29);
        panelAmarillasJugador.add(lblAmarillasJugador);

        JButton btnAmarillasJugador = new JButton("BUSCAR");
        btnAmarillasJugador.setBounds(423, 61, 85, 21);
        panelAmarillasJugador.add(btnAmarillasJugador);

        JScrollPane scrollPaneAmarillasJugador = new JScrollPane();
        scrollPaneAmarillasJugador.setBounds(50, 106, 674, 327);
        panelAmarillasJugador.add(scrollPaneAmarillasJugador);

        tableAmarillasJugador = new JTable();
        tableAmarillasJugador.setBackground(new Color(240, 248, 255));
        tableAmarillasJugador.setModel(new DefaultTableModel(
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
        scrollPaneAmarillasJugador.setViewportView(tableAmarillasJugador);

        JComboBox<String> comboAmarillasJugador = new JComboBox<String>();
        comboAmarillasJugador.setBounds(270, 61, 120, 21);
        panelAmarillasJugador.add(comboAmarillasJugador);
    }

    public static void main(String[] args) {
        AmarillasJugadores estadio = new AmarillasJugadores();
        estadio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        estadio.setSize(800, 600);
        estadio.setVisible(true);
    }
}

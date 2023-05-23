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

public class RojasJugadores extends JFrame {
    private JTable tableRojasJugadores;

    public RojasJugadores() {
    	setBounds(100,100,861,578);
        JPanel panelRojasJugadores = new JPanel();
        panelRojasJugadores.setBackground(new Color(119, 136, 153));
        getContentPane().add(panelRojasJugadores, BorderLayout.CENTER);
        panelRojasJugadores.setLayout(null);

        JLabel lblRojasJugadores = new JLabel("ROJAS JUGADORES");
        lblRojasJugadores.setFont(new Font("Tahoma", Font.PLAIN, 24));
        lblRojasJugadores.setForeground(new Color(255, 255, 255));
        lblRojasJugadores.setBounds(302, 10, 230, 20);
        panelRojasJugadores.add(lblRojasJugadores);

        JButton btnRojasJugadores = new JButton("BUSCAR");
        btnRojasJugadores.setBounds(491, 50, 85, 21);
        panelRojasJugadores.add(btnRojasJugadores);

        JScrollPane scrollPaneRojasJugadores = new JScrollPane();
        scrollPaneRojasJugadores.setBounds(65, 106, 674, 327);
        panelRojasJugadores.add(scrollPaneRojasJugadores);

        tableRojasJugadores = new JTable();
        tableRojasJugadores.setBackground(new Color(240, 248, 255));
        tableRojasJugadores.setModel(new DefaultTableModel(
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
                        "JUGADOR", "EQUIPO", "ROJAS",  
                }
        ));
        scrollPaneRojasJugadores.setViewportView(tableRojasJugadores);

        JComboBox<String> comboRojasJugadores = new JComboBox<String>();
        comboRojasJugadores.setBounds(231, 50, 120, 21);
        panelRojasJugadores.add(comboRojasJugadores);
        
        JComboBox<String> comboRojasJugadores2 = new JComboBox<String>();
        comboRojasJugadores2.setBounds(361, 50, 120, 21);
        panelRojasJugadores.add(comboRojasJugadores2);
    }

    public static void main(String[] args) {
        RojasJugadores estadio = new RojasJugadores();
        estadio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        estadio.setSize(800, 600);
        estadio.setVisible(true);
    }
}

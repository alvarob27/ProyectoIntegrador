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

public class JugadorPasesPorPartido extends JFrame {
    private JTable tablePasesJugadorPartido;

    public JugadorPasesPorPartido() {
    	setBounds(100,100,861,578);
        JPanel panelPasesJugadorPartido = new JPanel();
        panelPasesJugadorPartido.setBackground(new Color(119, 136, 153));
        getContentPane().add(panelPasesJugadorPartido, BorderLayout.CENTER);
        panelPasesJugadorPartido.setLayout(null);

        JLabel lblPasesJugadorPartido = new JLabel("PASES POR PARTIDO - JUGADORES");
        lblPasesJugadorPartido.setForeground(new Color(255, 255, 255));
        lblPasesJugadorPartido.setFont(new Font("Tahoma", Font.PLAIN, 26));
        lblPasesJugadorPartido.setBounds(174, 10, 454, 37);
        panelPasesJugadorPartido.add(lblPasesJugadorPartido);

        JComboBox<String> comboPasesJugadorPartido = new JComboBox<>();
        comboPasesJugadorPartido.setBounds(211, 57, 120, 21);
        panelPasesJugadorPartido.add(comboPasesJugadorPartido);

        JButton btnPasesJugadorPartido = new JButton("BUSCAR");
        btnPasesJugadorPartido.setBounds(472, 57, 85, 21);
        panelPasesJugadorPartido.add(btnPasesJugadorPartido);

        JScrollPane scrollPanePasesJugadorPartido = new JScrollPane();
        scrollPanePasesJugadorPartido.setBounds(50, 106, 674, 327);
        panelPasesJugadorPartido.add(scrollPanePasesJugadorPartido);

        tablePasesJugadorPartido = new JTable();
        tablePasesJugadorPartido.setBackground(new Color(240, 248, 255));
        tablePasesJugadorPartido.setModel(new DefaultTableModel(
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
                        "Jugador", "Pases Realizados", "Partidos Jugados", "Porcentaje de Éxito", 
                }
        ));
        scrollPanePasesJugadorPartido.setViewportView(tablePasesJugadorPartido);
        
        JComboBox<String> comboPasesJugadorPartido2 = new JComboBox<String>();
        comboPasesJugadorPartido2.setBounds(341, 57, 120, 21);
        panelPasesJugadorPartido.add(comboPasesJugadorPartido2);
    }

    public static void main(String[] args) {
        JugadorPasesPorPartido jugadorPasesPorPartido = new JugadorPasesPorPartido();
        jugadorPasesPorPartido.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jugadorPasesPorPartido.setSize(800, 600);
        jugadorPasesPorPartido.setVisible(true);
    }
}


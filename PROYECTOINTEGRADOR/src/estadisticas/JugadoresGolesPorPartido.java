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

public class JugadoresGolesPorPartido extends JFrame {
    private JTable tableJugadoresGolesPartido;

    public JugadoresGolesPorPartido() {
    	setBounds(100,100,861,578);
        JPanel panelJugadoresGolesPartido = new JPanel();
        panelJugadoresGolesPartido.setBackground(new Color(119, 136, 153));
        getContentPane().add(panelJugadoresGolesPartido, BorderLayout.CENTER);
        panelJugadoresGolesPartido.setLayout(null);

        JLabel lblJugadoresGolesPartido = new JLabel("JUGADORES - GOLES POR PARTIDO");
        lblJugadoresGolesPartido.setForeground(new Color(255, 255, 255));
        lblJugadoresGolesPartido.setFont(new Font("Tahoma", Font.PLAIN, 24));
        lblJugadoresGolesPartido.setBackground(new Color(255, 255, 255));
        lblJugadoresGolesPartido.setBounds(197, 13, 401, 27);
        panelJugadoresGolesPartido.add(lblJugadoresGolesPartido);

        JComboBox<String> comboJugadoresGolesPartido = new JComboBox<>();
        comboJugadoresGolesPartido.setBounds(207, 50, 120, 21);
        panelJugadoresGolesPartido.add(comboJugadoresGolesPartido);

        JButton btnJugadoresGolesPartido = new JButton("BUSCAR");
        btnJugadoresGolesPartido.setBounds(467, 50, 85, 21);
        panelJugadoresGolesPartido.add(btnJugadoresGolesPartido);

        JScrollPane scrollPaneJugadoresGolesPartido = new JScrollPane();
        scrollPaneJugadoresGolesPartido.setBounds(50, 106, 659, 327);
        panelJugadoresGolesPartido.add(scrollPaneJugadoresGolesPartido);

        tableJugadoresGolesPartido = new JTable();
        tableJugadoresGolesPartido.setModel(new DefaultTableModel(
                new Object[][] {
                        {null, null, null, null,null,null},
                        {null, null, null, null,null,null},
                        {null, null, null, null,null,null},
                        {null, null, null, null,null,null},
                        {null, null, null, null,null,null},
                        {null, null, null, null,null,null},
                        {null, null, null, null,null,null},
                        {null, null, null, null,null,null},
                        {null, null, null, null,null,null},
                        {null, null, null, null,null,null},
                        {null, null, null, null,null,null},
                        {null, null, null, null,null,null},
                        {null, null, null, null,null,null},
                        {null, null, null, null,null,null},
                        {null, null, null, null,null,null},
                        {null, null, null, null,null,null},
                        {null, null, null, null,null,null},
                        {null, null, null, null,null,null},
                        {null, null, null, null,null,null},
                },
                new String[] {
                        "Nombre", "Apellidos", "Equipo", "Goles", "Partidos Jugados", "Saldo"
                }
        ));
        scrollPaneJugadoresGolesPartido.setViewportView(tableJugadoresGolesPartido);
        
        JComboBox<String> comboJugadoresGolesPartido2 = new JComboBox<String>();
        comboJugadoresGolesPartido2.setBounds(337, 50, 120, 21);
        panelJugadoresGolesPartido.add(comboJugadoresGolesPartido2);
    }

    public static void main(String[] args) {
        JugadoresGolesPorPartido jugadoresGolesPorPartido = new JugadoresGolesPorPartido();
        jugadoresGolesPorPartido.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jugadoresGolesPorPartido.setSize(800, 600);
        jugadoresGolesPorPartido.setVisible(true);
    }
}


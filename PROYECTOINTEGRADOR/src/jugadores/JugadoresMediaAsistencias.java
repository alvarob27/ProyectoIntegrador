package jugadores;

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

public class JugadoresMediaAsistencias extends JFrame {
    private JTable table;

    public JugadoresMediaAsistencias() {
    	setBounds(100, 100, 861, 578);
        JPanel panel = new JPanel();
        panel.setBackground(new Color(119, 136, 153));
        getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JLabel lblJugadores = new JLabel("JUGADORES");
        lblJugadores.setForeground(new Color(255, 255, 255));
        lblJugadores.setBounds(344, 95, 120, 20);
        panel.add(lblJugadores);


        JButton btnBuscar = new JButton("BUSCAR");
        btnBuscar.setForeground(new Color(0, 0, 0));
        btnBuscar.setBounds(593, 95, 85, 21);
        panel.add(btnBuscar);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(86, 146, 674, 327);
        panel.add(scrollPane);

        table = new JTable();
        table.setBackground(new Color(240, 248, 255));
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
                        {null, null, null, null},
                },
                new String[] {
                		"MEDIA  ASISTENCIAS", "PARTIDOS JUGADOS", "JUGADOR"
                }
        ));
        scrollPane.setViewportView(table);
        
        JComboBox<String> comboJugadores = new JComboBox<String>();
        comboJugadores.setBounds(428, 95, 120, 21);
        panel.add(comboJugadores);
        
        JLabel lblEquipos = new JLabel("EQUIPOS");
        lblEquipos.setForeground(new Color(255, 255, 255));
        lblEquipos.setBackground(new Color(255, 255, 255));
        lblEquipos.setBounds(101, 99, 120, 13);
        panel.add(lblEquipos);
        
        JComboBox comboBox = new JComboBox();
        comboBox.setBounds(181, 95, 120, 21);
        panel.add(comboBox);
        
        JLabel lblTitulo = new JLabel("media de asistencias de jugadores");
        lblTitulo.setForeground(new Color(255, 255, 255));
        lblTitulo.setFont(new Font("Star Jedi", Font.PLAIN, 21));
        lblTitulo.setBounds(194, 35, 522, 47);
        panel.add(lblTitulo);
    }

    public static void main(String[] args) {
        JugadoresMediaAsistencias jugadores = new JugadoresMediaAsistencias();
        jugadores.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jugadores.setSize(800, 600);
        jugadores.setVisible(true);
        
        
    }
}

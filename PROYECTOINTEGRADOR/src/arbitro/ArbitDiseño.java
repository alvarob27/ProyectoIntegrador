package arbitro;

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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ArbitDiseño extends JFrame {
    private JTable tableArbitro;

    public ArbitDiseño() {
    	setBounds(100,100,861,578);
        JPanel panel = new JPanel();
        panel.setBackground(new Color(119, 136, 153));
        getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JLabel lblArbitrosPrincipal = new JLabel("ARBITROS");
        lblArbitrosPrincipal.setForeground(new Color(255, 255, 255));
        lblArbitrosPrincipal.setFont(new Font("Tahoma", Font.PLAIN, 24));
        lblArbitrosPrincipal.setBounds(313, 10, 133, 51);
        panel.add(lblArbitrosPrincipal);

        JComboBox<String> comboArbitros = new JComboBox<>();
        comboArbitros.setBounds(242, 61, 120, 21);
        panel.add(comboArbitros);

        JButton btnBuscarArbitro = new JButton("BUSCAR");
        btnBuscarArbitro.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnBuscarArbitro.setBounds(393, 61, 85, 21);
        panel.add(btnBuscarArbitro);

        JScrollPane scrollPaneArbitro = new JScrollPane();
        scrollPaneArbitro.setBounds(50, 106, 674, 327);
        panel.add(scrollPaneArbitro);

        tableArbitro = new JTable();
        tableArbitro.setBackground(new Color(240, 248, 255));
        tableArbitro.setModel(new DefaultTableModel(
                new Object[][] {
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                },
                new String[] {
                		"Nombre", "Apellidos", "Tarjetas Amarillas", "Tarjetas Rojas", "Estado", "Debut", "Partidos Arbitrados"
                }
        ));
        scrollPaneArbitro.setViewportView(tableArbitro);
    }

    public static void main(String[] args) {
        ArbitDiseño arbitDiseño = new ArbitDiseño();
        arbitDiseño.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        arbitDiseño.setSize(800, 600);
        arbitDiseño.setVisible(true);
    }
}

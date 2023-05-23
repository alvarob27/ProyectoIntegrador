package arbitro;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class MediaAmarillasPartido extends JFrame {
    private JTable tableMediaTarjetasAmarillas;

    public MediaAmarillasPartido() {
    	setBounds(100,100,861,578);
        JPanel panel = new JPanel();
        panel.setBackground(new Color(119, 136, 153));
        getContentPane().add(panel);
        panel.setLayout(null);

        JLabel lblTarjetasAmarillasPartido = new JLabel("MEDIA - TARJETAS AMARILLAS POR PARTIDO");
        lblTarjetasAmarillasPartido.setForeground(new Color(255, 255, 255));
        lblTarjetasAmarillasPartido.setFont(new Font("Tahoma", Font.PLAIN, 24));
        lblTarjetasAmarillasPartido.setBounds(170, 27, 507, 47);
        panel.add(lblTarjetasAmarillasPartido);

        JButton btnBuscarTarjetasAmarillas = new JButton("BUSCAR");
        btnBuscarTarjetasAmarillas.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnBuscarTarjetasAmarillas.setBounds(422, 84, 85, 21);
        panel.add(btnBuscarTarjetasAmarillas);

        JScrollPane scrollPaneMediaTarjetasAmarillas = new JScrollPane();
        scrollPaneMediaTarjetasAmarillas.setBounds(60, 141, 674, 203);
        panel.add(scrollPaneMediaTarjetasAmarillas);

        tableMediaTarjetasAmarillas = new JTable();
        tableMediaTarjetasAmarillas.setBackground(new Color(240, 248, 255));
        tableMediaTarjetasAmarillas.setModel(new DefaultTableModel(
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
        	},
        	new String[] {
        		"Nombre", "Tarjetas Amarillas", "Partidos Arbitrados", "Media"
        	}
        ));
        scrollPaneMediaTarjetasAmarillas.setViewportView(tableMediaTarjetasAmarillas);
        
        JComboBox comboMediaTarjetasAmarillas = new JComboBox();
        comboMediaTarjetasAmarillas.setBounds(303, 84, 92, 21);
        panel.add(comboMediaTarjetasAmarillas);
    }

    public static void main(String[] args) {
        MediaAmarillasPartido mediaAmarillasPartido = new MediaAmarillasPartido();
        mediaAmarillasPartido.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mediaAmarillasPartido.setSize(800, 600);
        mediaAmarillasPartido.setVisible(true);
    }
}

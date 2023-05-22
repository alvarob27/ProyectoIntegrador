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

public class MediaAmarillasPartido extends JFrame {
    private JTable table;

    public MediaAmarillasPartido() {
        JPanel panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("MEDIA - TARJETAS AMARILLAS POR PARTIDO");
        lblNewLabel.setBounds(89, 83, 294, 20);
        panel.add(lblNewLabel);

        JButton btnNewButton = new JButton("BUSCAR");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnNewButton.setBounds(535, 83, 85, 21);
        panel.add(btnNewButton);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(52, 168, 674, 203);
        panel.add(scrollPane);

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
        	},
        	new String[] {
        		"Nombre", "Tarjetas Amarillas", "Partidos Arbitrados", "Media"
        	}
        ));
        scrollPane.setViewportView(table);
        
        JComboBox comboBox = new JComboBox();
        comboBox.setBounds(393, 83, 92, 21);
        panel.add(comboBox);
    }

    public static void main(String[] args) {
        MediaAmarillasPartido mediaAmarillasPartido = new MediaAmarillasPartido();
        mediaAmarillasPartido.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mediaAmarillasPartido.setSize(800, 600);
        mediaAmarillasPartido.setVisible(true);
    }
}

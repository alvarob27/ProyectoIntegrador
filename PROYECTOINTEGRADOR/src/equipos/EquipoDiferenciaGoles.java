package equipos;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class EquipoDiferenciaGoles extends JFrame{
	
	public static void main(String[] args) {

		EquipoDiferenciaGoles window = new EquipoDiferenciaGoles();
		window.setBounds(100, 100, 749, 533);
		

}
	private JTable table;
	public EquipoDiferenciaGoles() {
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DIFERENCIA DE GOLES");
		lblNewLabel.setBounds(208, 39, 156, 29);
		panel.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(45, 114, 620, 330);
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
				"Equipo", "Goles", "Goles Contra", "Promedio"
			}
		));
		scrollPane.setViewportView(table);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(355, 43, 98, 21);
		panel.add(comboBox);
		
		JButton btnNewButton = new JButton("BUSCAR");
		btnNewButton.setBounds(477, 43, 85, 21);
		panel.add(btnNewButton);
		setVisible(true);
	}
}

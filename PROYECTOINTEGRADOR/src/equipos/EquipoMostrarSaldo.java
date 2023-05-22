package equipos;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import java.awt.ScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Label;
import java.awt.Panel;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class EquipoMostrarSaldo extends JFrame{
	
	public static void main(String[] args) {

		EquipoMostrarSaldo window = new EquipoMostrarSaldo();
		window.setBounds(100, 100, 749, 533);
		

}
	private JTable table;
	public EquipoMostrarSaldo() {
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SALDO DE LOS EQUIPOS");
		lblNewLabel.setBounds(148, 33, 189, 28);
		panel.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 85, 651, 329);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Equipo", "Victorias", "Empates", "Derrotas", "Saldo"
			}
		));
		scrollPane.setViewportView(table);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(326, 37, 115, 21);
		panel.add(comboBox);
		
		JButton btnNewButton = new JButton("BUSCAR");
		btnNewButton.setBounds(470, 37, 85, 21);
		panel.add(btnNewButton);
		setVisible(true);
	}
}

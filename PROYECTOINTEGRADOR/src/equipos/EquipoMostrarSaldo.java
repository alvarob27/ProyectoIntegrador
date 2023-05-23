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
import java.awt.Color;
import java.awt.Font;

public class EquipoMostrarSaldo extends JFrame{
	
	private JTable table;
	public EquipoMostrarSaldo() {
		setBounds(100, 100, 861, 578);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(119, 136, 153));
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblTitulo = new JLabel("saldo de equipos");
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setFont(new Font("Star Jedi", Font.PLAIN, 21));
		lblTitulo.setBounds(308, 20, 364, 55);
		panel.add(lblTitulo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(98, 174, 651, 329);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(240, 248, 255));
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
		
		JComboBox comboEquipos = new JComboBox();
		comboEquipos.setBounds(364, 110, 115, 21);
		panel.add(comboEquipos);
		
		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.setBounds(501, 110, 85, 21);
		panel.add(btnBuscar);
		
		JLabel lbl = new JLabel("EQUIPOS");
		lbl.setForeground(new Color(255, 255, 255));
		lbl.setBounds(288, 103, 102, 34);
		panel.add(lbl);
		setVisible(true);
	}
}

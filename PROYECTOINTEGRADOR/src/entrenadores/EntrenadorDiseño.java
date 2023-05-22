package entrenadores;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.JScrollPane;



public class EntrenadorDiseño extends JPanel {
	private String nombre;
	private String apellidos;
	private int num_tarjetasAmarillas;
	private int num_tarjetasRojas;
	private String estado;
	private int debut;
	private int num_partidosArbitrados;
	private JTable table;
	
	
	public EntrenadorDiseño() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ENTRENADOR");
		lblNewLabel.setBounds(10, 8, 84, 29);
		add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Boton Entrenador");
		btnNewButton.setBackground(new Color(255, 255, 0));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBounds(262, 11, 122, 23);
		add(btnNewButton);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(104, 11, 112, 22);
		add(comboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 45, 430, 244);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"NOMBRE", "APELLIDO", "VICTORIAS", "DERROTAS",  "PERIODO", "EXPULSIONES", "EDAD", "NACIONALIDAD", "PARTIDOS DIRIGIDOS",
			}
		));
		scrollPane.setViewportView(table);

	}

}


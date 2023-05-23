package equipos;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import java.awt.ScrollPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Label;
import java.awt.Panel;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EquipoMostrarSaldo extends JFrame {

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
		scrollPane.setBounds(98, 174, 651, 39);
		panel.add(scrollPane);

		table = new JTable();
		table.setBackground(new Color(240, 248, 255));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"Equipo", "Victorias", "Empates", "Derrotas", "Saldo"
			}
		));
		scrollPane.setViewportView(table);

		JComboBox comboEquipos = new JComboBox();
		comboEquipos.setBounds(327, 110, 152, 21);
		panel.add(comboEquipos);

		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String equipoSeleccionado = (String) comboEquipos.getSelectedItem();

				try {
					Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/apuestas", "root",
							"");
					Statement miStatement = miConexion.createStatement();
					String consulta = "SELECT nombre,victorias,empates,derrotas FROM equipo WHERE nombre = '" + equipoSeleccionado + "'";
					ResultSet miResultSet = miStatement.executeQuery(consulta);

					// Crear el DefaultTableModel con las columnas necesarias
					DefaultTableModel model = new DefaultTableModel();
					model.addColumn("Equipo");
					model.addColumn("Victorias");
					model.addColumn("Empates");
					model.addColumn("Derrotas");
					model.addColumn("Saldo");
					

					// Iterar sobre los registros del ResultSet y agregarlos al modelo
					while (miResultSet.next()) {
						String nombreEquipo = miResultSet.getString("nombre");
						int victorias = miResultSet.getInt("victorias");
						int empates = miResultSet.getInt("empates");
						int derrotas = miResultSet.getInt("derrotas");
						int saldo = victorias - (empates+derrotas);
						

						model.addRow(new Object[] { nombreEquipo, victorias, empates, derrotas, saldo });
					}

					// Asignar el modelo a la tabla
					table.setModel(model);

					miResultSet.close();
					miStatement.close();
					miConexion.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
					System.out.println("No se ha podido conectar con la base de datos");
				}

			}
		});
		btnBuscar.setBounds(501, 110, 85, 21);
		panel.add(btnBuscar);

		JLabel lbl = new JLabel("EQUIPOS");
		lbl.setForeground(new Color(255, 255, 255));
		lbl.setBounds(250, 103, 102, 34);
		panel.add(lbl);
		setVisible(true);

		try {
			Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/apuestas", "root", "");
			Statement miStatement = miConexion.createStatement();
			ResultSet miResultSet = miStatement.executeQuery("SELECT nombre FROM equipo");

			while (miResultSet.next()) {
				comboEquipos.addItem(miResultSet.getString("nombre"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("No se ha podido conectar con la base de datos");
		}
	}
}

package appapuestas;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class MenuPrincipal extends JFrame {

	private JPanel contentPane;
	static Login frame = new Login();
	private JTable table;
	
	public static void main(String[] args) {
		frame.setVisible(true);

	}
	
	public MenuPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 861, 578);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(new Color(119, 136, 153));
		setJMenuBar(menuBar);
		
		JMenu mnEquipo = new JMenu("Equipos");
		mnEquipo.setBackground(new Color(119, 136, 153));
		mnEquipo.setForeground(new Color(0, 0, 0));
		mnEquipo.setFont(new Font("Monospaced", Font.PLAIN, 12));
		menuBar.add(mnEquipo);
		
		JMenuItem mntmMostrarJugadores = new JMenuItem("Mostrar Jugadores");
		mntmMostrarJugadores.setFont(new Font("Monospaced", Font.PLAIN, 12));
		mnEquipo.add(mntmMostrarJugadores);
		
		JMenuItem mntmDiferenciaGoles = new JMenuItem("Diferencia de goles");
		mntmDiferenciaGoles.setFont(new Font("Monospaced", Font.PLAIN, 12));
		mnEquipo.add(mntmDiferenciaGoles);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Mostrar Saldo");
		mntmNewMenuItem.setFont(new Font("Monospaced", Font.PLAIN, 12));
		mnEquipo.add(mntmNewMenuItem);
		
		JMenu mnJugadores = new JMenu("Jugadores");
		mnJugadores.setForeground(new Color(0, 0, 0));
		mnJugadores.setFont(new Font("Monospaced", Font.PLAIN, 12));
		menuBar.add(mnJugadores);
		
		JMenuItem mntmMediaGoles = new JMenuItem("Media de goles");
		mntmMediaGoles.setFont(new Font("Monospaced", Font.PLAIN, 12));
		mnJugadores.add(mntmMediaGoles);
		
		JMenuItem mntmMediaAsistencias = new JMenuItem("Media de asistencias");
		mntmMediaAsistencias.setFont(new Font("Monospaced", Font.PLAIN, 12));
		mnJugadores.add(mntmMediaAsistencias);
		
		JMenu mnEstadisticas = new JMenu("Estadisticas");
		mnEstadisticas.setForeground(new Color(0, 0, 0));
		mnEstadisticas.setFont(new Font("Monospaced", Font.PLAIN, 12));
		menuBar.add(mnEstadisticas);
		
		JMenuItem mntmGoles = new JMenuItem("Goles");
		mntmGoles.setFont(new Font("Monospaced", Font.PLAIN, 12));
		mnEstadisticas.add(mntmGoles);
		
		JMenuItem mntmPases = new JMenuItem("Pases");
		mntmPases.setFont(new Font("Monospaced", Font.PLAIN, 12));
		mnEstadisticas.add(mntmPases);
		
		JMenuItem mntmPosesion = new JMenuItem("Posesión");
		mntmPosesion.setFont(new Font("Monospaced", Font.PLAIN, 12));
		mnEstadisticas.add(mntmPosesion);
		
		JMenuItem mntmTiros = new JMenuItem("Tiros");
		mntmTiros.setFont(new Font("Monospaced", Font.PLAIN, 12));
		mnEstadisticas.add(mntmTiros);
		
		JMenuItem mntmTarjetas = new JMenuItem("Tarjetas");
		mntmTarjetas.setFont(new Font("Monospaced", Font.PLAIN, 12));
		mnEstadisticas.add(mntmTarjetas);
		
		JMenuItem mntmCorners = new JMenuItem("Corners");
		mntmCorners.setFont(new Font("Monospaced", Font.PLAIN, 12));
		mnEstadisticas.add(mntmCorners);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(119, 136, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 148, 827, 347);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(240, 248, 255));
		table.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 10));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Equipo", "PJ", "Victorias", "Empates", "Derrotas", "Puntos", "GF", "GC", "Trofeos", "Fundaci\u00F3n"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("bienvenido a la app de apuestas");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(128, 64, 0));
		lblNewLabel.setFont(new Font("Star Jedi", Font.ITALIC, 24));
		lblNewLabel.setBounds(167, 33, 513, 36);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Clasificación LaLiga Temporada: 22/23");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(10, 123, 234, 13);
		contentPane.add(lblNewLabel_1);
	}
}

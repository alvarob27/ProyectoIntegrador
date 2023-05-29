package appapuestas;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import arbitro.ArbitDiseño;
import arbitro.MediaAmarillasPartido;
import arbitro.MediaRojasPartido;
import arbitro.MediaTarjetas;
import entrenadores.EntrenadorDiseño;
import equipos.*;
import estadio.EstadioDiseño;
import estadio.SaberOcupacion;
import estadisticas.*;
import jugadores.*;

import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class MenuPrincipal extends JFrame {

	private JPanel contentPane;
	static Login frame = new Login();
	private JTable table;
	private EquipoMostrarSaldo EquipoSaldo;
	private EquipoDiferenciaGoles EquipoGoles;
	private JugadoresMediaGoles JugadoresGoles;
	private JugadoresMediaAsistencias JugadoresAsistencias;
	private GolesEquipos EquiposGoles;
	private AmarillasEquipos EquiposAmarillas;
	private RojasEquipos EquiposRojas;
	private JugadorTirosPorPartido TirosJugador;
	private JugadorTirosPuertaPorPartido TirosPuertaJugador;
	private CornersPorPartido EquiposCorners;
	private TirosPorPartido EquiposTiros;
	private TirosPuertaPorPartido EquiposTirosPuerta;
	private PasesTotalesEquipos EquiposPases;
	private EntrenadorDiseño entrenadores;
	private EstadioDiseño EstadioPrincipal;
	private SaberOcupacion saberOcupacion;
	private ArbitDiseño arbitroDiseño;
	private MediaAmarillasPartido mediaAmarillas;
	private MediaRojasPartido mediaRojasPartido;
	private MediaTarjetas mediaTarjetasPartido;
	
	
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
		
		JMenuItem mntmDiferenciaGoles = new JMenuItem("Diferencia de goles");
		mntmDiferenciaGoles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EquipoGoles = new EquipoDiferenciaGoles();
				EquipoGoles.setVisible(true);
			}
		});
		mntmDiferenciaGoles.setFont(new Font("Monospaced", Font.PLAIN, 12));
		mnEquipo.add(mntmDiferenciaGoles);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Mostrar Saldo");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EquipoSaldo = new EquipoMostrarSaldo();
				EquipoSaldo.setVisible(true);
			}
		});
		mntmNewMenuItem.setFont(new Font("Monospaced", Font.PLAIN, 12));
		mnEquipo.add(mntmNewMenuItem);
		
		JMenu mnJugadores = new JMenu("Jugadores");
		mnJugadores.setForeground(new Color(0, 0, 0));
		mnJugadores.setFont(new Font("Monospaced", Font.PLAIN, 12));
		menuBar.add(mnJugadores);
		
		JMenuItem mntmMediaGoles = new JMenuItem("Media de goles");
		mntmMediaGoles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JugadoresGoles = new JugadoresMediaGoles();
				JugadoresGoles.setVisible(true);
			}
		});
		mntmMediaGoles.setFont(new Font("Monospaced", Font.PLAIN, 12));
		mnJugadores.add(mntmMediaGoles);
		
		JMenuItem mntmMediaAsistencias = new JMenuItem("Media de asistencias");
		mntmMediaAsistencias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JugadoresAsistencias = new JugadoresMediaAsistencias();
				JugadoresAsistencias.setVisible(true);
			}
		});
		mntmMediaAsistencias.setFont(new Font("Monospaced", Font.PLAIN, 12));
		mnJugadores.add(mntmMediaAsistencias);
		
		JMenu mnEstadisticas = new JMenu("Estadisticas");
		mnEstadisticas.setForeground(new Color(0, 0, 0));
		mnEstadisticas.setFont(new Font("Monospaced", Font.PLAIN, 12));
		menuBar.add(mnEstadisticas);
		
		JMenuItem mntmGoles = new JMenuItem("Goles de Equipos");
		mntmGoles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EquiposGoles = new GolesEquipos();
				EquiposGoles.setVisible(true);
				
			}
		});
		mntmGoles.setFont(new Font("Monospaced", Font.PLAIN, 12));
		mnEstadisticas.add(mntmGoles);
		
		JMenuItem mntmAmarillas = new JMenuItem("Amarillas de equipos");
		mntmAmarillas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				EquiposAmarillas = new AmarillasEquipos();
				EquiposAmarillas.setVisible(true);
			}
		});
		
		JMenuItem mntmTirosEquipos = new JMenuItem("Tiros de Equipos");
		mntmTirosEquipos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EquiposTiros = new TirosPorPartido();
				EquiposTiros.setVisible(true);
				
			}
		});
		mntmTirosEquipos.setFont(new Font("Monospaced", Font.PLAIN, 12));
		mnEstadisticas.add(mntmTirosEquipos);
		
		JMenuItem mntmTirosPuertaEquipos = new JMenuItem("Tiros a Puerta de Equipos");
		mntmTirosPuertaEquipos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				EquiposTirosPuerta = new TirosPuertaPorPartido();
				EquiposTirosPuerta.setVisible(true);
			}
		});
		mntmTirosPuertaEquipos.setFont(new Font("Monospaced", Font.PLAIN, 12));
		mnEstadisticas.add(mntmTirosPuertaEquipos);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Pases de Equipos");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				EquiposPases = new PasesTotalesEquipos();
				EquiposPases.setVisible(true);
			}
		});
		mntmNewMenuItem_1.setFont(new Font("Monospaced", Font.PLAIN, 12));
		mnEstadisticas.add(mntmNewMenuItem_1);
		
		JMenuItem mntmCorners = new JMenuItem("Corners de Equipos");
		mntmCorners.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				EquiposCorners = new CornersPorPartido();
				EquiposCorners.setVisible(true);
			}
		});
		mntmCorners.setFont(new Font("Monospaced", Font.PLAIN, 12));
		mnEstadisticas.add(mntmCorners);
		mntmAmarillas.setFont(new Font("Monospaced", Font.PLAIN, 12));
		mnEstadisticas.add(mntmAmarillas);
		
		JMenuItem mntmRojas = new JMenuItem("Rojas de Equipos");
		mntmRojas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				EquiposRojas = new RojasEquipos();
				EquiposRojas.setVisible(true);
			}
		});
		mntmRojas.setFont(new Font("Monospaced", Font.PLAIN, 12));
		mnEstadisticas.add(mntmRojas);
		
		JMenuItem mntmTirosJugadores = new JMenuItem("Tiros de Jugadores");
		mntmTirosJugadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TirosJugador = new JugadorTirosPorPartido();
				TirosJugador.setVisible(true);
			}
		});
		mntmTirosJugadores.setFont(new Font("Monospaced", Font.PLAIN, 12));
		mnEstadisticas.add(mntmTirosJugadores);
		
		JMenuItem mntmTirosPuertaJugadores = new JMenuItem("Tiros a puerta de Jugadores");
		mntmTirosPuertaJugadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TirosPuertaJugador = new JugadorTirosPuertaPorPartido();
				TirosPuertaJugador.setVisible(true);
			}
		});
		mntmTirosPuertaJugadores.setFont(new Font("Monospaced", Font.PLAIN, 12));
		mnEstadisticas.add(mntmTirosPuertaJugadores);
		
		//AQUÍ EMPIEZA ENTRENADORES
		 JMenu mnEntrenadores = new JMenu("Entrenadores");
	        mnEntrenadores.setForeground(Color.BLACK);
	        mnEntrenadores.setFont(new Font("Monospaced", Font.PLAIN, 12));
	        menuBar.add(mnEntrenadores);
	        

	     JMenuItem mnEntrenadoresPrincipal = new JMenuItem("Entrenadores");
		 mnEntrenadoresPrincipal.addActionListener(new ActionListener() {
		     	public void actionPerformed(ActionEvent e) {
		     		entrenadores = new EntrenadorDiseño();
		     		entrenadores.setVisible(true);
		     }
		 });
	        
	       
	     mnEntrenadoresPrincipal.setFont(new Font("Monospaced", Font.PLAIN, 12));
	     mnEntrenadores.add(mnEntrenadoresPrincipal);
		
	     
	     
	     //AQUI EMPIEZA ESTADIO
	     
		JMenu mnEstadio = new JMenu("Estadio");
		mnEstadio.setForeground(Color.BLACK);
		mnEstadio.setFont(new Font("Monospaced", Font.PLAIN, 12));
		menuBar.add(mnEstadio);
		
		JMenuItem mnEstadioPrincipal = new JMenuItem("Estadio ");
		mnEstadioPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EstadioPrincipal = new EstadioDiseño();
				EstadioPrincipal.setVisible(true);
			}
		});
		mnEstadioPrincipal.setFont(new Font("Monospaced", Font.PLAIN, 12));
		mnEstadio.add(mnEstadioPrincipal);
		

		
		JMenuItem mnSaberOcupacion = new JMenuItem("Saber Ocupacion del Estadio");
		mnSaberOcupacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 saberOcupacion = new SaberOcupacion();
				 saberOcupacion.setVisible(true);
			}
		});
		mnSaberOcupacion.setFont(new Font("Monospaced", Font.PLAIN, 12));
		mnEstadio.add(mnSaberOcupacion);
		
		
		
		
		//AQUI EMPIEZA ARBITRO
		
		
		JMenu mnArbitro = new JMenu("Arbitro");
		mnArbitro.setForeground(Color.BLACK);
		mnArbitro.setFont(new Font("Monospaced", Font.PLAIN, 12));
		menuBar.add(mnArbitro);
		
		JMenuItem mnArbitroPrincipal = new JMenuItem("Arbitros");
		mnArbitroPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 arbitroDiseño = new ArbitDiseño();
				 arbitroDiseño.setVisible(true);
			}
		});
		mnArbitroPrincipal.setFont(new Font("Monospaced", Font.PLAIN, 12));
		mnArbitro.add(mnArbitroPrincipal);
		
		JMenuItem mnMediaAmarillasPartido = new JMenuItem("Media de Amarillas por Partido");
		mnMediaAmarillasPartido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 mediaAmarillas = new MediaAmarillasPartido();
				 mediaAmarillas.setVisible(true);
				
			}
		});
		mnMediaAmarillasPartido.setFont(new Font("Monospaced", Font.PLAIN, 12));
		mnArbitro.add(mnMediaAmarillasPartido);
		
		
	
		
		JMenuItem mnMediaRojasPartido = new JMenuItem("Media de Rojas por Partido");
		mnMediaRojasPartido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mediaRojasPartido = new MediaRojasPartido();
				mediaRojasPartido.setVisible(true);
				
			}
		});
		mnMediaRojasPartido.setFont(new Font("Monospaced", Font.PLAIN, 12));
		mnArbitro.add(mnMediaRojasPartido);
		
		JMenuItem mnMediaTarjetas = new JMenuItem("Media de Tarjetas");
		mnMediaTarjetas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mediaTarjetasPartido = new MediaTarjetas();
				mediaTarjetasPartido.setVisible(true);
			}
		});
		mnMediaTarjetas.setFont(new Font("Monospaced", Font.PLAIN, 12));
		mnArbitro.add(mnMediaTarjetas);
		
		
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
		
		JLabel lblTitulo = new JLabel("bienvenido a la app de apuestas");
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setBackground(new Color(128, 64, 0));
		lblTitulo.setFont(new Font("Star Jedi", Font.ITALIC, 24));
		lblTitulo.setBounds(167, 33, 513, 36);
		contentPane.add(lblTitulo);
		
		JLabel lblClasificacion = new JLabel("Clasificación LaLiga Temporada: 22/23");
		lblClasificacion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblClasificacion.setForeground(new Color(255, 255, 255));
		lblClasificacion.setBounds(10, 123, 234, 13);
		contentPane.add(lblClasificacion);
		
		try {
            Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/apuestas","root","");
            Statement miStatement = miConexion.createStatement();
            String consulta = "SELECT * FROM equipo order by puntos desc";
            ResultSet miResultSet = miStatement.executeQuery(consulta);
            
            // Crear el DefaultTableModel con las columnas necesarias
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Equipo");
            model.addColumn("PJ");
            model.addColumn("Victorias");
            model.addColumn("Empates");
            model.addColumn("Derrotas");
            model.addColumn("Puntos");
            model.addColumn("GF");
            model.addColumn("GC");
            model.addColumn("Trofeos");
            model.addColumn("Fundacion");
 
            // Iterar sobre los registros del ResultSet y agregarlos al modelo
            while (miResultSet.next()) {
                String nombreEquipo = miResultSet.getString("nombre");
                int partidosJugados = miResultSet.getInt("partidos_jugados");
                int victorias = miResultSet.getInt("victorias");
                int empates = miResultSet.getInt("empates");
                int derrotas = miResultSet.getInt("derrotas");
                int puntos = miResultSet.getInt("puntos");
                int golesFavor = miResultSet.getInt("goles_favor");
                int golesContra = miResultSet.getInt("goles_contra");
                int trofeos = miResultSet.getInt("numero_trofeos");
                int fundacion = miResultSet.getInt("anyo_fundacion");
                
                model.addRow(new Object[]{nombreEquipo,partidosJugados,victorias, empates, derrotas
                		,puntos, golesFavor, golesContra, trofeos, fundacion });
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
}

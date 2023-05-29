package estadisticas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TirosPuertaPorPartido extends JFrame {
    private JTable table;

    public TirosPuertaPorPartido() {
    	setBounds(100,100,861,578);
        JPanel panelTirosPuerta = new JPanel();
        panelTirosPuerta.setBackground(new Color(119, 136, 153));
        getContentPane().add(panelTirosPuerta, BorderLayout.CENTER);
        panelTirosPuerta.setLayout(null);

        JLabel lblTirosPuerta = new JLabel("tiros a puerta de equipos");
        lblTirosPuerta.setFont(new Font("Star Jedi", Font.PLAIN, 21));
        lblTirosPuerta.setForeground(new Color(255, 255, 255));
        lblTirosPuerta.setBounds(234, 56, 399, 49);
        panelTirosPuerta.add(lblTirosPuerta);

        JComboBox<String> comboEquipos = new JComboBox<>();
        comboEquipos.setBounds(290, 115, 152, 21);
        panelTirosPuerta.add(comboEquipos);

        JButton btnTirosPuerta = new JButton("BUSCAR");
        btnTirosPuerta.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		String equipoSeleccionado = (String) comboEquipos.getSelectedItem();

		        try {
		            Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/apuestas", "root", "");
		            Statement miStatement = miConexion.createStatement();

		            String consultaLocal = "SELECT SUM(tiros_puerta_local) as tirosPuertaLocal FROM resultados WHERE equipo_local LIKE '" + equipoSeleccionado + "%'";
		            String consultaVisitante = "SELECT SUM(tiros_puerta_visitante) as tirosPuertaVisitante FROM resultados WHERE equipo_visitante LIKE '" + equipoSeleccionado + "%'";

		            int tirosPuertaLocal = 0;
		            int tirosPuertaVisitante = 0;

		            ResultSet miResultSetLocal = miStatement.executeQuery(consultaLocal);
		            if (miResultSetLocal.next()) {
		            	tirosPuertaLocal = miResultSetLocal.getInt("tirosPuertaLocal");
		            }
		            miResultSetLocal.close();

		            ResultSet miResultSetVisitante = miStatement.executeQuery(consultaVisitante);
		            if (miResultSetVisitante.next()) {
		            	tirosPuertaVisitante = miResultSetVisitante.getInt("tirosPuertaVisitante");
		            }
		            miResultSetVisitante.close();

		            String consulta = "SELECT nombre, partidos_jugados FROM equipo WHERE nombre='" + equipoSeleccionado + "'";
		            ResultSet miResultSetEquipo = miStatement.executeQuery(consulta);

		            if (miResultSetEquipo.next()) {
		                String nombreEquipo = miResultSetEquipo.getString("nombre");
		                int partidosJugados = miResultSetEquipo.getInt("partidos_jugados");

		                String consultaPartidosLocal = "SELECT COUNT(*) as partidosLocal FROM resultados WHERE equipo_local LIKE '" + equipoSeleccionado + "%'";
		                String consultaPartidosVisitante = "SELECT COUNT(*) as partidosVisitante FROM resultados WHERE equipo_visitante LIKE '" + equipoSeleccionado + "%'";

		                int partidosLocal = 0;
		                int partidosVisitante = 0;

		                ResultSet miResultSetPartidosLocal = miStatement.executeQuery(consultaPartidosLocal);
		                if (miResultSetPartidosLocal.next()) {
		                    partidosLocal = miResultSetPartidosLocal.getInt("partidosLocal");
		                }
		                miResultSetPartidosLocal.close();

		                ResultSet miResultSetPartidosVisitante = miStatement.executeQuery(consultaPartidosVisitante);
		                if (miResultSetPartidosVisitante.next()) {
		                    partidosVisitante = miResultSetPartidosVisitante.getInt("partidosVisitante");
		                }
		                miResultSetPartidosVisitante.close();

		                double mediaTirosPuertaLocal = (partidosLocal != 0) ? (tirosPuertaLocal / (double) partidosLocal) : 0.0;
		                double mediaTirosPuertaVisitante = (partidosVisitante != 0) ? (tirosPuertaVisitante / (double) partidosVisitante) : 0.0;

		                // Redondear los valores a 2 decimales
		                mediaTirosPuertaLocal = Math.round(mediaTirosPuertaLocal * 100.0) / 100.0;
		                mediaTirosPuertaVisitante = Math.round(mediaTirosPuertaVisitante * 100.0) / 100.0;

		                // Crear el DefaultTableModel con las columnas necesarias
		                DefaultTableModel model = new DefaultTableModel();
		                model.addColumn("Equipo");
		                model.addColumn("Partidos Local");
		                model.addColumn("Tiros a Puerta");
		                model.addColumn("Media Local");		                	               
		                model.addColumn("Partidos Visitante");		
		                model.addColumn("Tiros a Puerta");	
		                model.addColumn("Media Visitante");

		                // Agregar los datos al modelo
		                model.addRow(new Object[]{nombreEquipo, partidosLocal, tirosPuertaLocal, mediaTirosPuertaLocal, partidosVisitante, tirosPuertaVisitante, mediaTirosPuertaVisitante});

		                // Asignar el modelo a la tabla
		                table.setModel(model);
		            }

		            miResultSetEquipo.close();
		            miStatement.close();
		            miConexion.close();
		        } catch (SQLException ex) {
		            ex.printStackTrace();
		            System.out.println("No se ha podido conectar con la base de datos");
		        }
        	}
        });
        btnTirosPuerta.setBounds(452, 115, 85, 21);
        panelTirosPuerta.add(btnTirosPuerta);

        JScrollPane scrollPaneTirosPuerta = new JScrollPane();
        scrollPaneTirosPuerta.setBounds(71, 158, 674, 37);
        panelTirosPuerta.add(scrollPaneTirosPuerta);

        table = new JTable();
        table.setBackground(new Color(240, 248, 255));
        table.setModel(new DefaultTableModel(
        	new Object[][] {
        		{null, null, null, null},
        	},
        	new String[] {
        			"Equipo", "Partidos Local", "Tiros Puerta", "Media Local", "Partidos Visitante", "Tiros Puerta", "Media Visitante"
        	}
        ));
        scrollPaneTirosPuerta.setViewportView(table);
        
        JLabel lblNewLabel = new JLabel("EQUIPOS");
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setBounds(220, 117, 71, 17);
        panelTirosPuerta.add(lblNewLabel);
        
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

    public static void main(String[] args) {
        TirosPuertaPorPartido tirosPuertaPorPartido = new TirosPuertaPorPartido();
        tirosPuertaPorPartido.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tirosPuertaPorPartido.setSize(800, 600);
        tirosPuertaPorPartido.setVisible(true);
    }
}

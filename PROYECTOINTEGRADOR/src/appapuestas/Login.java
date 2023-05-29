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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtPasswd;
	private JLabel lblComprobacion;
	static Login frame = new Login();
	private MenuPrincipal menu;



	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(119, 136, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setForeground(new Color(255, 255, 255));
		lblUsuario.setBackground(new Color(255, 255, 255));
		lblUsuario.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 12));
		lblUsuario.setBounds(123, 100, 61, 13);
		contentPane.add(lblUsuario);

		JLabel lblPasswd = new JLabel("Contraseña:");
		lblPasswd.setForeground(new Color(255, 255, 255));
		lblPasswd.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 12));
		lblPasswd.setBounds(122, 151, 79, 13);
		contentPane.add(lblPasswd);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(244, 98, 86, 19);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);

		txtPasswd = new JPasswordField();
		txtPasswd.setBounds(244, 145, 86, 19);
		contentPane.add(txtPasswd);

		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setBackground(new Color(255, 255, 255));
		btnLogin.setForeground(new Color(0, 0, 0));
		btnLogin.setFont(new Font("Segoe UI", Font.BOLD, 10));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = txtUsuario.getText();
                String passwd = new String(txtPasswd.getPassword());

                // Realizar la conexión a la base de datos
                try (Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/apuestas", "root", "")) {
                    // Preparar la consulta parametrizada
                    String query = "SELECT * FROM usuarios WHERE usuario = ? AND contraseña = ?";
                    PreparedStatement miStatement = miConexion.prepareStatement(query);
                    miStatement.setString(1, user);
                    miStatement.setString(2, passwd);

                    // Ejecutar la consulta
                    ResultSet miResultSet = miStatement.executeQuery();

                    if (miResultSet.next()) {
                        lblComprobacion.setText("Usuario y contraseña correctos");
                        frame.setVisible(false);
                        menu = new MenuPrincipal();
                        menu.setVisible(true);
                    } else {
                        lblComprobacion.setText("Usuario y contraseña incorrectos");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    System.out.println("No se ha podido conectar con la base de datos");
                }
			}
		});
		btnLogin.setBounds(166, 210, 92, 21);
		contentPane.add(btnLogin);
		
		lblComprobacion = new JLabel("");
		lblComprobacion.setBounds(123, 185, 241, 13);
		contentPane.add(lblComprobacion);
		
		JLabel lblNewLabel = new JLabel("iniciar sesión");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Star Jedi", Font.PLAIN, 21));
		lblNewLabel.setBounds(129, 28, 217, 38);
		contentPane.add(lblNewLabel);
	}
}

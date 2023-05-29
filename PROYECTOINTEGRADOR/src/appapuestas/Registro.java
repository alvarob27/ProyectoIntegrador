package appapuestas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Registro extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtPasswd;
	private JLabel lblComprobacion;
	private MenuPrincipal menu;
	private static Registro r = new Registro();
	private Login login;
	private JLabel lblNewLabel;
	

	public static void main(String[] args) {
		r.setVisible(true);
	}

	public Registro() {
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
		lblUsuario.setBounds(123, 91, 61, 13);
		contentPane.add(lblUsuario);

		JLabel lblPasswd = new JLabel("Contraseña:");
		lblPasswd.setForeground(new Color(255, 255, 255));
		lblPasswd.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 12));
		lblPasswd.setBounds(123, 128, 79, 13);
		contentPane.add(lblPasswd);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(244, 89, 86, 19);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);

		txtPasswd = new JPasswordField();
		txtPasswd.setBounds(244, 122, 86, 19);
		contentPane.add(txtPasswd);

		JButton btnLogin = new JButton("ENVIAR");
		btnLogin.setBackground(new Color(255, 255, 255));
		btnLogin.setForeground(new Color(0, 0, 0));
		btnLogin.setFont(new Font("Segoe UI", Font.BOLD, 10));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = txtUsuario.getText();
				String passwd = txtPasswd.getPassword().toString();
				r.setVisible(false);
				login = new Login();
				login.setVisible(true);
				
				try {
				    Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/apuestas", "root", "");
				    Statement miStatement = miConexion.createStatement();

				    String usuario = txtUsuario.getText();
				    String contraseña = new String(txtPasswd.getPassword());

				    // Aquí se realiza la inserción en la tabla
				    String query = "INSERT INTO usuarios (usuario, contraseña) VALUES ('" + usuario + "', '" + contraseña + "')";
				    miStatement.executeUpdate(query);


				} catch (SQLException f) {
				    f.printStackTrace();
				    System.out.println("No se ha podido conectar con la base de datos");
				}

				
			}
		});
		btnLogin.setBounds(164, 174, 107, 21);
		contentPane.add(btnLogin);
		
		lblComprobacion = new JLabel("");
		lblComprobacion.setBounds(123, 151, 241, 13);
		contentPane.add(lblComprobacion);
		
		lblNewLabel = new JLabel("registrate");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Star Jedi", Font.PLAIN, 21));
		lblNewLabel.setBounds(151, 23, 151, 49);
		contentPane.add(lblNewLabel);
	}

}

package appapuestas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class MenuBienvenida extends JFrame {

	private JPanel contentPane;
	private JLabel lblComprobacion;
	private MenuPrincipal menu;
	private static MenuBienvenida r = new MenuBienvenida();
	private Login login;
	private Registro registro;
	private JLabel lblNewLabel;
	

	public static void main(String[] args) {
		r.setVisible(true);
	}

	public MenuBienvenida() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 573, 354);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(119, 136, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblUsuario = new JLabel("Tienes cuenta en nuestra aplicación?");
		lblUsuario.setForeground(new Color(255, 255, 255));
		lblUsuario.setBackground(new Color(255, 255, 255));
		lblUsuario.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 16));
		lblUsuario.setBounds(94, 128, 403, 13);
		contentPane.add(lblUsuario);

		JButton btnLogin = new JButton("Hacer Login");
		btnLogin.setBackground(new Color(255, 255, 255));
		btnLogin.setForeground(new Color(0, 0, 0));
		btnLogin.setFont(new Font("Segoe UI", Font.BOLD, 10));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				r.setVisible(false);
				login = new Login();
				login.setVisible(true);
			}
		});
		btnLogin.setBounds(140, 190, 109, 21);
		contentPane.add(btnLogin);
		
		lblComprobacion = new JLabel("");
		lblComprobacion.setBounds(123, 151, 241, 13);
		contentPane.add(lblComprobacion);
		
		lblNewLabel = new JLabel("bienvenido/a a la app de estadísticas");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Star Jedi", Font.PLAIN, 21));
		lblNewLabel.setBounds(32, 41, 527, 65);
		contentPane.add(lblNewLabel);
		
		JButton btnRegistro = new JButton("Registrarme");
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				r.setVisible(false);
				registro = new Registro();
				registro.setVisible(true);
			}
		});
		btnRegistro.setFont(new Font("Segoe UI", Font.BOLD, 10));
		btnRegistro.setForeground(Color.BLACK);
		btnRegistro.setBounds(283, 190, 114, 21);
		contentPane.add(btnRegistro);
	}
}

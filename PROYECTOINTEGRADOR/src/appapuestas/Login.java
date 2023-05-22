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

	public static void main(String[] args) {
		frame.setVisible(true);

	}

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
		lblUsuario.setBounds(123, 69, 61, 13);
		contentPane.add(lblUsuario);

		JLabel lblPasswd = new JLabel("Contraseña:");
		lblPasswd.setForeground(new Color(255, 255, 255));
		lblPasswd.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 12));
		lblPasswd.setBounds(123, 107, 79, 13);
		contentPane.add(lblPasswd);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(244, 66, 86, 19);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);

		txtPasswd = new JPasswordField();
		txtPasswd.setBounds(244, 104, 86, 19);
		contentPane.add(txtPasswd);

		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setBackground(new Color(255, 255, 255));
		btnLogin.setForeground(new Color(0, 0, 0));
		btnLogin.setFont(new Font("Segoe UI", Font.BOLD, 10));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = "Alvaro";
				String passwd = "Alvaro2023";
				
				if(txtUsuario.getText().equals(user)&&String.valueOf(txtPasswd.getPassword()).equals(passwd)) {
					lblComprobacion.setText("Usuario y contraseña correctos");
					frame.setVisible(false);
					menu = new MenuPrincipal();
					menu.setVisible(true);
					
					
				}
				else {
					lblComprobacion.setText("Usuario y contraseña incorrectos");
				}
			}
		});
		btnLogin.setBounds(168, 178, 92, 21);
		contentPane.add(btnLogin);
		
		lblComprobacion = new JLabel("");
		lblComprobacion.setBounds(123, 151, 241, 13);
		contentPane.add(lblComprobacion);
	}

}

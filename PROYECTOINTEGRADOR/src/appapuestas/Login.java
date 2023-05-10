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

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtPasswd;
	private JLabel lblComprobacion;
	static Login frame = new Login();

	public static void main(String[] args) {
		frame.setVisible(true);

	}

	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(123, 69, 61, 13);
		contentPane.add(lblUsuario);

		JLabel lblPasswd = new JLabel("Contraseña:");
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
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = "Alvaro";
				String passwd = "Alvaro2023";
				
				if(txtUsuario.getText().equals(user)&&String.valueOf(txtPasswd.getPassword()).equals(passwd)) {
					lblComprobacion.setText("Usuario y contraseña correctos");
					frame.setVisible(false);
					
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

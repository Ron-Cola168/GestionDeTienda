package Ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import ClasesModelo.Empleado;
import util.SesionEmpleado;
import ClasesDAO.EmpleadoDAO;

import java.sql.SQLException;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;

/**
 * Ventana principal de la aplicación, que permite a los empleados iniciar sesión
 * utilizando su correo electrónico y contraseña. Tras una autenticación exitosa,
 * redirige al menú principal de la aplicación.
 */
public class VenPrincipal extends JFrame {

	// Credenciales de inicio de sesión de ejemplo (no deben ser hardcodeadas en producción)
	// Admin: seg1@magicas.es / psg234
	// Empleado: san33@magicas.es / 1234

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textCorreo;
	private JPasswordField textContrasenia;

	/**
	 * Método principal para lanzar la aplicación.
	 *
	 * @param args Argumentos de la línea de comandos (no utilizados).
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VenPrincipal frame = new VenPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Constructor de la ventana principal. Inicializa la interfaz de usuario
	 * con etiquetas para el título, mensaje de bienvenida, correo electrónico
	 * y contraseña, campos de texto para la entrada de credenciales y un botón
	 * para iniciar sesión.
	 */
	public VenPrincipal() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 870, 580);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(199, 169, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Etiqueta para el título de la aplicación
		JLabel lblTitulo = new JLabel("Magicas: El encuentro");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblTitulo.setBounds(284, 11, 275, 59);
		contentPane.add(lblTitulo);

		// Etiqueta de mensaje de bienvenida
		JLabel lblNewLabel = new JLabel("¡Bienvenido!");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(360, 81, 121, 37);
		contentPane.add(lblNewLabel);

		// Etiqueta para el campo de correo electrónico
		JLabel lblCorreo = new JLabel("Correo electronico:");
		lblCorreo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCorreo.setBounds(193, 181, 146, 28);
		contentPane.add(lblCorreo);

		// Campo de texto para ingresar el correo electrónico
		textCorreo = new JTextField();
		textCorreo.setBounds(360, 187, 199, 20);
		contentPane.add(textCorreo);
		textCorreo.setColumns(10);

		// Etiqueta para el campo de contraseña
		JLabel lblContrasenia = new JLabel("Contraseña:");
		lblContrasenia.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblContrasenia.setBounds(193, 220, 146, 37);
		contentPane.add(lblContrasenia);

		// Campo de texto enmascarado para ingresar la contraseña
		textContrasenia = new JPasswordField();
		textContrasenia.setBounds(284, 230, 275, 20);
		contentPane.add(textContrasenia);

		// Botón para iniciar la sesión
		JButton btnIniciar = new JButton("Iniciar sesion");
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// Intenta autenticar al empleado con las credenciales ingresadas
					Empleado empleado = EmpleadoDAO.autenticarEmpleado(textCorreo, textContrasenia);
					if(empleado != null) {
						// Si la autenticación es exitosa, inicia la sesión y muestra el menú principal
						if(SesionEmpleado.iniciarSesion(empleado)) {
							VenMenu v1 = new VenMenu();
							v1.setVisible(true);
							dispose(); // Cierra la ventana de inicio de sesión
						}
					} else {
						// Si las credenciales son incorrectas, muestra un mensaje de error
						JOptionPane.showMessageDialog(null,
								"¡ERROR! Contraseña o correo incorrectos. Intentelo nuevamente.",
								"ERROR",
								JOptionPane.ERROR_MESSAGE);
					}
				} catch (SQLException ex) {
					// En caso de error de base de datos, muestra un mensaje de error
					JOptionPane.showMessageDialog(null,
							"¡ERROR! Error al conectar con la base de datos.",
							"ERROR",
							JOptionPane.ERROR_MESSAGE);
					ex.printStackTrace(); // Imprime la traza del error en la consola
				}
			}
		});
		btnIniciar.setBounds(360, 298, 121, 23);
		contentPane.add(btnIniciar);
	}
}
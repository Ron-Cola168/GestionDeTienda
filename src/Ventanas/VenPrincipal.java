package Ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VenPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textID;
	private JTextField textField;

	/**
	 * Launch the application.
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
	 * Create the frame.
	 */
	public VenPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 870, 580);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(199, 169, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Magicas: El encuentro");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblTitulo.setBounds(284, 11, 275, 59);
		contentPane.add(lblTitulo);
		
		JLabel lblNewLabel = new JLabel("¡Bienvenido!");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(360, 81, 121, 37);
		contentPane.add(lblNewLabel);
		
		JLabel lblid = new JLabel("Código de empleado");
		lblid.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblid.setBounds(193, 181, 146, 28);
		contentPane.add(lblid);
		
		textID = new JTextField();
		textID.setBounds(360, 187, 199, 20);
		contentPane.add(textID);
		textID.setColumns(10);
		
		JLabel lblContraseña = new JLabel("Contraseña");
		lblContraseña.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblContraseña.setBounds(193, 220, 146, 37);
		contentPane.add(lblContraseña);
		
		textField = new JTextField();
		textField.setBounds(284, 230, 275, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnIniciar = new JButton("Iniciar sesion");
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VenMenu v1 = new VenMenu();
				v1.setVisible(true);
				
				dispose();
			}
		});
		btnIniciar.setBounds(360, 298, 121, 23);
		contentPane.add(btnIniciar);
	}
}

package Ventanas;

import util.Carrito;
import util.SesionEmpleado;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Ventana principal de la aplicación, que ofrece acceso a las secciones de
 * Juegos de Mesa, Tarjetas Coleccionables e Inventario. También incluye
 * funcionalidades para la gestión de empleados (solo para administradores),
 * un carrito de compras y la opción de cerrar sesión.
 */
public class VenMenu extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTextArea textCarrito;
	private static JLabel lblTotal_1;
	private static Carrito carrito;

	/**
	 * Constructor de la ventana del menú principal. Inicializa la interfaz de usuario,
	 * incluyendo los botones para acceder a las diferentes secciones de la aplicación,
	 * el panel del carrito de compras y el botón para cerrar la sesión.
	 */
	public VenMenu() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 870, 580);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(199, 169, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		// Panel central para los botones principales
		JPanel panel = new JPanel();
		panel.setBackground(new Color(199, 169, 139));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		// Botón para acceder a la ventana de Juegos de Mesa
		JButton btnJuegosMesa = new JButton("Juegos De mesa");
		btnJuegosMesa.addActionListener(e -> {
			VenJDM venJGD = new VenJDM();
			venJGD.setVisible(true);
			setVisible(false);
		});
		btnJuegosMesa.setBounds(40, 74, 147, 101);
		panel.add(btnJuegosMesa);

		// Panel lateral para mostrar el carrito de compras
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(641, 0, 203, 497);
		panel.add(panel_1);
		panel_1.setBackground(new Color(199, 169, 139));
		panel_1.setLayout(null);

		// Área de texto para mostrar los items del carrito
		textCarrito = new JTextArea();
		textCarrito.setBackground(new Color(255, 255, 255));
		textCarrito.setBounds(10, 5, 183, 374);
		panel_1.add(textCarrito);
		textCarrito.setEditable(false);

		// Etiqueta para el total del carrito
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTotal.setBounds(10, 378, 116, 33);
		panel_1.add(lblTotal);

		// Botón para cancelar la compra (sin funcionalidad implementada)
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(10, 453, 183, 33);
		panel_1.add(btnCancelar);

		// Botón para proceder al cobro (sin funcionalidad implementada)
		JButton btnCobrar = new JButton("Cobrar");
		btnCobrar.setBounds(10, 409, 183, 33);
		panel_1.add(btnCobrar);

		// Etiqueta que muestra el total numérico del carrito
		lblTotal_1 = new JLabel("0.00 €");
		lblTotal_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTotal_1.setBounds(136, 378, 57, 33);
		panel_1.add(lblTotal_1);

		// Botón para acceder a la ventana de Tarjetas Coleccionables (TCG)
		JButton btnTCG = new JButton("TCG");
		btnTCG.addActionListener(e -> {
			VenTCG v1 = new VenTCG();
			v1.setVisible(true);
			setVisible(false);
		});
		btnTCG.setBounds(197, 74, 147, 101);
		panel.add(btnTCG);

		// Botón para acceder a la ventana de gestión del Inventario
		JButton btnInventario = new JButton("Inventario");
		btnInventario.addActionListener(e -> {
			VenInventario v1 = new VenInventario();
			v1.setVisible(true);
			setVisible(false);
		});
		btnInventario.setBounds(354, 74, 147, 101);
		panel.add(btnInventario);

		// Botón para la gestión de empleados, visible solo si el usuario es administrador
		if(SesionEmpleado.esAdmin()){
			JButton btngestionEmpleados = new JButton("Gestionar Empleados");
			btngestionEmpleados.addActionListener(e -> {
				VenEmpleados v1 = new VenEmpleados();
				v1.setVisible(true);
				setVisible(false);
			});
			btngestionEmpleados.setBounds(40, 186, 461, 101);
			panel.add(btngestionEmpleados);
		}

		// Botón para cerrar la sesión actual del empleado
		JButton btnCerrarSesion = new JButton("Cerrar Sesión");
		btnCerrarSesion.addActionListener(e -> {
			SesionEmpleado.cerrarSesion();
			VenPrincipal venLogin = new VenPrincipal();
			venLogin.setVisible(true);
			dispose();
		});
		btnCerrarSesion.setBounds(40, 450, 461, 40);
		panel.add(btnCerrarSesion);

		// Título principal de la ventana
		JLabel lblTitulo = new JLabel("Magicas: el encuentro");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 28));
		contentPane.add(lblTitulo, BorderLayout.NORTH);

		// Inicialización del carrito de compras, asociándolo al área de texto y la etiqueta del total
		carrito = new Carrito(textCarrito, lblTotal_1);
	}
}
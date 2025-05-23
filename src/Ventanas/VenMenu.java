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

public class VenMenu extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTextArea textCarrito;
	private static JLabel lblTotal_1;
	private static Carrito carrito;

	public VenMenu() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 870, 580);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(199, 169, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel(); // Panel central para botones principales
		panel.setBackground(new Color(199, 169, 139));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JButton btnJuegosMesa = new JButton("Juegos De mesa"); // Botón a ventana Juegos de Mesa
		btnJuegosMesa.addActionListener(e -> {
			VenJDM venJGD = new VenJDM();
			venJGD.setVisible(true);
			setVisible(false);
		});
		btnJuegosMesa.setBounds(40, 74, 147, 101);
		panel.add(btnJuegosMesa);

		JPanel panel_1 = new JPanel(); // Panel lateral para el carrito
		panel_1.setBounds(641, 0, 203, 497);
		panel.add(panel_1);
		panel_1.setBackground(new Color(199, 169, 139));
		panel_1.setLayout(null);

		textCarrito = new JTextArea(); // Muestra items del carrito
		textCarrito.setBackground(new Color(255, 255, 255));
		textCarrito.setBounds(10, 5, 183, 374);
		panel_1.add(textCarrito);
		textCarrito.setEditable(false);

		JLabel lblTotal = new JLabel("Total"); // Etiqueta "Total"
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTotal.setBounds(10, 378, 116, 33);
		panel_1.add(lblTotal);

		JButton btnCancelar = new JButton("Cancelar"); // Botón Cancelar (sin funcionalidad)
		btnCancelar.setBounds(10, 453, 183, 33);
		panel_1.add(btnCancelar);

		JButton btnCobrar = new JButton("Cobrar"); // Botón Cobrar (sin funcionalidad)
		btnCobrar.setBounds(10, 409, 183, 33);
		panel_1.add(btnCobrar);

		lblTotal_1 = new JLabel("0.00 €"); // Muestra el total del carrito
		lblTotal_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTotal_1.setBounds(136, 378, 57, 33);
		panel_1.add(lblTotal_1);

		JButton btnTCG = new JButton("TCG"); // Botón a ventana TCG
		btnTCG.addActionListener(e -> {
			VenTCG v1 = new VenTCG();
			v1.setVisible(true);
			setVisible(false);
		});
		btnTCG.setBounds(197, 74, 147, 101);
		panel.add(btnTCG);

		JButton btnInventario = new JButton("Inventario"); // Botón a ventana Inventario
		btnInventario.addActionListener(e -> {
			VenInventario v1 = new VenInventario();
			v1.setVisible(true);
			setVisible(false);
		});
		btnInventario.setBounds(354, 74, 147, 101);
		panel.add(btnInventario);

		if(SesionEmpleado.esAdmin()){ // Botón de gestión de empleados (solo para admin)
			JButton btngestionEmpleados = new JButton("Gestionar Empleados");
			btngestionEmpleados.addActionListener(e -> {
				VenEmpleados v1 = new VenEmpleados();
				v1.setVisible(true);
				setVisible(false);
			});
			btngestionEmpleados.setBounds(40, 186, 461, 101);
			panel.add(btngestionEmpleados);
		}

		JButton btnCerrarSesion = new JButton("Cerrar Sesión"); // Botón para cerrar sesión
		btnCerrarSesion.addActionListener(e -> {
			SesionEmpleado.cerrarSesion();
			VenPrincipal venLogin = new VenPrincipal();
			venLogin.setVisible(true);
			dispose();
		});
		btnCerrarSesion.setBounds(40, 450, 461, 40);
		panel.add(btnCerrarSesion);

		JLabel lblTitulo = new JLabel("Magicas: el encuentro"); // Título de la ventana
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 28));
		contentPane.add(lblTitulo, BorderLayout.NORTH);

		carrito = new Carrito(textCarrito, lblTotal_1); // Inicialización del carrito
	}
}
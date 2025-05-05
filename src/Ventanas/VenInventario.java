package Ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Font;

public class VenInventario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public VenInventario() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 870, 580);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(199, 169, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAñadir = new JButton("Añadir nuevo producto");
		btnAñadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAñadir.setBounds(35, 100, 218, 78);
		contentPane.add(btnAñadir);
		
		JButton btnEliminar = new JButton("Eliminar un producto");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEliminar.setBounds(266, 100, 218, 78);
		contentPane.add(btnEliminar);
		
		JButton btnModificarExistencias = new JButton("Modificar existencias");
		btnModificarExistencias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnModificarExistencias.setBounds(35, 189, 449, 78);
		contentPane.add(btnModificarExistencias);
		
		JButton btnBuscar = new JButton("Buscar producto");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBuscar.setBounds(266, 275, 218, 78);
		contentPane.add(btnBuscar);
		
		JButton btnListar = new JButton("Listar todos los porductos");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnListar.setBounds(35, 275, 218, 78);
		contentPane.add(btnListar);
		
		JTextPane textListaProductos = new JTextPane();
		textListaProductos.setBackground(new Color(199, 199, 199));
		textListaProductos.setBounds(522, 88, 322, 418);
		contentPane.add(textListaProductos);
		
		JLabel lblTitulo = new JLabel("Inventario");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblTitulo.setBounds(341, 11, 143, 78);
		contentPane.add(lblTitulo);
		
		JButton btnVolver = new JButton("VOLVER");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VenMenu v1 = new VenMenu();
				v1.setVisible(true);
				dispose();
			}
		});
		btnVolver.setBounds(35, 400, 449, 78);
		contentPane.add(btnVolver);
	}
}

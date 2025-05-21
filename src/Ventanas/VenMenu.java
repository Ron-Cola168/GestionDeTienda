package Ventanas;

import util.SesionEmpleado;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VenMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	// Agregar al inicio de la clase
	private static JTextArea textCarrito;
	private static double total = 0.0;
	private static JLabel lblTotal_1;


	/**
	 * Create the frame.
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
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(199, 169, 139));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnJuegosMesa = new JButton("Juegos De mesa");
		btnJuegosMesa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VenJDM venJGD = new VenJDM();
				venJGD.setVisible(true);
				dispose();
			}
		});
		btnJuegosMesa.setBounds(40, 74, 147, 101);
		panel.add(btnJuegosMesa);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(641, 0, 203, 497);
		panel.add(panel_1);
		panel_1.setBackground(new Color(199, 169, 139));
		panel_1.setLayout(null);
		
		// Modificar el constructor para asignar las variables
		textCarrito = new JTextArea();
		textCarrito.setBackground(new Color(255, 255, 255));
		textCarrito.setBounds(10, 5, 183, 374);
		panel_1.add(textCarrito);
		textCarrito.setEditable(false);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTotal.setBounds(10, 378, 116, 33);
		panel_1.add(lblTotal);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancelar.setBounds(10, 453, 183, 33);
		panel_1.add(btnCancelar);
		
		JButton btnCobrar = new JButton("Cobrar");
		btnCobrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCobrar.setBounds(10, 409, 183, 33);
		panel_1.add(btnCobrar);
		
		// Modificar el constructor para asignar las variables
		lblTotal_1 = new JLabel("0.00 €");
		lblTotal_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTotal_1.setBounds(136, 378, 57, 33);
		panel_1.add(lblTotal_1);
		
		JButton btnTCG = new JButton("TCG");
		btnTCG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTCG.setBounds(197, 74, 147, 101);
		panel.add(btnTCG);
		
		JButton btnTop10 = new JButton("TOP 10 MÁS VENDIDOS");
		btnTop10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTop10.setBounds(354, 74, 147, 101);
		panel.add(btnTop10);
		
		JButton btnComida = new JButton("Comida");
		btnComida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnComida.setBounds(40, 186, 147, 101);
		panel.add(btnComida);
		
		JButton btnBebidas = new JButton("Bebidas");
		btnBebidas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBebidas.setBounds(197, 186, 147, 101);
		panel.add(btnBebidas);
		
		JButton btnZonaSocios = new JButton("Zona Socios");
		btnZonaSocios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnZonaSocios.setBounds(354, 186, 147, 101);
		panel.add(btnZonaSocios);


		/**Botones de administrador**/
		if(SesionEmpleado.esAdmin()){

			JButton btnInventario = new JButton("Inventario");
			btnInventario.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					VenInventario v1 = new VenInventario();
					v1.setVisible(true);
					dispose();
				}
			});
			btnInventario.setBounds(40, 298, 461, 40);
			panel.add(btnInventario);

			JButton btngestionEmpleados = new JButton("Gestionar Empleados");
			btngestionEmpleados.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btngestionEmpleados.setBounds(40, 348, 461, 40);
			panel.add(btngestionEmpleados);
		}

		JButton btnCerrarSesion = new JButton("Cerrar Sesión");
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SesionEmpleado.cerrarSesion();
				VenPrincipal venLogin = new VenPrincipal();
				venLogin.setVisible(true);
				dispose();
			}
		});
		btnCerrarSesion.setBounds(40, 450, 461, 40);  // Posición en la parte inferior
		panel.add(btnCerrarSesion);

		JLabel lblTitulo = new JLabel("Magicas: el encuentro");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 28));
		contentPane.add(lblTitulo, BorderLayout.NORTH);
	}
	
	// Agregar método estático para manejar el carrito
	public static void agregarAlCarrito(String producto) {
	    if (textCarrito != null) {
	        // Parsear el producto seleccionado para obtener el precio
	        String[] lineas = producto.split("\n");
	        String nombre = "";
	        double precio = 0.0;
	        
	        for (String linea : lineas) {
	            if (linea.startsWith("Nombre: ")) {
	                nombre = linea.substring(8);
	            } else if (linea.startsWith("Precio: ")) {
	                precio = Double.parseDouble(linea.substring(8, linea.length() - 1));
	            }
	        }
	        
	        // Agregar al carrito
	        textCarrito.append(nombre + " - " + precio + "€\n");
	        total += precio;
	        lblTotal_1.setText(String.format("%.2f €", total));
	    }
	}
}
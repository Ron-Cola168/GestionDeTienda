package Ventanas;

import util.Carrito;
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
    private static JTextArea textCarrito;
    private static JLabel lblTotal_1;
    private static Carrito carrito;


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
				setVisible(false);
			}
		});
		btnJuegosMesa.setBounds(40, 74, 147, 101);
		panel.add(btnJuegosMesa);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(641, 0, 203, 497);
		panel.add(panel_1);
		panel_1.setBackground(new Color(199, 169, 139));
		panel_1.setLayout(null);

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

		lblTotal_1 = new JLabel("0.00 €");
		lblTotal_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTotal_1.setBounds(136, 378, 57, 33);
		panel_1.add(lblTotal_1);
		
		JButton btnTCG = new JButton("TCG");
		btnTCG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VenTCG v1 = new VenTCG();
				v1.setVisible(true);
				setVisible(false);
			}
		});
		btnTCG.setBounds(197, 74, 147, 101);
		panel.add(btnTCG);

		JButton btnInventario = new JButton("Inventario");
		btnInventario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VenInventario v1 = new VenInventario();
				v1.setVisible(true);
				setVisible(false);
			}
		});
		btnInventario.setBounds(354, 74, 147, 101);
		panel.add(btnInventario);

		/**Botones de administrador**/
		if(SesionEmpleado.esAdmin()){

			JButton btngestionEmpleados = new JButton("Gestionar Empleados");
			btngestionEmpleados.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btngestionEmpleados.setBounds(40, 186, 461, 101);
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
		
		carrito = new Carrito(textCarrito, lblTotal_1);
	}
	
	
/**public static void agregarAlCarrito(String producto) {
    if (carrito != null) {
        try {
            String[] lineas = producto.split("\n");
            String nombre = "";
            double precio = 0.0;
            
            for (String linea : lineas) {
                if (linea.startsWith("Nombre: ")) {
                    nombre = linea.substring("Nombre: ".length()).trim();
                } else if (linea.startsWith("Precio: ")) {
                    String precioStr = linea.substring("Precio: ".length())
                                         .replace("€", "").trim();
                    precio = Double.parseDouble(precioStr);
                }
            }
            
            if (!nombre.isEmpty() && precio > 0) {
                carrito.agregarItem(nombre, precio);
            }
        } catch (Exception e) {
            System.out.println("Error al procesar el producto: " + e.getMessage());
        }
    }
}**/
}
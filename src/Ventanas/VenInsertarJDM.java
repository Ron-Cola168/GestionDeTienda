package Ventanas;

import ClasesModelo.jdm;
import ClasesDAO.jdmDAO;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.sql.SQLException;

/**
 * Ventana para insertar un nuevo juego de mesa en la base de datos.
 * Permite al usuario introducir el nombre, precio, stock, género y número de jugadores del juego.
 */
public class VenInsertarJDM extends JFrame {
    private JPanel contentPane;
    private JTextField textNombre, textPrecio, textStock, textNumJugadores;
    private JComboBox<String> comboGenero;

    /**
     * Crea una nueva ventana para insertar un juego de mesa.
     */
    public VenInsertarJDM() {
        setTitle("Insertar Juego de Mesa");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 400);
        setResizable(false);

        contentPane = new JPanel();
        contentPane.setBackground(new Color(199, 169, 139));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Título de la ventana
        JLabel lblTitulo = new JLabel("Insertar Juego de Mesa");
        lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblTitulo.setBounds(115, 11, 220, 25);
        contentPane.add(lblTitulo);

        // Etiquetas y campos de texto para la información del juego
        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNombre.setBounds(50, 60, 100, 20);
        contentPane.add(lblNombre);

        textNombre = new JTextField();
        textNombre.setBounds(160, 60, 200, 20);
        contentPane.add(textNombre);

        JLabel lblPrecio = new JLabel("Precio:");
        lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblPrecio.setBounds(50, 100, 100, 20);
        contentPane.add(lblPrecio);

        textPrecio = new JTextField();
        textPrecio.setBounds(160, 100, 200, 20);
        contentPane.add(textPrecio);

        JLabel lblStock = new JLabel("Stock:");
        lblStock.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblStock.setBounds(50, 140, 100, 20);
        contentPane.add(lblStock);

        textStock = new JTextField();
        textStock.setBounds(160, 140, 200, 20);
        contentPane.add(textStock);

        JLabel lblGenero = new JLabel("Género:");
        lblGenero.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblGenero.setBounds(50, 180, 100, 20);
        contentPane.add(lblGenero);

        comboGenero = new JComboBox<>(new String[]{"Rol", "Cooperativo", "Competitivo", "Estrategia", "Familiares", "Misterio"});
        comboGenero.setBounds(160, 180, 200, 20);
        contentPane.add(comboGenero);

        JLabel lblNumJugadores = new JLabel("Nº Jugadores:");
        lblNumJugadores.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNumJugadores.setBounds(50, 220, 100, 20);
        contentPane.add(lblNumJugadores);

        textNumJugadores = new JTextField();
        textNumJugadores.setBounds(160, 220, 200, 20);
        contentPane.add(textNumJugadores);

        // Botones para guardar y cancelar
        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(100, 280, 100, 30);
        btnGuardar.addActionListener(e -> guardarJuego());
        contentPane.add(btnGuardar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(250, 280, 100, 30);
        btnCancelar.addActionListener(e -> dispose());
        contentPane.add(btnCancelar);
    }

    /**
     * Método que se ejecuta al hacer clic en el botón "Guardar".
     * Recoge la información introducida por el usuario y llama al método
     * del {@link jdmDAO} para insertar el nuevo juego en la base de datos.
     * Muestra mensajes de éxito o error según el resultado de la operación.
     */
    private void guardarJuego() {
        try {
            String nombre = textNombre.getText();
            String precioTexto = textPrecio.getText().replace("€", "").trim(); // Elimina "€" y espacios
            int precio = Integer.parseInt(precioTexto);
            int stock = Integer.parseInt(textStock.getText());
            String genero = (String) comboGenero.getSelectedItem();
            int numJugadores = Integer.parseInt(textNumJugadores.getText());

            // Crea un nuevo objeto jdm con la información recogida
            jdm nuevoJuego = new jdm(0, nombre, precio, stock, genero, numJugadores, 0);

            // Llama al método del DAO para insertar el juego en la base de datos
            if (jdmDAO.insertarJuego(nuevoJuego)) {
                JOptionPane.showMessageDialog(this,
                        "Juego insertado correctamente",
                        "Éxito",
                        JOptionPane.INFORMATION_MESSAGE);
                dispose(); // Cierra la ventana después de guardar
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Por favor, introduzca valores numéricos válidos para precio, stock y número de jugadores",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,
                    "Error al insertar el juego: " + ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
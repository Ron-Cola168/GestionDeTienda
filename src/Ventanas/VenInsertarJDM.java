package Ventanas;

import ClasesModelo.jdm;
import ClasesDAO.jdmDAO;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.sql.SQLException;

public class VenInsertarJDM extends JFrame {
    private JPanel contentPane;
    private JTextField textNombre, textPrecio, textStock, textNumJugadores;
    private JComboBox<String> comboGenero;

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

        // Título
        JLabel lblTitulo = new JLabel("Insertar Juego de Mesa");
        lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblTitulo.setBounds(115, 11, 220, 25);
        contentPane.add(lblTitulo);

        // Campos
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

        // Botones
        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(100, 280, 100, 30);
        btnGuardar.addActionListener(e -> guardarJuego());
        contentPane.add(btnGuardar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(250, 280, 100, 30);
        btnCancelar.addActionListener(e -> dispose());
        contentPane.add(btnCancelar);
    }

    private void guardarJuego() {
        try {
            String nombre = textNombre.getText();
            String precioTexto = textPrecio.getText().replace("€", "").trim(); // Elimina "€" y espacios alrededor
            int precio = Integer.parseInt(precioTexto);
            int stock = Integer.parseInt(textStock.getText());
            String genero = (String) comboGenero.getSelectedItem();
            int numJugadores = Integer.parseInt(textNumJugadores.getText());

            jdm nuevoJuego = new jdm(0, nombre, precio, stock, genero, numJugadores, 0);
            
            if (jdmDAO.insertarJuego(nuevoJuego)) {
                JOptionPane.showMessageDialog(this, 
                    "Juego insertado correctamente", 
                    "Éxito", 
                    JOptionPane.INFORMATION_MESSAGE);
                dispose();
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
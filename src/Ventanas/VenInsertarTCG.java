package Ventanas;

import ClasesModelo.TCG;
import ClasesDAO.TCGDAO;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.sql.SQLException;

public class VenInsertarTCG extends JFrame {
    private JPanel contentPane;
    private JTextField textNombre, textPrecio, textStock;
    private JComboBox<String> comboTipo, comboJuego;

    public VenInsertarTCG() {
        setTitle("Insertar Carta Coleccionable");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 400);
        setResizable(false);

        contentPane = new JPanel();
        contentPane.setBackground(new Color(199, 169, 139));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Título
        JLabel lblTitulo = new JLabel("Insertar Carta Coleccionable");
        lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblTitulo.setBounds(95, 11, 260, 25);
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

        JLabel lblTipo = new JLabel("Tipo:");
        lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblTipo.setBounds(50, 180, 100, 20);
        contentPane.add(lblTipo);

        comboTipo = new JComboBox<>(new String[]{"Común", "Infrecuente", "Rara", "Mítica", "Promocional"});
        comboTipo.setBounds(160, 180, 200, 20);
        contentPane.add(comboTipo);

        JLabel lblJuego = new JLabel("Juego:");
        lblJuego.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblJuego.setBounds(50, 220, 100, 20);
        contentPane.add(lblJuego);

        comboJuego = new JComboBox<>(new String[]{"Magic", "Pokemon", "Yu-Gi-Oh!", "Dragon Ball", "Flesh and Blood"});
        comboJuego.setBounds(160, 220, 200, 20);
        contentPane.add(comboJuego);

        // Botones
        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(100, 280, 100, 30);
        btnGuardar.addActionListener(e -> guardarCarta());
        contentPane.add(btnGuardar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(250, 280, 100, 30);
        btnCancelar.addActionListener(e -> dispose());
        contentPane.add(btnCancelar);
    }

    private void guardarCarta() {
        try {
            String nombre = textNombre.getText();
            int precio = Integer.parseInt(textPrecio.getText());
            int stock = Integer.parseInt(textStock.getText());
            String tipo = (String) comboTipo.getSelectedItem();
            String juego = (String) comboJuego.getSelectedItem();

            TCG nuevaCarta = new TCG(0, nombre, precio, stock, 0, tipo, juego);
            
            if (TCGDAO.insertarTCG(nuevaCarta)) {
                JOptionPane.showMessageDialog(this, 
                    "Carta insertada correctamente", 
                    "Éxito", 
                    JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                "Por favor, introduzca valores numéricos válidos para precio y stock",
                "Error",
                JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,
                "Error al insertar la carta: " + ex.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }
}
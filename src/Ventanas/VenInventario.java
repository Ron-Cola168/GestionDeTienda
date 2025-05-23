package Ventanas;

import ClasesDAO.TCGDAO;
import ClasesDAO.jdmDAO;
import ClasesModelo.TCG;
import ClasesModelo.jdm;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;
import java.util.List;

public class VenInventario extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextPane textListaProductos;
    private JScrollPane scrollPane;

    public VenInventario() {
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 870, 580);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(199, 169, 139));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Inicializar JTextPane y JScrollPane
        textListaProductos = new JTextPane();
        textListaProductos.setEditable(false);
        scrollPane = new JScrollPane(textListaProductos);
        scrollPane.setBounds(522, 88, 322, 418);
        contentPane.add(scrollPane);

        // Título
        JLabel lblTitulo = new JLabel("Inventario");
        lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 28));
        lblTitulo.setBounds(341, 11, 143, 78);
        contentPane.add(lblTitulo);

        // Panel para Juegos de Mesa
        JPanel panelJDM = new JPanel();
        panelJDM.setBounds(35, 88, 218, 200); // Reducir el tamaño para solo los botones principales
        panelJDM.setBackground(new Color(199, 169, 139));
        contentPane.add(panelJDM);
        panelJDM.setLayout(null);

        // Botones para JDM
        JButton btnInsertarJDM = new JButton("Insertar JDM");
        btnInsertarJDM.setBounds(0, 0, 218, 38);
        panelJDM.add(btnInsertarJDM);

        JButton btnActualizarJDM = new JButton("Actualizar JDM");
        btnActualizarJDM.setBounds(0, 50, 218, 38);
        panelJDM.add(btnActualizarJDM);

        JButton btnEliminarJDM = new JButton("Eliminar JDM");
        btnEliminarJDM.setBounds(0, 100, 218, 38);
        panelJDM.add(btnEliminarJDM);

        JButton btnListarJDM = new JButton("Listar JDM");
        btnListarJDM.setBounds(0, 150, 218, 38);
        panelJDM.add(btnListarJDM);

        // Panel para TCG
        JPanel panelTCG = new JPanel();
        panelTCG.setBounds(266, 88, 218, 200); // Reducir el tamaño para solo los botones principales
        panelTCG.setBackground(new Color(199, 169, 139));
        contentPane.add(panelTCG);
        panelTCG.setLayout(null);

        // Botones para TCG
        JButton btnInsertarTCG = new JButton("Insertar TCG");
        btnInsertarTCG.setBounds(0, 0, 218, 38);
        panelTCG.add(btnInsertarTCG);

        JButton btnActualizarTCG = new JButton("Actualizar TCG");
        btnActualizarTCG.setBounds(0, 50, 218, 38);
        panelTCG.add(btnActualizarTCG);

        JButton btnEliminarTCG = new JButton("Eliminar TCG");
        btnEliminarTCG.setBounds(0, 100, 218, 38);
        panelTCG.add(btnEliminarTCG);

        JButton btnListarTCG = new JButton("Listar TCG");
        btnListarTCG.setBounds(0, 150, 218, 38);
        panelTCG.add(btnListarTCG);

        // Botón para mostrar todo el inventario
        JButton btnListarTodo = new JButton("Mostrar Todo el Inventario");
        btnListarTodo.setBounds(35, 300, 449, 38); // Mover un poco hacia abajo
        contentPane.add(btnListarTodo);

        // Botón Volver
        JButton btnVolver = new JButton("VOLVER");
        btnVolver.setBounds(35, 350, 449, 38); // Mover un poco hacia abajo
        contentPane.add(btnVolver);

        // ActionListeners para abrir los diálogos correspondientes
        btnInsertarJDM.addActionListener(e -> mostrarDialogoInsertarJDM());
        btnActualizarJDM.addActionListener(e -> mostrarDialogoActualizarJDM());
        btnEliminarJDM.addActionListener(e -> mostrarDialogoEliminarJDM());
        btnListarJDM.addActionListener(e -> listarJuegosDeMesa());

        btnInsertarTCG.addActionListener(e -> mostrarDialogoInsertarTCG());
        btnActualizarTCG.addActionListener(e -> mostrarDialogoActualizarTCG());
        btnEliminarTCG.addActionListener(e -> mostrarDialogoEliminarTCG());
        btnListarTCG.addActionListener(e -> listarTCG());

        btnListarTodo.addActionListener(e -> {
            try {
                mostrarInventarioCompleto();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });

        btnVolver.addActionListener(e -> {
            VenMenu v1 = new VenMenu();
            v1.setVisible(true);
            dispose();
        });
    }

    private void listarJuegosDeMesa() {
        try {
            List<jdm> juegos = jdmDAO.obtenerTodosLosJuegos();
            mostrarJDM(juegos);
        } catch (SQLException ex) {
            mostrarError("Error al cargar los juegos de mesa: " + ex.getMessage());
        }
    }

    private void listarTCG() {
        try {
            List<TCG> tcgs = TCGDAO.obtenerTCGS();
            mostrarTCG(tcgs);
        } catch (SQLException ex) {
            mostrarError("Error al cargar las cartas TCG: " + ex.getMessage());
        }
    }

    private void mostrarDialogoInsertarJDM() {
        JDialog dialogoInsertarJDM = new JDialog(this, "Insertar Juego de Mesa", true);
        dialogoInsertarJDM.getContentPane().setLayout(new BoxLayout(dialogoInsertarJDM.getContentPane(), BoxLayout.Y_AXIS));

        JTextField txtNombre = new JTextField(20);
        JTextField txtPrecio = new JTextField(10);
        JTextField txtStock = new JTextField(10);
        JTextField txtGenero = new JTextField(20);
        JTextField txtNumJugadores = new JTextField(10);

        dialogoInsertarJDM.add(new JLabel("Nombre:"));
        dialogoInsertarJDM.add(txtNombre);
        dialogoInsertarJDM.add(new JLabel("Precio:"));
        dialogoInsertarJDM.add(txtPrecio);
        dialogoInsertarJDM.add(new JLabel("Stock:"));
        dialogoInsertarJDM.add(txtStock);
        dialogoInsertarJDM.add(new JLabel("Género:"));
        dialogoInsertarJDM.add(txtGenero);
        dialogoInsertarJDM.add(new JLabel("Número de Jugadores:"));
        dialogoInsertarJDM.add(txtNumJugadores);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(e -> {
            try {
                String nombre = txtNombre.getText();
                int precio = Integer.parseInt(txtPrecio.getText());
                int stock = Integer.parseInt(txtStock.getText());
                String genero = txtGenero.getText();
                int numJugadores = Integer.parseInt(txtNumJugadores.getText());
                int ventas = 0;

                jdm nuevoJuego = new jdm(nombre, precio, stock, genero, numJugadores, 0); // Ventas se inicializa a 0
                jdmDAO.insertarJuego(nuevoJuego);
                listarJuegosDeMesa(); // Actualizar la lista después de insertar
                dialogoInsertarJDM.dispose();
                JOptionPane.showMessageDialog(this, "Juego de mesa insertado correctamente.");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Por favor, introduce valores numéricos válidos para Precio, Stock y Número de Jugadores.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error al insertar el juego de mesa: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        dialogoInsertarJDM.add(btnGuardar);

        dialogoInsertarJDM.pack();
        dialogoInsertarJDM.setLocationRelativeTo(this);
        dialogoInsertarJDM.setVisible(true);
    }

    private void mostrarDialogoEliminarJDM() {
        String nombreEliminar = JOptionPane.showInputDialog(this, "Ingrese el nombre del juego de mesa a eliminar:");
        if (nombreEliminar != null && !nombreEliminar.trim().isEmpty()) {
            int confirmacion = JOptionPane.showConfirmDialog(this, "¿Seguro que desea eliminar \"" + nombreEliminar + "\"?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
            if (confirmacion == JOptionPane.YES_OPTION) {
                try {
                    jdmDAO.eliminarJuego(nombreEliminar);
                    listarJuegosDeMesa(); // Actualizar la lista
                    JOptionPane.showMessageDialog(this, "Juego de mesa \"" + nombreEliminar + "\" eliminado correctamente.");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Error al eliminar el juego de mesa: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    private void mostrarDialogoActualizarJDM() {
        String nombreBuscar = JOptionPane.showInputDialog(this, "Ingrese el nombre del juego de mesa a actualizar:");
        if (nombreBuscar != null && !nombreBuscar.trim().isEmpty()) {
            try {
                jdm juegoExistente = jdmDAO.obtenerJuegoPorNombre(nombreBuscar);
                if (juegoExistente == null) {
                    JOptionPane.showMessageDialog(this, "No se encontró ningún juego de mesa con el nombre \"" + nombreBuscar + "\".", "Información", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }

                JDialog dialogoActualizarJDM = new JDialog(this, "Actualizar Juego de Mesa", true);
                dialogoActualizarJDM.getContentPane().setLayout(new BoxLayout(dialogoActualizarJDM.getContentPane(), BoxLayout.Y_AXIS));

                JTextField txtNombre = new JTextField(juegoExistente.getNombre(), 20);
                JTextField txtPrecio = new JTextField(String.valueOf(juegoExistente.getPrecio()), 10);
                JTextField txtStock = new JTextField(String.valueOf(juegoExistente.getStock()), 10);
                JTextField txtGenero = new JTextField(juegoExistente.getGenero(), 20);
                JTextField txtNumJugadores = new JTextField(String.valueOf(juegoExistente.getNumeroJugadores()), 10);

                dialogoActualizarJDM.add(new JLabel("Nombre:"));
                dialogoActualizarJDM.add(txtNombre);
                dialogoActualizarJDM.add(new JLabel("Precio:"));
                dialogoActualizarJDM.add(txtPrecio);
                dialogoActualizarJDM.add(new JLabel("Stock:"));
                dialogoActualizarJDM.add(txtStock);
                dialogoActualizarJDM.add(new JLabel("Género:"));
                dialogoActualizarJDM.add(txtGenero);
                dialogoActualizarJDM.add(new JLabel("Número de Jugadores:"));
                dialogoActualizarJDM.add(txtNumJugadores);

                JButton btnActualizar = new JButton("Actualizar");
                btnActualizar.addActionListener(e -> {
                    try {
                        String nuevoNombre = txtNombre.getText();
                        int nuevoPrecio = Integer.parseInt(txtPrecio.getText());
                        int nuevoStock = Integer.parseInt(txtStock.getText());
                        String nuevoGenero = txtGenero.getText();
                        int nuevoNumJugadores = Integer.parseInt(txtNumJugadores.getText());

                        juegoExistente.setNombre(nuevoNombre);
                        juegoExistente.setPrecio(nuevoPrecio);
                        juegoExistente.setStock(nuevoStock);
                        juegoExistente.setGenero(nuevoGenero);
                        juegoExistente.setNumeroJugadores(nuevoNumJugadores);

                        jdmDAO.actualizarJuego(juegoExistente);
                        listarJuegosDeMesa(); // Actualizar la lista
                        dialogoActualizarJDM.dispose();
                        JOptionPane.showMessageDialog(this, "Juego de mesa \"" + nuevoNombre + "\" actualizado correctamente.");
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(this, "Por favor, introduce valores numéricos válidos para Precio, Stock y Número de Jugadores.", "Error", JOptionPane.ERROR_MESSAGE);
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(this, "Error al actualizar el juego de mesa: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                });
                dialogoActualizarJDM.add(btnActualizar);

                dialogoActualizarJDM.pack();
                dialogoActualizarJDM.setLocationRelativeTo(this);
                dialogoActualizarJDM.setVisible(true);

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error al buscar el juego de mesa: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void mostrarDialogoInsertarTCG() {
        JDialog dialogoInsertarTCG = new JDialog(this, "Insertar TCG", true);
        dialogoInsertarTCG.getContentPane().setLayout(new BoxLayout(dialogoInsertarTCG.getContentPane(), BoxLayout.Y_AXIS));

        JTextField txtNombre = new JTextField(20);
        JTextField txtPrecio = new JTextField(10);
        JTextField txtStock = new JTextField(10);
        JTextField txtTipo = new JTextField(20);
        JTextField txtJuego = new JTextField(20);

        dialogoInsertarTCG.add(new JLabel("Nombre:"));
        dialogoInsertarTCG.add(txtNombre);
        dialogoInsertarTCG.add(new JLabel("Precio:"));
        dialogoInsertarTCG.add(txtPrecio);
        dialogoInsertarTCG.add(new JLabel("Stock:"));
        dialogoInsertarTCG.add(txtStock);
        dialogoInsertarTCG.add(new JLabel("Tipo:"));
        dialogoInsertarTCG.add(txtTipo);
        dialogoInsertarTCG.add(new JLabel("Juego:"));
        dialogoInsertarTCG.add(txtJuego);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(e -> {
            try {
                String nombre = txtNombre.getText();
                int precio = Integer.parseInt(txtPrecio.getText());
                int stock = Integer.parseInt(txtStock.getText());
                String tipo = txtTipo.getText();
                String juego = txtJuego.getText();

                TCG nuevoTCG = new TCG(nombre, precio, stock, 0, tipo, juego); // Ventas se inicializa a 0
                TCGDAO.insertarTCG(nuevoTCG);
                listarTCG(); // Actualizar la lista después de insertar
                dialogoInsertarTCG.dispose();
                JOptionPane.showMessageDialog(this, "Carta TCG insertada correctamente.");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Por favor, introduce valores numéricos válidos para Precio y Stock.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error al insertar la carta TCG: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        dialogoInsertarTCG.add(btnGuardar);

        dialogoInsertarTCG.pack();
        dialogoInsertarTCG.setLocationRelativeTo(this);
        dialogoInsertarTCG.setVisible(true);
    }

    private void mostrarDialogoEliminarTCG() {
        String nombreEliminar = JOptionPane.showInputDialog(this, "Ingrese el nombre de la carta TCG a eliminar:");
        if (nombreEliminar != null && !nombreEliminar.trim().isEmpty()) {
            int confirmacion = JOptionPane.showConfirmDialog(this, "¿Seguro que desea eliminar \"" + nombreEliminar + "\"?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
            if (confirmacion == JOptionPane.YES_OPTION) {
                try {
                    TCGDAO.eliminarTCG(nombreEliminar);
                    listarTCG(); // Actualizar la lista
                    JOptionPane.showMessageDialog(this, "Carta TCG \"" + nombreEliminar + "\" eliminada correctamente.");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Error al eliminar la carta TCG: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    private void mostrarDialogoActualizarTCG() {
        String nombreBuscar = JOptionPane.showInputDialog(this, "Ingrese el nombre de la carta TCG a actualizar:");
        if (nombreBuscar != null && !nombreBuscar.trim().isEmpty()) {
            TCG tcgExistente = TCGDAO.obtenerTCGPorNombre(nombreBuscar);
            if (tcgExistente == null) {
                JOptionPane.showMessageDialog(this, "No se encontró ninguna carta TCG con el nombre \"" + nombreBuscar + "\".", "Información", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            JDialog dialogoActualizarTCG = new JDialog(this, "Actualizar TCG", true);
            dialogoActualizarTCG.getContentPane().setLayout(new BoxLayout(dialogoActualizarTCG.getContentPane(), BoxLayout.Y_AXIS));

            JTextField txtNombre = new JTextField(tcgExistente.getNombre(), 20);
            JTextField txtPrecio = new JTextField(String.valueOf(tcgExistente.getPrecio()), 10);
            JTextField txtStock = new JTextField(String.valueOf(tcgExistente.getStock()), 10);
            JTextField txtTipo = new JTextField(tcgExistente.getTipo(), 20);
            JTextField txtJuego = new JTextField(tcgExistente.getJuego(), 20);

            dialogoActualizarTCG.add(new JLabel("Nombre:"));
            dialogoActualizarTCG.add(txtNombre);
            dialogoActualizarTCG.add(new JLabel("Precio:"));
            dialogoActualizarTCG.add(txtPrecio);
            dialogoActualizarTCG.add(new JLabel("Stock:"));
            dialogoActualizarTCG.add(txtStock);
            dialogoActualizarTCG.add(new JLabel("Tipo:"));
            dialogoActualizarTCG.add(txtTipo);
            dialogoActualizarTCG.add(new JLabel("Juego:"));
            dialogoActualizarTCG.add(txtJuego);

            JButton btnActualizar = new JButton("Actualizar");
            btnActualizar.addActionListener(e -> {
                try {
                    String nuevoNombre = txtNombre.getText();
                    int nuevoPrecio = Integer.parseInt(txtPrecio.getText());
                    int nuevoStock = Integer.parseInt(txtStock.getText());
                    String nuevoTipo = txtTipo.getText();
                    String nuevoJuego = txtJuego.getText();

                    tcgExistente.setNombre(nuevoNombre);
                    tcgExistente.setPrecio(nuevoPrecio);
                    tcgExistente.setStock(nuevoStock);
                    tcgExistente.setTipo(nuevoTipo);
                    tcgExistente.setJuego(nuevoJuego);

                    TCGDAO.actualizarTCG(tcgExistente);
                    listarTCG(); // Actualizar la lista
                    dialogoActualizarTCG.dispose();
                    JOptionPane.showMessageDialog(this, "Carta TCG \"" + nuevoNombre + "\" actualizada correctamente.");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Por favor, introduce valores numéricos válidos para Precio y Stock.", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Error al actualizar la carta TCG: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            });
            dialogoActualizarTCG.add(btnActualizar);

            dialogoActualizarTCG.pack();
            dialogoActualizarTCG.setLocationRelativeTo(this);
            dialogoActualizarTCG.setVisible(true);

        }
    }

    private void mostrarJDM(List<jdm> juegos) {
        StringBuilder sb = new StringBuilder();
        sb.append("=== JUEGOS DE MESA ===\n\n");
        for (jdm juego : juegos) {
            sb.append("Nombre: ").append(juego.getNombre()).append("\n");
            sb.append("Precio: ").append(juego.getPrecio()).append("€\n");
            sb.append("Stock: ").append(juego.getStock()).append("\n");
            sb.append("Género: ").append(juego.getGenero()).append("\n");
            sb.append("Número de Jugadores: ").append(juego.getNumeroJugadores()).append("\n");
            sb.append("Ventas: ").append(juego.getVentas()).append("\n");
            sb.append("------------------\n");
        }
        textListaProductos.setText(sb.toString());
        textListaProductos.setCaretPosition(0);
    }

    private void mostrarTCG(List<TCG> tcgs) {
        StringBuilder sb = new StringBuilder();
        sb.append("=== CARTAS COLECCIONABLES ===\n\n");
        for (TCG tcg : tcgs) {
            sb.append("Nombre: ").append(tcg.getNombre()).append("\n");
            sb.append("Precio: ").append(tcg.getPrecio()).append("€\n");
            sb.append("Stock: ").append(tcg.getStock()).append("\n");
            sb.append("Tipo: ").append(tcg.getTipo()).append("\n");
            sb.append("Juego: ").append(tcg.getJuego()).append("\n");
            sb.append("Ventas: ").append(tcg.getVentas()).append("\n");
            sb.append("------------------\n");
        }
        textListaProductos.setText(sb.toString());
        textListaProductos.setCaretPosition(0);
    }

    private void mostrarInventarioCompleto() throws SQLException {
        List<jdm> juegos = jdmDAO.obtenerTodosLosJuegos();
        List<TCG> tcgs = TCGDAO.obtenerTCGS();

        StringBuilder sb = new StringBuilder();
        sb.append("====== INVENTARIO COMPLETO ======\n\n");

        sb.append("=== JUEGOS DE MESA ===\n\n");
        for (jdm juego : juegos) {
            sb.append("Nombre: ").append(juego.getNombre()).append("\n");
            sb.append("Precio: ").append(juego.getPrecio()).append("€\n");
            sb.append("Stock: ").append(juego.getStock()).append("\n");
            sb.append("Género: ").append(juego.getGenero()).append("\n");
            sb.append("Número de Jugadores: ").append(juego.getNumeroJugadores()).append("\n");
            sb.append("Ventas: ").append(juego.getVentas()).append("\n");
            sb.append("------------------\n");
        }

        sb.append("\n=== CARTAS COLECCIONABLES ===\n\n");
        for (TCG tcg : tcgs) {
            sb.append("Nombre: ").append(tcg.getNombre()).append("\n");
            sb.append("Precio: ").append(tcg.getPrecio()).append("€\n");
            sb.append("Stock: ").append(tcg.getStock()).append("\n");
            sb.append("Tipo: ").append(tcg.getTipo()).append("\n");
            sb.append("Juego: ").append(tcg.getJuego()).append("\n");
            sb.append("Ventas: ").append(tcg.getVentas()).append("\n");
            sb.append("------------------\n");
        }

        textListaProductos.setText(sb.toString());
        textListaProductos.setCaretPosition(0);
    }

    private void mostrarError(String mensaje) {
        textListaProductos.setText("ERROR: " + mensaje);
    }
}
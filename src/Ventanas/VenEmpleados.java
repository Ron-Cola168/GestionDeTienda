package Ventanas;

import ClasesDAO.EmpleadoDAO;
import ClasesModelo.Empleado;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.sql.SQLException;
import java.util.List;

/**
 * Ventana para la gestión de empleados.
 * Permite insertar, actualizar, eliminar y listar empleados del sistema.
 */
public class VenEmpleados extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextPane textListaEmpleados;
    private JScrollPane scrollPane;

    /**
     * Crea una nueva ventana para la gestión de empleados.
     */
    public VenEmpleados() {
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 870, 580);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(199, 169, 139));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Area de texto donde se listan los empleados
        textListaEmpleados = new JTextPane();
        textListaEmpleados.setEditable(false);
        scrollPane = new JScrollPane(textListaEmpleados);
        scrollPane.setBounds(522, 88, 322, 418);
        contentPane.add(scrollPane);

        // Título de la ventana
        JLabel lblTitulo = new JLabel("Gestión de Empleados");
        lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 28));
        lblTitulo.setBounds(280, 11, 310, 78);
        contentPane.add(lblTitulo);

        // Panel que contiene los botones de gestión de empleados
        JPanel panelEmpleados = new JPanel();
        panelEmpleados.setBounds(35, 88, 449, 200);
        panelEmpleados.setBackground(new Color(199, 169, 139));
        contentPane.add(panelEmpleados);
        panelEmpleados.setLayout(null);

        // Dimensiones comunes para los botones
        int buttonWidth = 449;
        int buttonHeight = 38;
        Dimension commonButtonSize = new Dimension(buttonWidth, buttonHeight);
        int yOffset = 0;
        int verticalSpacing = 10; // Espacio vertical entre botones

        // Botones para las operaciones con empleados
        JButton btnInsertarEmpleado = new JButton("Insertar Empleado");
        btnInsertarEmpleado.setBounds(0, yOffset, commonButtonSize.width, commonButtonSize.height);
        panelEmpleados.add(btnInsertarEmpleado);
        yOffset += commonButtonSize.height + verticalSpacing;

        JButton btnActualizarEmpleado = new JButton("Actualizar Empleado");
        btnActualizarEmpleado.setBounds(0, yOffset, commonButtonSize.width, commonButtonSize.height);
        panelEmpleados.add(btnActualizarEmpleado);
        yOffset += commonButtonSize.height + verticalSpacing;

        JButton btnEliminarEmpleado = new JButton("Eliminar Empleado");
        btnEliminarEmpleado.setBounds(0, yOffset, commonButtonSize.width, commonButtonSize.height);
        panelEmpleados.add(btnEliminarEmpleado);
        yOffset += commonButtonSize.height + verticalSpacing;

        JButton btnListarEmpleados = new JButton("Listar Empleados");
        btnListarEmpleados.setBounds(0, yOffset, commonButtonSize.width, commonButtonSize.height);
        panelEmpleados.add(btnListarEmpleados);

        // Botón para volver al menú principal
        JButton btnVolver = new JButton("VOLVER");
        btnVolver.setBounds(35, 300, buttonWidth, buttonHeight);
        contentPane.add(btnVolver);

        // Asignación de las acciones a los botones
        btnInsertarEmpleado.addActionListener(e -> mostrarDialogoInsertarEmpleado());
        btnActualizarEmpleado.addActionListener(e -> mostrarDialogoActualizarEmpleado());
        btnEliminarEmpleado.addActionListener(e -> mostrarDialogoEliminarEmpleado());
        btnListarEmpleados.addActionListener(e -> listarEmpleados());
        btnVolver.addActionListener(e -> {
            VenMenu v1 = new VenMenu();
            v1.setVisible(true);
            dispose();
        });
    }

    /**
     * Carga y muestra la lista de todos los empleados en el área de texto.
     */
    private void listarEmpleados() {
        try {
            List<Empleado> empleados = EmpleadoDAO.obtenerTodosLosEmpleados();
            mostrarEmpleados(empleados);
        } catch (SQLException ex) {
            mostrarError("Error al cargar los empleados: " + ex.getMessage());
        }
    }

    /**
     * Muestra un diálogo para insertar un nuevo empleado.
     */
    private void mostrarDialogoInsertarEmpleado() {
        JDialog dialogoInsertarEmpleado = new JDialog(this, "Insertar Empleado", true);
        dialogoInsertarEmpleado.getContentPane().setLayout(new BoxLayout(dialogoInsertarEmpleado.getContentPane(), BoxLayout.Y_AXIS));

        JTextField txtNombre = new JTextField(20);
        JTextField txtApellidos = new JTextField(20);
        JTextField txtTipoEmpleado = new JTextField(20);
        JPasswordField txtContrasena = new JPasswordField(20);

        dialogoInsertarEmpleado.add(new JLabel("Nombre:"));
        dialogoInsertarEmpleado.add(txtNombre);
        dialogoInsertarEmpleado.add(new JLabel("Apellidos:"));
        dialogoInsertarEmpleado.add(txtApellidos);
        dialogoInsertarEmpleado.add(new JLabel("Tipo de Empleado:"));
        dialogoInsertarEmpleado.add(txtTipoEmpleado);
        dialogoInsertarEmpleado.add(new JLabel("Contraseña:"));
        dialogoInsertarEmpleado.add(txtContrasena);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(e -> {
            try {
                String nombre = txtNombre.getText();
                String apellidos = txtApellidos.getText();
                String tipoEmpleado = txtTipoEmpleado.getText();
                String contrasena = new String(txtContrasena.getPassword());

                Empleado nuevoEmpleado = new Empleado(0, nombre, apellidos, null, tipoEmpleado, contrasena);
                if (EmpleadoDAO.insertarEmpleado(nuevoEmpleado)) {
                    JOptionPane.showMessageDialog(this, "Empleado insertado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    listarEmpleados();
                    dialogoInsertarEmpleado.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Error al insertar el empleado.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error de base de datos: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        dialogoInsertarEmpleado.add(btnGuardar);

        dialogoInsertarEmpleado.pack();
        dialogoInsertarEmpleado.setLocationRelativeTo(this);
        dialogoInsertarEmpleado.setVisible(true);
    }

    /**
     * Muestra un diálogo para eliminar un empleado por su ID.
     */
    private void mostrarDialogoEliminarEmpleado() {
        String idStr = JOptionPane.showInputDialog(this, "Ingrese el ID del empleado a eliminar:");
        if (idStr != null && !idStr.trim().isEmpty()) {
            try {
                int id = Integer.parseInt(idStr);
                int confirmacion = JOptionPane.showConfirmDialog(this, "¿Seguro que desea eliminar al empleado con ID " + id + "?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
                if (confirmacion == JOptionPane.YES_OPTION) {
                    if (EmpleadoDAO.eliminarEmpleado(id)) {
                        JOptionPane.showMessageDialog(this, "Empleado con ID " + id + " eliminado correctamente.");
                        listarEmpleados();
                    } else {
                        JOptionPane.showMessageDialog(this, "No se encontró ningún empleado con el ID " + id + ".", "Información", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Por favor, ingrese un ID de empleado válido (número).", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error al eliminar el empleado: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Muestra un diálogo para actualizar la información de un empleado existente.
     */
    private void mostrarDialogoActualizarEmpleado() {
        String idStr = JOptionPane.showInputDialog(this, "Ingrese el ID del empleado a actualizar:");
        if (idStr != null && !idStr.trim().isEmpty()) {
            try {
                int idBuscar = Integer.parseInt(idStr);
                Empleado empleadoExistente = EmpleadoDAO.obtenerEmpleadoPorID(idBuscar);
                if (empleadoExistente == null) {
                    JOptionPane.showMessageDialog(this, "No se encontró ningún empleado con el ID " + idBuscar + ".", "Información", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }

                JDialog dialogoActualizarEmpleado = new JDialog(this, "Actualizar Empleado", true);
                dialogoActualizarEmpleado.getContentPane().setLayout(new BoxLayout(dialogoActualizarEmpleado.getContentPane(), BoxLayout.Y_AXIS));

                JTextField txtNombre = new JTextField(empleadoExistente.getNombre(), 20);
                JTextField txtApellidos = new JTextField(empleadoExistente.getApellidos(), 20);
                JTextField txtTipoEmpleado = new JTextField(empleadoExistente.getTipoEmpleado(), 20);
                JPasswordField txtContrasena = new JPasswordField(empleadoExistente.getContrasenia(), 20);

                dialogoActualizarEmpleado.add(new JLabel("Nombre:"));
                dialogoActualizarEmpleado.add(txtNombre);
                dialogoActualizarEmpleado.add(new JLabel("Apellidos:"));
                dialogoActualizarEmpleado.add(txtApellidos);
                dialogoActualizarEmpleado.add(new JLabel("Tipo de Empleado:"));
                dialogoActualizarEmpleado.add(txtTipoEmpleado);
                dialogoActualizarEmpleado.add(new JLabel("Contraseña:"));
                dialogoActualizarEmpleado.add(txtContrasena);

                JButton btnActualizar = new JButton("Actualizar");
                btnActualizar.addActionListener(e -> {
                    try {
                        String nuevoNombre = txtNombre.getText();
                        String nuevosApellidos = txtApellidos.getText();
                        String nuevoTipoEmpleado = txtTipoEmpleado.getText();
                        String nuevaContrasena = new String(txtContrasena.getPassword());

                        empleadoExistente.setNombre(nuevoNombre);
                        empleadoExistente.setApellidos(nuevosApellidos);
                        empleadoExistente.setCorreo(null); // Se mantiene el correo original o se podría permitir modificarlo
                        empleadoExistente.setTipoEmpleado(nuevoTipoEmpleado);
                        empleadoExistente.setContrasenia(nuevaContrasena);

                        if (EmpleadoDAO.actualizarEmpleado(empleadoExistente)) {
                            JOptionPane.showMessageDialog(this, "Empleado con ID " + idBuscar + " actualizado correctamente.");
                            listarEmpleados();
                            dialogoActualizarEmpleado.dispose();
                        } else {
                            JOptionPane.showMessageDialog(this, "Error al actualizar el empleado.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(this, "Error de base de datos: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                });
                dialogoActualizarEmpleado.add(btnActualizar);

                dialogoActualizarEmpleado.pack();
                dialogoActualizarEmpleado.setLocationRelativeTo(this);
                dialogoActualizarEmpleado.setVisible(true);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Por favor, ingrese un ID de empleado válido (número).", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error al buscar el empleado: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Muestra la lista de empleados en el área de texto.
     *
     * @param empleados La lista de objetos {@link Empleado} a mostrar.
     */
    private void mostrarEmpleados(List<Empleado> empleados) {
        StringBuilder sb = new StringBuilder();
        sb.append("=== EMPLEADOS ===\n\n");
        for (Empleado empleado : empleados) {
            sb.append("ID: ").append(empleado.getId()).append("\n");
            sb.append("Nombre: ").append(empleado.getNombre()).append("\n");
            sb.append("Apellidos: ").append(empleado.getApellidos()).append("\n");
            sb.append("Correo: ").append(empleado.getCorreo()).append("\n");
            sb.append("Tipo: ").append(empleado.getTipoEmpleado()).append("\n");
            sb.append("Contraseña: ").append("***").append("\n"); // No mostrar la contraseña completa
            sb.append("------------------\n");
        }
        textListaEmpleados.setText(sb.toString());
        textListaEmpleados.setCaretPosition(0); // Volver al inicio del texto
    }

    /**
     * Muestra un mensaje de error en el área de texto.
     *
     * @param mensaje El mensaje de error a mostrar.
     */
    private void mostrarError(String mensaje) {
        textListaEmpleados.setText("ERROR: " + mensaje);
    }
}
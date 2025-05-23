package Ventanas;

import ClasesDAO.EmpleadoDAO;
import ClasesModelo.Empleado;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension; // Importar Dimension
import java.sql.SQLException;
import java.util.List;

public class VenEmpleados extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextPane textListaEmpleados;
    private JScrollPane scrollPane;

    public VenEmpleados() {
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 870, 580);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(199, 169, 139));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Inicializar JTextPane y JScrollPane
        textListaEmpleados = new JTextPane();
        textListaEmpleados.setEditable(false);
        scrollPane = new JScrollPane(textListaEmpleados);
        scrollPane.setBounds(522, 88, 322, 418);
        contentPane.add(scrollPane);

        // Título
        JLabel lblTitulo = new JLabel("Gestión de Empleados");
        lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 28));
        lblTitulo.setBounds(280, 11, 310, 78);
        contentPane.add(lblTitulo);

        // Panel para Empleados
        JPanel panelEmpleados = new JPanel();
        // Ajustar el tamaño del panel para que contenga los botones correctamente
        panelEmpleados.setBounds(35, 88, 449, 200); // Ancho del botón VOLVER
        panelEmpleados.setBackground(new Color(199, 169, 139));
        contentPane.add(panelEmpleados);
        panelEmpleados.setLayout(null);

        // Definir las dimensiones deseadas para todos los botones
        // Basado en el ancho y alto del botón VOLVER (449, 38)
        int buttonWidth = 449;
        int buttonHeight = 38;
        Dimension commonButtonSize = new Dimension(buttonWidth, buttonHeight);

        // Botones para Empleados
        JButton btnInsertarEmpleado = new JButton("Insertar Empleado");
        JButton btnActualizarEmpleado = new JButton("Actualizar Empleado");
        JButton btnEliminarEmpleado = new JButton("Eliminar Empleado");
        JButton btnListarEmpleados = new JButton("Listar Empleados");

        // Botón Volver
        JButton btnVolver = new JButton("VOLVER");
        btnVolver.setBounds(35, 300, buttonWidth, buttonHeight); // Usar las dimensiones comunes
        contentPane.add(btnVolver);

        // Establecer las mismas dimensiones y posiciones para los botones de gestión
        int yOffset = 0;
        int verticalSpacing = 10; // Espacio vertical entre botones

        btnInsertarEmpleado.setBounds(0, yOffset, commonButtonSize.width, commonButtonSize.height);
        panelEmpleados.add(btnInsertarEmpleado);
        yOffset += commonButtonSize.height + verticalSpacing;

        btnActualizarEmpleado.setBounds(0, yOffset, commonButtonSize.width, commonButtonSize.height);
        panelEmpleados.add(btnActualizarEmpleado);
        yOffset += commonButtonSize.height + verticalSpacing;

        btnEliminarEmpleado.setBounds(0, yOffset, commonButtonSize.width, commonButtonSize.height);
        panelEmpleados.add(btnEliminarEmpleado);
        yOffset += commonButtonSize.height + verticalSpacing;

        btnListarEmpleados.setBounds(0, yOffset, commonButtonSize.width, commonButtonSize.height);
        panelEmpleados.add(btnListarEmpleados);

        // ActionListeners (estos siempre deben ir después de la inicialización de los botones)
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

    private void listarEmpleados() {
        try {
            List<Empleado> empleados = EmpleadoDAO.obtenerTodosLosEmpleados();
            mostrarEmpleados(empleados);
        } catch (SQLException ex) {
            mostrarError("Error al cargar los empleados: " + ex.getMessage());
        }
    }

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

                // Creamos el nuevo empleado pasando null para el correo, ya que se genera automáticamente
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
                // JTextField txtCorreo = new JTextField(empleadoExistente.getCorreo(), 20); // Eliminado
                JTextField txtTipoEmpleado = new JTextField(empleadoExistente.getTipoEmpleado(), 20);
                JPasswordField txtContrasena = new JPasswordField(empleadoExistente.getContraseña(), 20);

                dialogoActualizarEmpleado.add(new JLabel("Nombre:"));
                dialogoActualizarEmpleado.add(txtNombre);
                dialogoActualizarEmpleado.add(new JLabel("Apellidos:"));
                dialogoActualizarEmpleado.add(txtApellidos);
                // dialogoActualizarEmpleado.add(new JLabel("Correo:")); // Eliminado
                // dialogoActualizarEmpleado.add(txtCorreo); // Eliminado
                dialogoActualizarEmpleado.add(new JLabel("Tipo de Empleado:"));
                dialogoActualizarEmpleado.add(txtTipoEmpleado);
                dialogoActualizarEmpleado.add(new JLabel("Contraseña:"));
                dialogoActualizarEmpleado.add(txtContrasena);

                JButton btnActualizar = new JButton("Actualizar");
                btnActualizar.addActionListener(e -> {
                    try {
                        String nuevoNombre = txtNombre.getText();
                        String nuevosApellidos = txtApellidos.getText();
                        // String nuevoCorreo = txtCorreo.getText(); // Eliminado
                        String nuevoTipoEmpleado = txtTipoEmpleado.getText();
                        String nuevaContrasena = new String(txtContrasena.getPassword());

                        empleadoExistente.setNombre(nuevoNombre);
                        empleadoExistente.setApellidos(nuevosApellidos);
                        empleadoExistente.setCorreo(null); // Establecer a null o no modificar si se genera automáticamente
                        empleadoExistente.setTipoEmpleado(nuevoTipoEmpleado);
                        empleadoExistente.setContraseña(nuevaContrasena);

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
        textListaEmpleados.setCaretPosition(0);
    }

    private void mostrarError(String mensaje) {
        textListaEmpleados.setText("ERROR: " + mensaje);
    }

}
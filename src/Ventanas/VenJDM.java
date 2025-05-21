package Ventanas;

import ClasesDAO.Juego_de_mesaDAO;
import ClasesModelo.Juego_de_mesa;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import javax.swing.JScrollPane;

public class VenJDM extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JTextArea textArea;
    private JScrollPane scrollPane; // Añadimos esta variable como campo de la clase

    public VenJDM() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 870, 580);
        
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        JMenu mnMenuJDM = new JMenu("Generos");
        menuBar.add(mnMenuJDM);
        
        JMenuItem mntmRol = new JMenuItem("Rol");
        mntmRol.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    List<Juego_de_mesa> juegos = Juego_de_mesaDAO.buscarJuegosPorGenero("Rol");
                    mostrarJuegos(juegos);
                } catch (SQLException ex) {
                    textArea.setText("Error al buscar juegos: " + ex.getMessage());
                }
            }
        });
        mnMenuJDM.add(mntmRol);
        
        JMenuItem mntmCooperativo = new JMenuItem("Cooperativo");
        mntmCooperativo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    List<Juego_de_mesa> juegos = Juego_de_mesaDAO.buscarJuegosPorGenero("Cooperativo");
                    mostrarJuegos(juegos);
                } catch (SQLException ex) {
                    textArea.setText("Error al buscar juegos: " + ex.getMessage());
                }
            }
        });
        mnMenuJDM.add(mntmCooperativo);
        
        JMenuItem mntmCompetitivo = new JMenuItem("Competitivo");
        mntmCompetitivo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    List<Juego_de_mesa> juegos = Juego_de_mesaDAO.buscarJuegosPorGenero("Competitivo");
                    mostrarJuegos(juegos);
                } catch (SQLException ex) {
                    textArea.setText("Error al buscar juegos: " + ex.getMessage());
                }
            }
        });
        mnMenuJDM.add(mntmCompetitivo);
        
        JMenuItem mntmEstrategia = new JMenuItem("Estrategia");
        mntmEstrategia.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    List<Juego_de_mesa> juegos = Juego_de_mesaDAO.buscarJuegosPorGenero("Estrategia");
                    mostrarJuegos(juegos);
                } catch (SQLException ex) {
                    textArea.setText("Error al buscar juegos: " + ex.getMessage());
                }
            }
        });
        mnMenuJDM.add(mntmEstrategia);
        
        JMenuItem mntmFamiliares = new JMenuItem("Familiares");
        mntmFamiliares.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    List<Juego_de_mesa> juegos = Juego_de_mesaDAO.buscarJuegosPorGenero("Familiares");
                    mostrarJuegos(juegos);
                } catch (SQLException ex) {
                    textArea.setText("Error al buscar juegos: " + ex.getMessage());
                }
            }
        });
        mnMenuJDM.add(mntmFamiliares);
        
        JMenuItem mntmMisterio = new JMenuItem("Misterio");
        mntmMisterio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    List<Juego_de_mesa> juegos = Juego_de_mesaDAO.buscarJuegosPorGenero("Misterio");
                    mostrarJuegos(juegos);
                } catch (SQLException ex) {
                    textArea.setText("Error al buscar juegos: " + ex.getMessage());
                }
            }
        });
        mnMenuJDM.add(mntmMisterio);
        
        JMenu mnPorJugadores = new JMenu("Numero de jugadores");
        menuBar.add(mnPorJugadores);
        
        JMenuItem mntmIndividual = new JMenuItem("Para 1 jugador");
        mntmIndividual.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    List<Juego_de_mesa> juegos = Juego_de_mesaDAO.buscarJuegosPorNumJugadores(1);
                    mostrarJuegos(juegos);
                } catch (SQLException ex) {
                    textArea.setText("Error al buscar juegos: " + ex.getMessage());
                }
            }
        });
        mnPorJugadores.add(mntmIndividual);
        
        JMenuItem mntmPara2 = new JMenuItem("Hasta 2 jugadores");
        mntmPara2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    List<Juego_de_mesa> juegos = Juego_de_mesaDAO.buscarJuegosPorNumJugadores(2);
                    mostrarJuegos(juegos);
                } catch (SQLException ex) {
                    textArea.setText("Error al buscar juegos: " + ex.getMessage());
                }
            }
        });
        mnPorJugadores.add(mntmPara2);
        
        JMenuItem mntmPara4 = new JMenuItem("Hasta 4 jugadores");
        mntmPara4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    List<Juego_de_mesa> juegos = Juego_de_mesaDAO.buscarJuegosPorNumJugadores(4);
                    mostrarJuegos(juegos);
                } catch (SQLException ex) {
                    textArea.setText("Error al buscar juegos: " + ex.getMessage());
                }
            }
        });
        mnPorJugadores.add(mntmPara4);
        
        JMenuItem mntmPara6 = new JMenuItem("Hasta 6 jugadores");
        mntmPara6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    List<Juego_de_mesa> juegos = Juego_de_mesaDAO.buscarJuegosPorNumJugadores(6);
                    mostrarJuegos(juegos);
                } catch (SQLException ex) {
                    textArea.setText("Error al buscar juegos: " + ex.getMessage());
                }
            }
        });
        mnPorJugadores.add(mntmPara6);
        
        JMenuItem mntmPara8 = new JMenuItem("Para 8 o más jugadores");
        mntmPara8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    List<Juego_de_mesa> juegos = Juego_de_mesaDAO.buscarJuegosPorNumJugadores(8);
                    mostrarJuegos(juegos);
                } catch (SQLException ex) {
                    textArea.setText("Error al buscar juegos: " + ex.getMessage());
                }
            }
        });
        mnPorJugadores.add(mntmPara8);

        contentPane = new JPanel();
        contentPane.setBackground(new Color(199, 169, 139));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFocusable(true);
        textArea.setEnabled(true);
        
        scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(10, 11, 462, 497);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        contentPane.add(scrollPane);
        
        textField = new JTextField();
        textField.setBounds(559, 13, 279, 31);
        contentPane.add(textField);
        textField.setColumns(10);
        
        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    List<Juego_de_mesa> juegos = Collections.singletonList(Juego_de_mesaDAO.obtenerJuegoPorNombre(textField.getText()));
                    mostrarJuegos(juegos);
                } catch (SQLException ex) {
                    textArea.setText("Error al buscar juegos: " + ex.getMessage());
                }
            }
        });
        btnBuscar.setBounds(569, 57, 259, 31);
        contentPane.add(btnBuscar);
        
        JButton btnRestablecer = new JButton("Restablecer");
        btnRestablecer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    List<Juego_de_mesa> juegos = Juego_de_mesaDAO.obtenerTodosLosJuegos();
                    mostrarJuegos(juegos);
                } catch (SQLException ex) {
                    textArea.setText("Error al buscar juegos: " + ex.getMessage());
                }
            }
        });
        btnRestablecer.setBounds(569, 99, 259, 31);
        contentPane.add(btnRestablecer);

        JButton btnMasVendidos = new JButton("Top 10 Ventas");
        btnMasVendidos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    List<Juego_de_mesa> juegos = Juego_de_mesaDAO.masVendidos();
                    mostrarJuegos(juegos);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        btnMasVendidos.setBounds(569, 141, 259, 31);
        contentPane.add(btnMasVendidos);
        
        // Boton para añadir al carro de compra
        JButton btnAgregarCarrito = new JButton("Agregar al Carrito");
        btnAgregarCarrito.setBounds(569, 183, 259, 31);
        contentPane.add(btnAgregarCarrito);

        btnAgregarCarrito.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String seleccion = textArea.getSelectedText();
                if (seleccion != null && !seleccion.trim().isEmpty()) {
                    VenMenu.agregarAlCarrito(seleccion);
                } else {
                    // Mostrar mensaje de que debe seleccionar un producto
                    textArea.setText("Por favor, seleccione un producto para agregar al carrito");
                }
            }
        });
        
        JButton btnVolver = new JButton("Volver");
        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                VenMenu v1 = new VenMenu();
                v1.setVisible(true);
                dispose();
            }
        });
        btnVolver.setBounds(569, 477, 259, 31);
        contentPane.add(btnVolver);

        // Mostrar todos los juegos al iniciar
        try {
            List<Juego_de_mesa> juegos = Juego_de_mesaDAO.obtenerTodosLosJuegos();
            mostrarJuegos(juegos);
        } catch (SQLException ex) {
            textArea.setText("Error al cargar los juegos: " + ex.getMessage());
        }
    }
    
    private void mostrarJuegos(List<Juego_de_mesa> juegos) {
        StringBuilder sb = new StringBuilder();
        if (juegos == null || juegos.isEmpty()) {
            sb.append("No se encontraron juegos.");
        } else {
            for (Juego_de_mesa juego : juegos) {
                if (juego != null) {
                    sb.append("Nombre: ").append(juego.getNombre()).append("\n");
                    sb.append("Precio: ").append(juego.getPrecio()).append("€\n");
                    sb.append("Genero: ").append(juego.getGenero()).append("\n");
                    sb.append("Numero de Jugadores: ").append(juego.getNumeroJugadores()).append("\n");
                    sb.append("------------------\n");
                }
            }
        }
        textArea.setText(sb.toString());
        textArea.setCaretPosition(0);
    }
}
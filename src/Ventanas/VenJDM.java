package Ventanas;

import ClasesDAO.jdmDAO;
import ClasesModelo.jdm;

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

/**
 * Ventana que permite a los usuarios explorar y buscar Juegos de Mesa (JDM)
 * por género, número de jugadores, nombre y ver los más vendidos.
 */
public class VenJDM extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JTextArea textArea;
    private JScrollPane scrollPane;

    /**
     * Constructor de la ventana de Juegos de Mesa. Inicializa la interfaz gráfica
     * con menús para filtrar por género y número de jugadores, un campo de texto
     * para buscar por nombre y botones para restablecer la lista y ver los más vendidos.
     */
    public VenJDM() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 870, 580);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        // Menú para filtrar juegos por género
        JMenu mnMenuJDM = new JMenu("Generos");
        menuBar.add(mnMenuJDM);

        JMenuItem mntmRol = new JMenuItem("Rol");
        mntmRol.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    List<jdm> juegos = jdmDAO.buscarJuegosPorGenero("Rol");
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
                    List<jdm> juegos = jdmDAO.buscarJuegosPorGenero("Cooperativo");
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
                    List<jdm> juegos = jdmDAO.buscarJuegosPorGenero("Competitivo");
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
                    List<jdm> juegos = jdmDAO.buscarJuegosPorGenero("Estrategia");
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
                    List<jdm> juegos = jdmDAO.buscarJuegosPorGenero("Familiares");
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
                    List<jdm> juegos = jdmDAO.buscarJuegosPorGenero("Misterio");
                    mostrarJuegos(juegos);
                } catch (SQLException ex) {
                    textArea.setText("Error al buscar juegos: " + ex.getMessage());
                }
            }
        });
        mnMenuJDM.add(mntmMisterio);

        // Menú para filtrar juegos por número de jugadores
        JMenu mnPorJugadores = new JMenu("Numero de jugadores");
        menuBar.add(mnPorJugadores);

        JMenuItem mntmIndividual = new JMenuItem("Para 1 jugador");
        mntmIndividual.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    List<jdm> juegos = jdmDAO.buscarJuegosPorNumJugadores(1);
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
                    List<jdm> juegos = jdmDAO.buscarJuegosPorNumJugadores(2);
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
                    List<jdm> juegos = jdmDAO.buscarJuegosPorNumJugadores(4);
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
                    List<jdm> juegos = jdmDAO.buscarJuegosPorNumJugadores(6);
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
                    List<jdm> juegos = jdmDAO.buscarJuegosPorNumJugadores(8);
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

        // Area de texto para mostrar la lista de juegos
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

        // Campo de texto para buscar juegos por nombre
        textField = new JTextField();
        textField.setBounds(559, 13, 279, 31);
        contentPane.add(textField);
        textField.setColumns(10);

        // Botón para buscar juegos por el nombre ingresado
        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    List<jdm> juegos = Collections.singletonList(jdmDAO.obtenerJuegoPorNombre(textField.getText()));
                    mostrarJuegos(juegos);
                } catch (SQLException ex) {
                    textArea.setText("Error al buscar juegos: " + ex.getMessage());
                }
            }
        });
        btnBuscar.setBounds(569, 57, 259, 31);
        contentPane.add(btnBuscar);

        // Botón para restablecer la lista y mostrar todos los juegos
        JButton btnRestablecer = new JButton("Restablecer");
        btnRestablecer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    List<jdm> juegos = jdmDAO.obtenerTodosLosJuegos();
                    mostrarJuegos(juegos);
                } catch (SQLException ex) {
                    textArea.setText("Error al buscar juegos: " + ex.getMessage());
                }
            }
        });
        btnRestablecer.setBounds(569, 99, 259, 31);
        contentPane.add(btnRestablecer);

        // Botón para mostrar los 10 juegos más vendidos
        JButton btnMasVendidos = new JButton("Top 10 Ventas");
        btnMasVendidos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    List<jdm> juegos = jdmDAO.masVendidos();
                    mostrarJuegos(juegos);
                } catch (SQLException ex) {
                    textArea.setText("Error al obtener los más vendidos: " + ex.getMessage());
                }
            }
        });
        btnMasVendidos.setBounds(569, 141, 259, 31);
        contentPane.add(btnMasVendidos);

        // Botón para volver al menú principal
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

        // Mostrar todos los juegos al iniciar la ventana
        try {
            List<jdm> juegos = jdmDAO.obtenerTodosLosJuegos();
            mostrarJuegos(juegos);
        } catch (SQLException ex) {
            textArea.setText("Error al cargar los juegos: " + ex.getMessage());
        }
    }

    /**
     * Formatea y muestra la lista de juegos de mesa en el área de texto.
     *
     * @param juegos La lista de objetos {@link jdm} a mostrar.
     */
    private void mostrarJuegos(List<jdm> juegos) {
        StringBuilder sb = new StringBuilder();
        if (juegos == null || juegos.isEmpty()) {
            sb.append("No se encontraron juegos.");
        } else {
            for (jdm juego : juegos) {
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
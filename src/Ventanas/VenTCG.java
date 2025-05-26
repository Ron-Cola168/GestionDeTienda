package Ventanas;

import ClasesDAO.TCGDAO;
import ClasesModelo.TCG;

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
import java.util.List;
import javax.swing.JScrollPane;

/**
 * Ventana que permite a los usuarios explorar y buscar Tarjetas Coleccionables (TCG)
 * por juego y tipo (sobres, cajas, mazos), así como ver las más vendidas.
 */
public class VenTCG extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JTextArea textArea;
    private JScrollPane scrollPane;

    /**
     * Constructor de la ventana de Tarjetas Coleccionables. Inicializa la interfaz gráfica
     * con menús para filtrar por juego y tipo de producto, y botones para restablecer
     * la lista y ver los más vendidos.
     */
    public VenTCG() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 870, 580);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        // Menú principal para seleccionar el juego de TCG
        JMenu mnMenuJDM = new JMenu("Juego");
        menuBar.add(mnMenuJDM);

        // Submenú para Magic: The Gathering
        JMenu mnMTG = new JMenu("Magic: The Gathering");
        mnMenuJDM.add(mnMTG);

        JMenuItem mntmSMTG = new JMenuItem("Sobres");
        mnMTG.add(mntmSMTG);

        JMenuItem mntmCMTG = new JMenuItem("Cajas");
        mnMTG.add(mntmCMTG);

        JMenuItem mntmMMTG = new JMenuItem("Mazos");
        mnMTG.add(mntmMMTG);

        // Submenú para Pokémon TCG
        JMenu mnPokemon = new JMenu("Pokémon");
        mnMenuJDM.add(mnPokemon);

        JMenuItem mntmSPKM = new JMenuItem("Sobres");
        mnPokemon.add(mntmSPKM);

        JMenuItem mntmCPKM = new JMenuItem("Cajas");
        mnPokemon.add(mntmCPKM);

        JMenuItem mntmMPKM = new JMenuItem("Mazos");
        mnPokemon.add(mntmMPKM);

        // Submenú para Yu-Gi-Oh!
        JMenu mnNewMenu = new JMenu("Yu-Gi-Oh!");
        mnMenuJDM.add(mnNewMenu);

        JMenuItem mntmSYGO = new JMenuItem("Sobres");
        mnNewMenu.add(mntmSYGO);

        JMenuItem mntmCYGO = new JMenuItem("Cajas");
        mnNewMenu.add(mntmCYGO);

        JMenuItem mntmMYGO = new JMenuItem("Mazos");
        mnNewMenu.add(mntmMYGO);

        // ActionListeners para los items del menú de Magic: The Gathering
        mntmSMTG.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    List<TCG> TCG = TCGDAO.buscarPorJuegoYTipo("MTG", "sobre");
                    mostrarJuegos(TCG);
                } catch (SQLException ex) {
                    textArea.setText("Error al buscar sobres de Magic: " + ex.getMessage());
                }
            }
        });

        mntmCMTG.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    List<TCG> TCG = TCGDAO.buscarPorJuegoYTipo("MTG", "caja");
                    mostrarJuegos(TCG);
                } catch (SQLException ex) {
                    textArea.setText("Error al buscar cajas de Magic: " + ex.getMessage());
                }
            }
        });

        mntmMMTG.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    List<TCG> TCG = TCGDAO.buscarPorJuegoYTipo("MTG", "mazo");
                    mostrarJuegos(TCG);
                } catch (SQLException ex) {
                    textArea.setText("Error al buscar mazos de Magic: " + ex.getMessage());
                }
            }
        });

        // ActionListeners para los items del menú de Pokémon TCG
        mntmSPKM.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    List<TCG> TCG = TCGDAO.buscarPorJuegoYTipo("Pokemon TCG", "sobre");
                    mostrarJuegos(TCG);
                } catch (SQLException ex) {
                    textArea.setText("Error al buscar sobres de Pokemon: " + ex.getMessage());
                }
            }
        });

        mntmCPKM.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    List<TCG> TCG = TCGDAO.buscarPorJuegoYTipo("Pokemon TCG", "caja");
                    mostrarJuegos(TCG);
                } catch (SQLException ex) {
                    textArea.setText("Error al buscar cajas de Pokemon: " + ex.getMessage());
                }
            }
        });

        mntmMPKM.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    List<TCG> TCG = TCGDAO.buscarPorJuegoYTipo("Pokemon TCG", "mazo");
                    mostrarJuegos(TCG);
                } catch (SQLException ex) {
                    textArea.setText("Error al buscar mazos de Pokemon: " + ex.getMessage());
                }
            }
        });

        // ActionListeners para los items del menú de Yu-Gi-Oh!
        mntmSYGO.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    List<TCG> TCG = TCGDAO.buscarPorJuegoYTipo("Yu-Gi-Oh!", "sobre");
                    mostrarJuegos(TCG);
                } catch (SQLException ex) {
                    textArea.setText("Error al buscar sobres de Yu-Gi-Oh!: " + ex.getMessage());
                }
            }
        });

        mntmCYGO.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    List<TCG> TCG = TCGDAO.buscarPorJuegoYTipo("Yu-Gi-Oh!", "caja");
                    mostrarJuegos(TCG);
                } catch (SQLException ex) {
                    textArea.setText("Error al buscar cajas de Yu-Gi-Oh!: " + ex.getMessage());
                }
            }
        });

        mntmMYGO.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    List<TCG> TCG = TCGDAO.buscarPorJuegoYTipo("Yu-Gi-Oh!", "mazo");
                    mostrarJuegos(TCG);
                } catch (SQLException ex) {
                    textArea.setText("Error al buscar mazos de Yu-Gi-Oh!: " + ex.getMessage());
                }
            }
        });

        contentPane = new JPanel();
        contentPane.setBackground(new Color(199, 169, 139));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Área de texto para mostrar la lista de tarjetas TCG
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

        // Botón para restablecer la lista y mostrar todas las tarjetas TCG
        JButton btnRestablecer = new JButton("Restablecer");
        btnRestablecer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    List<TCG> TCG = TCGDAO.obtenerTCGS();
                    mostrarJuegos(TCG);
                } catch (SQLException ex) {
                    textArea.setText("Error al buscar juegos: " + ex.getMessage());
                }
            }
        });
        btnRestablecer.setBounds(569, 99, 259, 31);
        contentPane.add(btnRestablecer);

        // Botón para mostrar las 10 tarjetas TCG más vendidas
        JButton btnMasVendidos = new JButton("Top 10 Ventas");
        btnMasVendidos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    List<TCG> TCG = TCGDAO.masVendidos();
                    mostrarJuegos(TCG);
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

        // Mostrar todas las tarjetas TCG al iniciar la ventana
        try {
            List<TCG> Cartas = TCGDAO.obtenerTCGS();
            mostrarJuegos(Cartas);
        } catch (SQLException ex) {
            textArea.setText("Error al cargar los juegos: " + ex.getMessage());
        }
    }

    /**
     * Formatea y muestra la lista de tarjetas coleccionables en el área de texto.
     *
     * @param juegos La lista de objetos {@link TCG} a mostrar.
     */
    private void mostrarJuegos(List<TCG> juegos) {
        StringBuilder sb = new StringBuilder();
        if (juegos == null || juegos.isEmpty()) {
            sb.append("No se encontraron juegos.");
        } else {
            for (TCG juego : juegos) {
                if (juego != null) {
                    sb.append("Nombre: ").append(juego.getNombre()).append("\n");
                    sb.append("Precio: ").append(juego.getPrecio()).append("€\n");
                    sb.append("Tipo: ").append(juego.getTipo()).append("\n");
                    sb.append("Juego: ").append(juego.getJuego()).append("\n");
                    sb.append("------------------\n");
                }
            }
        }
        textArea.setText(sb.toString());
        textArea.setCaretPosition(0);
    }
}
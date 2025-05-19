package Ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import java.awt.Dimension;
// Primero añadimos los imports necesarios
import javax.swing.JTextField;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.Box;
import javax.swing.JSeparator;

public class VenJDG extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;


	public VenJDG() {
    // Mantenemos todo el código existente hasta donde se crea el textArea
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 870, 580);
    
    // Mantenemos el menú y su configuración...
    JMenuBar menuBar = new JMenuBar();
    setJMenuBar(menuBar);
    
    JMenu mnMenuJDM = new JMenu("Generos");
    menuBar.add(mnMenuJDM);
    
    JMenuItem mntmRol = new JMenuItem("Rol");
    mntmRol.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            
        }
    });
    mnMenuJDM.add(mntmRol);
    
    JMenuItem mntmCooperativo = new JMenuItem("Cooperativo");
    mnMenuJDM.add(mntmCooperativo);
    
    JMenuItem mntmCompetitivo = new JMenuItem("Competitivo");
    mnMenuJDM.add(mntmCompetitivo);
    
    JMenuItem mntmC = new JMenuItem("Estrategia");
    mnMenuJDM.add(mntmC);
    
    JMenuItem mntmNewMenuItem_4 = new JMenuItem("Famialiares");
    mnMenuJDM.add(mntmNewMenuItem_4);
    
    JMenuItem mntmNewMenuItem = new JMenuItem("Misterio");
    mnMenuJDM.add(mntmNewMenuItem);
    
    JMenu mnPorJugadores = new JMenu("Numero de jugadores");
    menuBar.add(mnPorJugadores);
    
    JMenuItem mntmIndividual = new JMenuItem("Para 1 jugador");
    mnPorJugadores.add(mntmIndividual);
    
    JMenuItem mntmPara2 = new JMenuItem("Hasta 2 jugadores");
    mnPorJugadores.add(mntmPara2);
    
    JMenuItem mntmPara4 = new JMenuItem("Hasta 4 jugadores");
    mnPorJugadores.add(mntmPara4);
    
    JMenuItem mntmPara6 = new JMenuItem("Hasta 6 jugadores");
    mnPorJugadores.add(mntmPara6);
    
    JMenuItem mntmPara8 = new JMenuItem("Para 8 o más jugadores");
    mnPorJugadores.add(mntmPara8);

    contentPane = new JPanel();
    contentPane.setBackground(new Color(199, 169, 139));
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);
    
    JTextArea textArea = new JTextArea();
    textArea.setBounds(10, 11, 462, 497);
    contentPane.add(textArea);
    
    textField = new JTextField();
    textField.setBounds(559, 13, 279, 31);
    contentPane.add(textField);
    textField.setColumns(10);
    
    JButton btnBuscar = new JButton("Buscar");
    btnBuscar.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    	}
    });
    btnBuscar.setBounds(569, 57, 259, 31);
    contentPane.add(btnBuscar);
    
    JButton btnRestablecer = new JButton("Restablecer");
    btnRestablecer.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    	}
    });
    btnRestablecer.setBounds(569, 99, 259, 31);
    contentPane.add(btnRestablecer);
    
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

    
}
}
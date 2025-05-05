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

public class VenJDG extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public VenJDG() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 870, 580);
		
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
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JTextArea textArea = new JTextArea();
		contentPane.add(textArea, BorderLayout.CENTER);
	}

}

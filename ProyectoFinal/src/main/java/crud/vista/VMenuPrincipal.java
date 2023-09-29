package crud.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;

import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

public class VMenuPrincipal extends JFrame {
	public JMenuBar menuBar;
	public JMenu archivo;
	public JMenuItem salir;
	public JMenu menu;
	public JMenuItem des;
	public JMenuItem vid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VMenuPrincipal frame = new VMenuPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VMenuPrincipal() {
		setTitle("Desarrolladores y Videojuegos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 482, 191);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		archivo = new JMenu("    Archivo           ");
		archivo.setHorizontalAlignment(SwingConstants.CENTER);
		archivo.setForeground(Color.BLACK);
		archivo.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		menuBar.add(archivo);
		
		salir = new JMenuItem("Salir   ");
		salir.setFont(new Font("Times New Roman", Font.BOLD, 25));
		salir.setHorizontalAlignment(SwingConstants.CENTER);
		archivo.add(salir);
		
		menu = new JMenu("           Menu        ");
		menu.setHorizontalAlignment(SwingConstants.CENTER);
		menu.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		menu.setForeground(Color.BLACK);
		menuBar.add(menu);
		
		des = new JMenuItem("Desarrolladores");
		des.setHorizontalAlignment(SwingConstants.CENTER);
		des.setFont(new Font("Times New Roman", Font.BOLD, 25));
		menu.add(des);
		
		vid = new JMenuItem("Videojuegos");
		vid.setHorizontalAlignment(SwingConstants.CENTER);
		vid.setFont(new Font("Times New Roman", Font.BOLD, 25));
		menu.add(vid);
	}

}

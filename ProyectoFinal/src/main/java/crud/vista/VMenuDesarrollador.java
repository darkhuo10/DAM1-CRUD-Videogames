package crud.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JToolBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class VMenuDesarrollador extends JFrame {

	private JPanel panelGenereal;
	private JToolBar botones;
	public JButton alta;
	public JButton baja;
	public JButton consulta;
	public JButton modifica;
	public JButton juegos;
	private JPanel panelCR;
	public JTextField idTxt;
	public JTextField nombreTxt;
	public JTextField paisTxt;
	public JTextField webTxt;
	private JPanel panelC;
	public JPanel panelR;
	private JLabel id;
	private JLabel nombre;
	private JLabel pais;
	private JLabel web;
	public JTextPane textoR;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VMenuDesarrollador frame = new VMenuDesarrollador();
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
	public VMenuDesarrollador() {
		setFont(new Font("Dialog", Font.PLAIN, 11));
		setTitle("Desarrolladores");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 602, 372);
		panelGenereal = new JPanel();
		panelGenereal.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelGenereal.setLayout(new BorderLayout(0, 0));
		setContentPane(panelGenereal);

		botones = new JToolBar();
		panelGenereal.add(botones, BorderLayout.SOUTH);

		alta = new JButton("    Alta    ");
		alta.setFont(new Font("Times New Roman", Font.BOLD, 20));
		botones.add(alta);

		baja = new JButton("    Baja    ");
		baja.setFont(new Font("Times New Roman", Font.BOLD, 20));
		botones.add(baja);

		modifica = new JButton("    Modifica    ");
		modifica.setFont(new Font("Times New Roman", Font.BOLD, 20));
		botones.add(modifica);

		consulta = new JButton("    Consulta    ");
		consulta.setFont(new Font("Times New Roman", Font.BOLD, 20));
		botones.add(consulta);

		juegos = new JButton("    Juegos    ");
		juegos.setFont(new Font("Times New Roman", Font.BOLD, 20));
		botones.add(juegos);
		
		panelCR = new JPanel();
		panelCR.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelGenereal.add(panelCR, BorderLayout.CENTER);
		panelCR.setLayout(null);

		panelC = new JPanel();
		panelC.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelC.setBounds(8, 8, 258, 274);
		panelCR.add(panelC);
		panelC.setLayout(null);

		id = new JLabel("Id:");
		id.setFont(new Font("Times New Roman", Font.BOLD, 20));
		id.setHorizontalAlignment(SwingConstants.LEFT);
		id.setBounds(8, 19, 33, 29);
		panelC.add(id);

		nombre = new JLabel("Nombre: ");
		nombre.setFont(new Font("Times New Roman", Font.BOLD, 20));
		nombre.setHorizontalAlignment(SwingConstants.LEFT);
		nombre.setBounds(8, 56, 242, 29);
		panelC.add(nombre);

		pais = new JLabel("Pa\u00EDs:");
		pais.setFont(new Font("Times New Roman", Font.BOLD, 20));
		pais.setBounds(8, 130, 242, 24);
		panelC.add(pais);

		web = new JLabel("Web:");
		web.setFont(new Font("Times New Roman", Font.BOLD, 20));
		web.setBounds(8, 198, 242, 24);
		panelC.add(web);

		idTxt = new JTextField();
		idTxt.setBounds(49, 19, 201, 29);
		panelC.add(idTxt);
		idTxt.setColumns(10);

		nombreTxt = new JTextField();
		nombreTxt.setBounds(8, 93, 242, 29);
		panelC.add(nombreTxt);
		nombreTxt.setColumns(10);

		paisTxt = new JTextField();
		paisTxt.setBounds(8, 161, 242, 29);
		panelC.add(paisTxt);
		paisTxt.setColumns(10);

		webTxt = new JTextField();
		webTxt.setBounds(8, 230, 242, 29);
		panelC.add(webTxt);
		webTxt.setColumns(10);

		panelR = new JPanel();
		panelR.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelR.setBounds(274, 8, 296, 274);
		panelCR.add(panelR);
		panelR.setLayout(null);
		
		textoR = new JTextPane();
		textoR.setFont(new Font("Times New Roman", Font.BOLD, 15));
		textoR.setBounds(8, 8, 280, 258);
		panelR.add(textoR);
	}
}

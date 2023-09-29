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


public class VMenuVideojuego extends JFrame {

	public JPanel panelGenereal;
	public JToolBar botones;
	public JButton alta;
	public JButton baja;
	public JButton consulta;
	public JButton modifica;
	public JPanel panelCR;
	public JTextField idTxt;
	public JTextField desarrolladorTxt;
	public JTextField nombreTxt;
	public JTextField precioTxt;
	public JPanel panelC;
	public JPanel panelR;
	public JLabel id;
	public JLabel idDes;
	public JLabel nombre;
	public JLabel precio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VMenuVideojuego frame = new VMenuVideojuego();
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
	public VMenuVideojuego() {
		setFont(new Font("Dialog", Font.PLAIN, 11));
		setTitle("Videojuegos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 602, 372);
		panelGenereal = new JPanel();
		panelGenereal.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelGenereal.setLayout(new BorderLayout(0, 0));
		setContentPane(panelGenereal);
		
		botones = new JToolBar();
		panelGenereal.add(botones, BorderLayout.SOUTH);
		
		alta = new JButton("       Alta       ");
		alta.setFont(new Font("Times New Roman", Font.BOLD, 20));
		botones.add(alta);
		
		baja = new JButton("       Baja       ");
		baja.setFont(new Font("Times New Roman", Font.BOLD, 20));
		botones.add(baja);
		
		modifica = new JButton("      Modifica      ");
		modifica.setFont(new Font("Times New Roman", Font.BOLD, 20));
		botones.add(modifica);
		
		consulta = new JButton("      Consulta      ");
		consulta.setFont(new Font("Times New Roman", Font.BOLD, 20));
		botones.add(consulta);
		
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
		
		idDes = new JLabel("Id desarrollador:");
		idDes.setFont(new Font("Times New Roman", Font.BOLD, 20));
		idDes.setHorizontalAlignment(SwingConstants.LEFT);
		idDes.setBounds(8, 56, 242, 29);
		panelC.add(idDes);
		
		nombre = new JLabel("Nombre:");
		nombre.setFont(new Font("Times New Roman", Font.BOLD, 20));
		nombre.setBounds(8, 130, 242, 24);
		panelC.add(nombre);
		
		precio = new JLabel("Precio:");
		precio.setFont(new Font("Times New Roman", Font.BOLD, 20));
		precio.setBounds(8, 198, 242, 24);
		panelC.add(precio);
		
		idTxt = new JTextField();
		idTxt.setBounds(49, 19, 201, 29);
		panelC.add(idTxt);
		idTxt.setColumns(10);
		
		desarrolladorTxt = new JTextField();
		desarrolladorTxt.setBounds(8, 93, 242, 29);
		panelC.add(desarrolladorTxt);
		desarrolladorTxt.setColumns(10);
		
		nombreTxt = new JTextField();
		nombreTxt.setBounds(8, 161, 242, 29);
		panelC.add(nombreTxt);
		nombreTxt.setColumns(10);
		
		precioTxt = new JTextField();
		precioTxt.setBounds(8, 230, 242, 29);
		panelC.add(precioTxt);
		precioTxt.setColumns(10);
		
		panelR = new JPanel();
		panelR.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelR.setBounds(274, 8, 296, 274);
		panelCR.add(panelR);
	}
}

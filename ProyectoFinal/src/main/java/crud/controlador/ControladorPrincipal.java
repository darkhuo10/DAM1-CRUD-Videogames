package crud.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import crud.modelo.DAODesarrollador;
import crud.modelo.DAOVideojuego;
import crud.vista.VMenuDesarrollador;
import crud.vista.VMenuPrincipal;
import crud.vista.VMenuVideojuego;

public class ControladorPrincipal {
	private VMenuPrincipal vista;
	private DAODesarrollador modeloA;
	private DAOVideojuego modeloB;

	public ControladorPrincipal(VMenuPrincipal vista, DAODesarrollador daoD, DAOVideojuego daoV) {
		super();
		this.vista = vista;
		this.modeloA = daoD;
		this.modeloB = daoV;
		setListeners();
		vista.setVisible(true);
	}

	private void setListeners() {
		vista.salir.addActionListener(new SActionListener());
		vista.des.addActionListener(new DActionListener());
		vista.vid.addActionListener(new VActionListener());
	}

	private class SActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
	private class DActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {					
			VMenuDesarrollador vd = new VMenuDesarrollador();
			vd.setVisible(true); 
			DAODesarrollador dd;
			try {
				dd = new  DAODesarrollador();
				ControladorDesarrollador cd = new ControladorDesarrollador(vd, dd);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	}
	private class VActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			VMenuVideojuego vv = new VMenuVideojuego();
			vv.setVisible(true); 
			DAOVideojuego dv;
			try {
				dv = new  DAOVideojuego();
				ControladorVideojuego cv = new ControladorVideojuego(vv, dv);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

}

package crud.tests;

import java.sql.SQLException;

import crud.controlador.ControladorDesarrollador;
import crud.controlador.ControladorPrincipal;
import crud.controlador.ControladorVideojuego;
import crud.modelo.DAODesarrollador;
import crud.modelo.DAOVideojuego;
import crud.vista.VMenuDesarrollador;
import crud.vista.VMenuPrincipal;
import crud.vista.VMenuVideojuego;

public class Test {
	public static void main(String[] args) throws SQLException {

		DAOVideojuego vDAO = new DAOVideojuego();
		DAODesarrollador dDAO = new DAODesarrollador();
		System.out.println(vDAO.readAll());
		System.out.println(dDAO.readJuegos(1));
		ControladorPrincipal cp= new ControladorPrincipal(new VMenuPrincipal(), new DAODesarrollador(), new DAOVideojuego());
		ControladorDesarrollador cd = new ControladorDesarrollador(new VMenuDesarrollador(), new DAODesarrollador());
		ControladorVideojuego cv = new ControladorVideojuego(new VMenuVideojuego(), new DAOVideojuego());
	}

}

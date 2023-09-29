package crud.main;

import java.sql.SQLException;

import crud.controlador.ControladorPrincipal;
import crud.modelo.DAODesarrollador;
import crud.modelo.DAOVideojuego;
import crud.vista.VMenuPrincipal;

public class Main {
	public static void main(String[] args) throws SQLException {
		ControladorPrincipal cp= new ControladorPrincipal(new VMenuPrincipal(), new DAODesarrollador(), new DAOVideojuego());
	}
}

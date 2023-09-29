package crud.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBC {
	private static Connection conn;

	private static final String url = "jdbc:sqlite:";
	private static final String bd = "videojuegos.sqlite";

	private DBC() throws SQLException {
		conn = DriverManager.getConnection(url + bd);
	}

	public static Connection getConexion() throws SQLException {
		if (conn == null)
			new DBC();
		return conn;
	}

	public static void cierra() {
		try {
			if (conn != null)
				conn.close();
			conn = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

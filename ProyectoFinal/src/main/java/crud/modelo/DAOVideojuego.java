package crud.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAOVideojuego implements DAO<DTOVideojuego, Integer> {

	private Connection c;

	public DAOVideojuego() throws SQLException {
		c = DBC.getConexion();
	}

	public void createTable() throws SQLException {
		try (Statement st = c.createStatement();) {
			String create = "create table if not exists videojuegos (" 
					+ "id_juego integer primary key,"
					+ "id_desarrollador integer," 
					+ "nombre_juego varchar(50)," 
					+ "precio_juego double(3,2));";
			st.executeUpdate(create);
		}
	}

	public DTOVideojuego create(ResultSet rs) throws SQLException {
		return new DTOVideojuego(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDouble(4));
	}

	public boolean insert(DTOVideojuego v) throws SQLException {
		String insert = "insert into videojuegos values(?, ?, ?, ?)";
		PreparedStatement st = c.prepareStatement(insert);
		st.setInt(1, v.getId());
		st.setInt(2, v.getIdDes());
		st.setString(3, v.getNombre());
		st.setDouble(4, v.getPrecio());

		int n = st.executeUpdate();
		st.close();
		return n > 0 ? true : false;
	}

	public boolean delete(Integer id) throws SQLException {
		String delete = "delete from videojuegos where id_juego = ?";
		PreparedStatement sentencia = c.prepareStatement(delete);
		sentencia.setInt(1, id);
		int n = sentencia.executeUpdate();
		sentencia.close();
		return n > 0 ? true : false;
	}

	public boolean update(DTOVideojuego d) throws SQLException {
		String update = "update videojuegos set id_desarrollador = ?," 
				+ "nombre_juego like '?', " 
				+ "precio_juego = ?"
				+ "where id_juego = ?";
		PreparedStatement st = c.prepareStatement(update);

		st.setInt(1, d.getIdDes());
		st.setString(2, d.getNombre());
		st.setDouble(3, d.getPrecio());
		st.setInt(4, d.getId());

		int n = st.executeUpdate();
		st.close();
		return n > 0 ? true : false;
	}

	public DTOVideojuego read(Integer id) throws SQLException {
		String read = "select * from videojuegos where id_juego = ?";
		DTOVideojuego v = null;
		try (PreparedStatement st = c.prepareStatement(read);) {
			st.setInt(1, id);
			try (ResultSet rs = st.executeQuery()) {
				v = create(rs);
			}
		}
		return v;
	}

	public List<DTOVideojuego> readAll() throws SQLException {
		String readAll = "select * from videojuegos";
		List<DTOVideojuego> lista = null;
		try (PreparedStatement st = c.prepareStatement(readAll);
				ResultSet rs = st.executeQuery();) {
			lista = new ArrayList<>();
			while (rs.next())
				lista.add(create(rs));
		}
		return lista;
	}

}

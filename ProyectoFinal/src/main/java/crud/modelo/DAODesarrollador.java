package crud.modelo;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAODesarrollador implements DAO<DTODesarrollador, Integer> {

	private Connection c;

	public DAODesarrollador() throws SQLException {
		c = DBC.getConexion();
	}	

	public void createTable() throws SQLException {
		try (Statement st = c.createStatement();) {
			String create = "create table if not exists desarrolladores ("
					+ "id_desarrollador integer primary key," 
					+ "nombre_desarrollador varchar(50),"
					+ "pais_desarrollador varchar(30)," 
					+ "web_desarrollador varchar);";
			st.executeUpdate(create);
		}
	}

	public DTODesarrollador create(ResultSet rs) throws SQLException {
		return new DTODesarrollador(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
	}

	public boolean insert(DTODesarrollador d) throws SQLException {
		String insert = "insert into desarrolladores values(?, ?, ?, ?)";
		PreparedStatement st = c.prepareStatement(insert);
		st.setInt(1, d.getId());
		st.setString(2, d.getNombre());
		st.setString(3, d.getPais());
		st.setString(4, d.getWeb());

		int n = st.executeUpdate();
		st.close();
		return n > 0 ? true : false;
	}

	public boolean delete(Integer id) throws SQLException {
		String delete = "delete from desarrolladores where id_desarrollador = ?";
		PreparedStatement sentencia = c.prepareStatement(delete);
		sentencia.setInt(1, id);
		int n = sentencia.executeUpdate();
		sentencia.close();
		return n > 0 ? true : false;
	}

	public boolean update(DTODesarrollador d) throws SQLException {
		String update = "update desarrolladores set nombre_desarrollador like '?', " 
				+ "pais_desarrollador like '?', "
				+ "web_desarrollador like '?' " 
				+ "where id_desarrollador = ?";
		PreparedStatement st = c.prepareStatement(update);

		st.setString(1, d.getNombre());
		st.setString(2, d.getPais());
		st.setString(3, d.getWeb());
		st.setInt(4, d.getId());

		int n = st.executeUpdate();
		st.close();
		return n > 0 ? true : false;
	}

	public DTODesarrollador read(Integer id) throws SQLException {
		String read = "select * from desarrolladores where id_desarrollador = ?";
		DTODesarrollador des = null;
		try (PreparedStatement st = c.prepareStatement(read);) {
			st.setInt(1, id);
			try (ResultSet rs = st.executeQuery()) {
					des = create(rs);
			}
		}
		return des;
	}

	public List<DTODesarrollador> readAll() throws SQLException {
		String readAll = "select * from desarrolladores";
		List<DTODesarrollador> lista = null;
		try (PreparedStatement st = c.prepareStatement(readAll);) {
			try (ResultSet rs = st.executeQuery()) {
				lista = new ArrayList<>();
				while (rs.next())
					lista.add(create(rs));
			}
		}
		return lista;
	}
	
	public List<DTOVideojuego> readJuegos(Integer idD) throws SQLException {
		String readAll = "select * from videojuegos where id_desarrollador = ?";
		List<DTOVideojuego> lista = null;
		try (PreparedStatement st = c.prepareStatement(readAll);) {
			st.setInt(1, idD);
			DAOVideojuego dv = new DAOVideojuego();
			try (ResultSet rs = st.executeQuery()) {
				lista = new ArrayList<>();
				while (rs.next())
					lista.add(dv.create(rs));
			}
		}
		return lista;
	}

}

package crud.modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface DAO <T, K>{
	void createTable() throws SQLException;
	T create(ResultSet rs) throws SQLException; //crea un dto a partir de un resultSet
	boolean insert(T a) throws SQLException;
	boolean delete(K id) throws SQLException;
	boolean update(T a) throws SQLException;
	T read(K id) throws SQLException;
	List<T>readAll() throws SQLException;
}

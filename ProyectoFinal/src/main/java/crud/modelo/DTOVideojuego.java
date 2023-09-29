package crud.modelo;

public class DTOVideojuego implements Comparable<DTOVideojuego> {
	private Integer id;
	private Integer idDes;
	private String nombre;
	private double precio;

	public DTOVideojuego(Integer id, Integer idDes, String nombre, double precio) {
		super();
		this.id = id;
		this.idDes = idDes;
		this.nombre = nombre;
		this.precio = precio;
	}

	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getIdDes() {
		return idDes;
	}

	public void setIdDes(Integer idDes) {
		this.idDes = idDes;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return String.format("Videojuego: [Id: %s, IdDes: %s, Nombre: %s, Precio: %s]", id, idDes, nombre, precio);
	}

	public int compareTo(DTOVideojuego v) {
		int r = this.getNombre().compareTo(v.getNombre());
		if (r != 0)
			r = this.getId() - v.getId();
		return 0;
	}

}

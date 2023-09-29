package crud.modelo;

public class DTODesarrollador implements Comparable<DTODesarrollador> {
	private Integer id;
	private String nombre;
	private String pais;
	private String web;

	public DTODesarrollador(Integer id, String nombre, String pais, String web) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.pais = pais;
		this.web = web;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getWeb() {
		return web;
	}

	public void setWebDes(String web) {
		this.web = web;
	}

	@Override
	public String toString() {
		return String.format("Desarrollador: [Id: %s, Nombre: %s, País: %s, Web: %s", id, nombre, pais, web);
	}

	public int compareTo(DTODesarrollador d) {
		int r = this.getNombre().compareTo(d.getNombre());
		if (r != 0)
			r = this.getId().compareTo(d.getId());
		return r;
	}
}

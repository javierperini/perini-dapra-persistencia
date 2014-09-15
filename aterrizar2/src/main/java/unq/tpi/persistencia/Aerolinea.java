package unq.tpi.persistencia;

import java.util.List;

public class Aerolinea {
	private String nombre;
	private List<Vuelo> unosVuelos;
	private Integer id;

	/**
	 * Es exclusivo para Hibernate no usar 
	 **/
	protected Aerolinea() {
	}
	
	public Aerolinea(String nombre, List<Vuelo> unosVuelos){
		this.nombre = nombre;
		this.setUnosVuelos(unosVuelos);
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

	public List<Vuelo> getUnosVuelos() {
		return unosVuelos;
	}

	public void setUnosVuelos(List<Vuelo> unosVuelos) {
		this.unosVuelos = unosVuelos;
	}

	@Override
	public String toString() {
		return "Aerolinea [nombre=" + nombre + ", id=" + id + "]";
	}
}

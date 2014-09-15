package unq.tpi.persistencia;

import java.util.List;

public class Empresa {
	private String nombre;
	private List<Aerolinea> unasAerolineas;
	private Integer id;

	/**
	 * Es exclusivo para Hibernate no usar 
	 **/
	protected Empresa() {
	}
	
	public Empresa(String nombre, List<Aerolinea> unasAerolineas){
		this.nombre = nombre;
		this.setUnasAerolineas(unasAerolineas);
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

	public List<Aerolinea> getUnasAerolineas() {
		return unasAerolineas;
	}

	public void setUnasAerolineas(List<Aerolinea> unasAerolineas) {
		this.unasAerolineas = unasAerolineas;
	}

	@Override
	public String toString() {
		return "Empresa [nombre=" + nombre + ", id=" + id + "]";
	}
	
}

package unq.tpi.persistencia;

import java.util.List;

public class Vuelo extends Entidad {
	private String nombre;
	private List<Tramo> unosTramos;
	

	/**
	 * Es exclusivo para Hibernate no usar 
	 **/
	protected Vuelo() {
	}
	
	public Vuelo(String nombre, List<Tramo> unosTramos){
		this.nombre = nombre;
		this.setUnosTramos(unosTramos);
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Tramo> getUnosTramos() {
		return this.unosTramos;
	}

	public void setUnosTramos(List<Tramo> unosTramos) {
		this.unosTramos = unosTramos;
	}

	@Override
	public String toString() {
		return "Aerolinea [nombre=" + nombre + ", id=" + id + "]";
	}
}

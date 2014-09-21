package unq.tpi.persistencia;

import java.util.List;

public class Vuelo extends Entidad {
	private String nombre;
	private List<Tramo> unosTramos;
	private Aerolinea miAerolinea;

	protected Vuelo() {
	}
	
	public Vuelo(String nombre, Aerolinea miAerolinea){
		this.nombre = nombre;
		this.miAerolinea = miAerolinea;
	}
	
	public Vuelo(String nombre, Aerolinea miAerolinea ,List<Tramo> unosTramos){
		this.nombre = nombre;
		this.miAerolinea = miAerolinea;
		this.setUnosTramos(unosTramos);
	}
	
	public Aerolinea getMiAerolinea() {
		return miAerolinea;
	}

	public void setMiAerolinea(Aerolinea miAerolinea) {
		this.miAerolinea = miAerolinea;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void agregar(Tramo t) {
		this.unosTramos.add(t);
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

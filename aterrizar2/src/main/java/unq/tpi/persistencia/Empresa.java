package unq.tpi.persistencia;

import java.util.ArrayList;
import java.util.List;

public class Empresa extends Entidad {
	private String nombre;
	private List<Aerolinea> unasAerolineas = new ArrayList <Aerolinea>();
	
	protected Empresa() {
	}
	
	public Empresa(String nombre){
		this.nombre = nombre;
	}
	
	public Empresa(String nombre , List<Aerolinea> unasAerolineas){
		this(nombre);
		this.setUnasAerolineas(unasAerolineas);
	}

	public void agregarAerolinea(Aerolinea unaAerolinea){
		this.unasAerolineas.add(unaAerolinea);
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

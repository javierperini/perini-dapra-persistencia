package unq.tpi.persistencia;

import java.util.ArrayList;
import java.util.List;

public class Aerolinea extends Entidad{
	private String nombre;
	private List<Vuelo> unosVuelos = new ArrayList <Vuelo>();
	private Empresa empresaALaQuePertenece;

	
	protected Aerolinea() {
	}
	
	public Aerolinea(String nombre){
		this.nombre = nombre;
	}
	
	public Aerolinea(String nombre, Empresa empresaALaQuePertenece){
		this.nombre = nombre;
		this.empresaALaQuePertenece = empresaALaQuePertenece;
	}
	
	public Aerolinea(String nombre, Empresa empresaALaQuePertenece,List<Vuelo> unosVuelos){
		this.nombre = nombre;
		this.empresaALaQuePertenece = empresaALaQuePertenece;
		this.setUnosVuelos(unosVuelos);
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Empresa getEmpresaALaQuePertenece() {
		return empresaALaQuePertenece;
	}

	public void setEmpresaALaQuePertenece(Empresa empresaALaQuePertenece) {
		this.empresaALaQuePertenece = empresaALaQuePertenece;
	}
	
	public void agregarVuelo(Vuelo v){
		this.getUnosVuelos().add(v);
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

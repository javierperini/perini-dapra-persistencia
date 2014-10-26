package unq.tpi.persistencia.busquedas;

import java.util.ArrayList;
import java.util.List;

import exceptions.NoSePuedeEliminarCriterioDeBusquedaException;
import unq.tpi.persistencia.Aerolinea;
import unq.tpi.persistencia.Entidad;

public class Criterio extends Entidad {
	
	private String criterio;
	private List<Criterio> criteriosComplementarios = new ArrayList<Criterio>();

	private Criterio(String criterioDeBusqueda){
		this.criterio = criterioDeBusqueda;
	}
	
	public String getCriterio(){
		String criterios = this.criterio;
		for(Criterio c: this.criteriosComplementarios){
			criterios.concat(c.getCriterio());
		}
		return criterios;
	}
	
	// Metodos de manipulación de los criterios de búsqueda
	
	public void and(Criterio otroCriterio){
		otroCriterio.and();
		criteriosComplementarios.add(otroCriterio);
	}
	
	public void or(Criterio otroCriterio){
		otroCriterio.or();
		criteriosComplementarios.add(otroCriterio);
	}
	
	private void and(){
		this.criterio = " and ".concat(this.criterio);
	}
	
	private void or(){
		this.criterio = " or ".concat(this.criterio);
	}

	public void removeLast() throws NoSePuedeEliminarCriterioDeBusquedaException{
		try{
			criteriosComplementarios.remove(criteriosComplementarios.size() - 1);
		}
		catch (IndexOutOfBoundsException e) {
			throw new NoSePuedeEliminarCriterioDeBusquedaException();
		}
	}
	
	// Factory Methods para crear diferentes criterios de busqueda
	
	public static Criterio busquedaPorAerolinea(Aerolinea unaAerolinea){
		return new Criterio("aerolinea = ".concat(unaAerolinea.getNombre()));
	}
	
	public static Criterio busquedaPorCategoriaDeAsiento(Aerolinea unaAerolinea){
		return new Criterio("");
	}
	
	public static Criterio busquedaPorFechaDeSalida(String unaFechaDeSalida){
		return new Criterio("");
	}
	
	public static Criterio busquedaPorFechaDeLlegada(String unaFechaDeLlegada){
		return new Criterio("");
	}
	
	public static Criterio busquedaPorOrigen(String unOrigen){
		return new Criterio("");
	}
	
	public static Criterio busquedaPorDestino(String unDestino){
		return new Criterio("");
	}
}

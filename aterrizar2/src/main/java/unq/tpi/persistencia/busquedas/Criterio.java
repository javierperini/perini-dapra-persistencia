package unq.tpi.persistencia.busquedas;

import java.util.ArrayList;
import java.util.List;

import exceptions.NoSePuedeEliminarCriterioDeBusquedaException;
import unq.tpi.persistencia.Entidad;

public abstract class Criterio extends Entidad {
	
	private String criterio;
	protected List<Criterio> criteriosComplementarios = new ArrayList<Criterio>();

	public Criterio(){
		
	}
	
	public Criterio(String criterio){
		this.criterio = criterio;
	}
	
	public String getCriterio(){
		String criterios = this.criterio;
		for(Criterio c: this.criteriosComplementarios){
			criterios = criterios.concat(c.getCriterio());
		}
		return criterios;
	}
	
	// Metodos de manipulaci�n de los criterios
	
	public abstract void and(Criterio otroCriterio);
	
	public void removeLast() throws NoSePuedeEliminarCriterioDeBusquedaException{
		try{
			criteriosComplementarios.remove(criteriosComplementarios.size() - 1);
		}
		catch (IndexOutOfBoundsException e) {
			throw new NoSePuedeEliminarCriterioDeBusquedaException();
		}
	}

	public void setCriterio(String criterio) {
		this.criterio = criterio;
	}

	public List<Criterio> getCriteriosComplementarios() {
		return criteriosComplementarios;
	}

	public void setCriteriosComplementarios(List<Criterio> criteriosComplementarios) {
		this.criteriosComplementarios = criteriosComplementarios;
	}
	
	
	
	
//	
}

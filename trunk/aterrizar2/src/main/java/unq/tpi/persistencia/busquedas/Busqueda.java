package unq.tpi.persistencia.busquedas;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import exceptions.NoSePuedeEliminarCriterioDeBusquedaException;
import exceptions.PrimerCriterioDebeSerSinConectorException;
import exceptions.SoloPrimerCriterioDebeSerSinConectorException;
import unq.tpi.persistencia.Entidad;
import unq.tpi.persistencia.Vuelo;
import unq.tpi.persistencia.daos.SessionManager;

public class Busqueda extends Entidad {

	private Criterio criterioDeBusqueda;
	
	// Metodos de modificacion de los criterios de busqueda
	
	public void andCriterio(Criterio nuevoCriterio){
		criterioDeBusqueda.and(nuevoCriterio);
	}
	
	public void orCriterio(Criterio nuevoCriterio){
		criterioDeBusqueda.or(nuevoCriterio);
	}

	public void eliminarUltimoCriterio() throws NoSePuedeEliminarCriterioDeBusquedaException{
		criterioDeBusqueda.removeLast();
	}
	
	// Ejecuta la query en la base de datos con los criterios dados
	public List<Vuelo> ejecutar(){
		
		
		String query = "from Vuelos where ";
		query.concat(criterioDeBusqueda.getCriterio());
			
		Query q= SessionManager.getSession().createQuery(query);
		List<Vuelo> busqueda = q.list();
		return busqueda;
	}
}

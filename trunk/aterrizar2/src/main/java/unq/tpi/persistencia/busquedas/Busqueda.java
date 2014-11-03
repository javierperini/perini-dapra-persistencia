package unq.tpi.persistencia.busquedas;

import java.util.List;

import org.hibernate.Query;

import exceptions.NoSePuedeEliminarCriterioDeBusquedaException;
import exceptions.PrimerCriterioDebeSerSinConectorException;
import exceptions.SoloPrimerCriterioDebeSerSinConectorException;
import unq.tpi.persistencia.Entidad;
import unq.tpi.persistencia.Vuelo;
import unq.tpi.persistencia.daos.SessionManager;

public class Busqueda extends Entidad {

	private CriterioBusqueda criterioDeBusqueda;
	private HistorialDeBusqueda miHistorial;
	private CriterioDeOrden criterioDeOrden;
	private String query;
	
	public Busqueda (){
		miHistorial= new HistorialDeBusqueda();
		this.query="from Vuelo as this inner join this.tramos as t inner join t.asientos as a inner join a.unaCategoria";

	}

	public CriterioBusqueda getCriterioDeBusqueda() {
		return criterioDeBusqueda;
	}

	public void setCriterioDeBusqueda(CriterioBusqueda criterioDeBusqueda) {
		this.criterioDeBusqueda = criterioDeBusqueda;
	}

	public CriterioDeOrden getCriterioDeOrden() {
		return criterioDeOrden;
	}

	public void setCriterioDeOrden(CriterioDeOrden criteriosDeOrden) {
		this.criterioDeOrden = criteriosDeOrden;
	}

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
	
	public void armarBusqueda(){
		if(criterioDeBusqueda ==null){
			query.concat(criterioDeOrden.getCriterio());
		}
		if (criterioDeOrden ==null){
			query.concat(criterioDeBusqueda.getCriterio());
		}
		if(criterioDeBusqueda !=null && criterioDeOrden !=null){
			query.concat(criterioDeBusqueda.getCriterio());
			query.concat(criterioDeOrden.getCriterio());
		}
	}
	public List<Vuelo> ejecutarBusqueda(){
		this.armarBusqueda();
		miHistorial.agregar(query);
		Query q= SessionManager.getSession().createQuery(query);
		List<Vuelo> busqueda = q.list();
		return busqueda;
	}

	
}

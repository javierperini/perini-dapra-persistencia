package unq.tpi.persistencia.busquedas;

import exceptions.NoSePuedeEliminarCriterioDeBusquedaException;
import unq.tpi.persistencia.Entidad;
import unq.tpi.persistencia.Usuario;

public class Busqueda extends Entidad {

	private CriterioBusqueda criterioDeBusqueda;

	private CriterioDeOrden criterioDeOrden;
	private String query;
	private Usuario usuario;
	
	public Busqueda (Usuario usuario){
		
		this.usuario=usuario;
		this.query=" ";

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
			this.query.concat(criterioDeOrden.getCriterio());
		}
		if (criterioDeOrden ==null){
			this.query.concat(criterioDeBusqueda.getCriterio());
		}
		if(criterioDeBusqueda !=null && criterioDeOrden !=null){
			this.query.concat(criterioDeBusqueda.getCriterio());
			this.query.concat(criterioDeOrden.getCriterio());
		}
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public String getQuery(){
		return this.query;
	}
}

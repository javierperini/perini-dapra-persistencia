package unq.tpi.persistencia.busquedas;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import unq.tpi.persistencia.Entidad;
import unq.tpi.persistencia.Vuelo;
import unq.tpi.persistencia.daos.SessionManager;

public class Busqueda extends Entidad {

	private List<CriterioDeBusqueda> criterios = new ArrayList<CriterioDeBusqueda>();
	
	public void agregarCriterio(CriterioDeBusqueda nuevoCriterio){
		this.criterios.add(nuevoCriterio);
	}
	
	public void eliminarUltimoCriterio(){
		this.criterios.remove(this.criterios.size() - 1);
	}
	
	public List<Vuelo> ejecutar(){
		String criterios = "";
		for (CriterioDeBusqueda criterio : this.criterios){
			criterios.concat(" ");
			criterios.concat(criterio.getCriterio());
		}
		
		String query = "from Vuelos where ";
		query.concat(criterios);
			
		Query q= SessionManager.getSession().createQuery(query);
		List<Vuelo> busqueda = q.list();
		return busqueda;
	}
}

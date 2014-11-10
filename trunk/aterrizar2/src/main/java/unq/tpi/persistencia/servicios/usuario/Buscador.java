package unq.tpi.persistencia.servicios.usuario;

import java.util.List;

import org.hibernate.Query;

import unq.tpi.persistencia.Vuelo;
import unq.tpi.persistencia.busquedas.Busqueda;
import unq.tpi.persistencia.daos.SessionManager;

public class Buscador {
	
	private String query;
	private Busqueda busqueda;

	public Buscador(Busqueda busqueda){
		this.query= "select this from Vuelo as this left join this.miAerolinea as aerolinea left join this.unosTramos as t left join t.asientos as a left join a.unaCategoria as categoria";
		this.busqueda=busqueda;
	}
	
	public Busqueda getBusqueda() {
		return busqueda;
	}

	public void setBusqueda(Busqueda busqueda) {
		this.busqueda = busqueda;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getQuery() {
		return query;
	}

	public List<Vuelo> ejecutarBusqueda(){
		this.busqueda.armarBusqueda();
		return ejecutar(this.busqueda);
	}

	private List<Vuelo> ejecutar(Busqueda unaBusqueda) {
		String concat = query.concat(unaBusqueda.getQuery());
		System.out.println(concat);
		Query q= SessionManager.getSession().createQuery(concat);
		List<Vuelo> busqueda = q.list();
		return busqueda;
	}

	public void guardaBusqueda(Busqueda unaBusqueda) {
		new Crear<Busqueda>(unaBusqueda).execute();		
	}
	
	
	
	public List<Vuelo> ejecutarAnterior(int idBusqueda){
		Busqueda b= new Consultar<Busqueda>(Busqueda.class, idBusqueda).execute();
		return ejecutar(b);
	}
	
	
	

}

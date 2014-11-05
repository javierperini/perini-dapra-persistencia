package unq.tpi.persistencia.servicios.usuario;

import java.util.List;

import org.hibernate.Query;

import unq.tpi.persistencia.Empresa;
import unq.tpi.persistencia.Vuelo;
import unq.tpi.persistencia.busquedas.Busqueda;
import unq.tpi.persistencia.daos.SessionManager;
import unq.tpi.persistencia.servicios.Manager;

public class Buscador {
	
	private String query;
	private Busqueda busqueda;

	public Buscador(Busqueda busqueda){
		this.query= "select this from Vuelo as this inner join this.tramos as t inner join t.asientos as a inner join a.unaCategoria";
		this.busqueda=busqueda;
	}
	
	public List<Vuelo> ejecutarBusqueda(){
		this.busqueda.armarBusqueda();
		this.guardaBusqueda(this.busqueda);
		List<Vuelo> busqueda = ejecutar(this.busqueda);
		
		return busqueda;
	}

	private List<Vuelo> ejecutar(Busqueda unaBusqueda) {
		String concat = query.concat(unaBusqueda.getQuery());
		System.out.println(concat);
		Query q= SessionManager.getSession().createQuery(concat);
		List<Vuelo> busqueda = q.list();
		return busqueda;
	}

	private void guardaBusqueda(Busqueda unaBusqueda) {
		new Manager<Busqueda>().ejecutar(new Crear<Busqueda>(unaBusqueda));		
	}
	
	public List<Vuelo> ejecutarAnterior(int idBusqueda){
		Busqueda b=new Manager<Busqueda>().ejecutar(new Consultar<Busqueda>(Busqueda.class, idBusqueda));
		return ejecutar(b);
	}
	
	
	

}

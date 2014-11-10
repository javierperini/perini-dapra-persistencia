package unq.tpi.persistencia.usuarios;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import unq.tpi.persistencia.Vuelo;
import unq.tpi.persistencia.busquedas.Busqueda;
import unq.tpi.persistencia.busquedas.CriterioDeOrden;
import unq.tpi.persistencia.daos.SessionManager;
import unq.tpi.persistencia.servicios.Operation;
import unq.tpi.persistencia.servicios.usuario.Buscador;

public class BusquedaPorOrdenTest extends SetUpCliente {

	public void testOrdenarPorDuracion(){
		SessionManager.runInSession(new Operation<Void>()  {

			public Void execute()  {
				unaBusqueda = new Busqueda(usuario);
				unaBusqueda.setCriterioDeOrden(CriterioDeOrden.ordernarPorDuracion());
				Buscador unBuscador = new Buscador(unaBusqueda);
				unBuscador.guardaBusqueda(unaBusqueda);
				List<Vuelo> vuelos = unBuscador.ejecutarBusqueda();
				List<Vuelo> vuelosAnt = unBuscador.ejecutarAnterior(unaBusqueda.getId());
				assertEquals(vuelos, vuelosAnt);
				return null;
			}
		});
	}
	
	public void testOrdernarPorMenorCosto(){
		SessionManager.runInSession(new Operation<Void>()  {

			public Void execute()  {
				unaBusqueda = new Busqueda(usuario);
				unaBusqueda.setCriterioDeOrden(CriterioDeOrden.ordernarPorMenorCosto());
				Buscador unBuscador = new Buscador(unaBusqueda);
				unBuscador.guardaBusqueda(unaBusqueda);
				List<Vuelo> vuelos = unBuscador.ejecutarBusqueda();
				List<Vuelo> vuelosAnt = unBuscador.ejecutarAnterior(unaBusqueda.getId());
				assertEquals(vuelos, vuelosAnt);
				return null;
			}
		});
	}
	
	public void testOrdernarPorMenorCantidadDeEscalas(){
		SessionManager.runInSession(new Operation<Void>()  {

			public Void execute()  {
				unaBusqueda = new Busqueda(usuario);
				unaBusqueda.setCriterioDeOrden(CriterioDeOrden.ordernarPorMenorCantidadDeEscalas());
				Buscador unBuscador = new Buscador(unaBusqueda);
				unBuscador.guardaBusqueda(unaBusqueda);
				List<Vuelo> vuelos = unBuscador.ejecutarBusqueda();
				List<Vuelo> vuelosAnt = unBuscador.ejecutarAnterior(unaBusqueda.getId());
				assertEquals(vuelos, vuelosAnt);
				return null;
			}
		});
	}
	
	public void testOrdernarPorMenorCantidadDeEscalasYPorMenorCosto(){
		SessionManager.runInSession(new Operation<Void>()  {

			public Void execute()  {
				unaBusqueda = new Busqueda(usuario);
				unaBusqueda.setCriterioDeOrden(CriterioDeOrden.ordernarPorMenorCantidadDeEscalas());
				unaBusqueda.andCriterio(CriterioDeOrden.ordernarPorMenorCosto());
				Buscador unBuscador = new Buscador(unaBusqueda);
				unBuscador.guardaBusqueda(unaBusqueda);
				List<Vuelo> vuelos = unBuscador.ejecutarBusqueda();
				List<Vuelo> vuelosAnt = unBuscador.ejecutarAnterior(unaBusqueda.getId());
				assertEquals(vuelos, vuelosAnt);
				return null;
			}
		});
	}

}

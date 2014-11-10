package unq.tpi.persistencia.usuarios;

import java.util.List;

import org.junit.Test;

import unq.tpi.persistencia.Vuelo;
import unq.tpi.persistencia.busquedas.Busqueda;
import unq.tpi.persistencia.busquedas.CriterioBusqueda;
import unq.tpi.persistencia.busquedas.CriterioDeOrden;
import unq.tpi.persistencia.daos.SessionManager;
import unq.tpi.persistencia.servicios.Operation;
import unq.tpi.persistencia.servicios.usuario.Buscador;

public class BusquedaPorCondicionTest extends SetUpCliente{


		
	

	
	public void testCriterioDeBusquedaPorAerolinea(){
		SessionManager.runInSession(new Operation<Void>()  {

			public Void execute()  {
				unaBusqueda = new Busqueda(usuario);
				unaBusqueda.setCriterioDeBusqueda(CriterioBusqueda.busquedaPorAerolinea(tas));
				Buscador unBuscador = new Buscador(unaBusqueda);
				unBuscador.guardaBusqueda(unaBusqueda);
				List<Vuelo> vuelos = unBuscador.ejecutarBusqueda();
				List<Vuelo> vuelosAnt = unBuscador.ejecutarAnterior(unaBusqueda.getId());
				assertEquals(vuelos, vuelosAnt);
				return null;
			}
		});
	}
	
	public void testCriterioDeBusquedaPorCategoriaDeAsiento(){
		SessionManager.runInSession(new Operation<Void>()  {

			public Void execute()  {
				unaBusqueda = new Busqueda(usuario);
				unaBusqueda.setCriterioDeBusqueda(CriterioBusqueda.busquedaPorCategoriaDeAsiento(primera));
				Buscador unBuscador = new Buscador(unaBusqueda);
				unBuscador.guardaBusqueda(unaBusqueda);
				List<Vuelo> vuelos = unBuscador.ejecutarBusqueda();
				List<Vuelo> vuelosAnt = unBuscador.ejecutarAnterior(unaBusqueda.getId());
				assertEquals(vuelos, vuelosAnt);
				return null;
			}
		});
	}
		
		public void testCriterioDeBusquedaPorFechaDeSalida(){
			SessionManager.runInSession(new Operation<Void>()  {

				public Void execute()  {
					unaBusqueda = new Busqueda(usuario);
					unaBusqueda.setCriterioDeBusqueda(CriterioBusqueda.busquedaPorFechaDeSalida(4));
					Buscador unBuscador = new Buscador(unaBusqueda);
					unBuscador.guardaBusqueda(unaBusqueda);
					List<Vuelo> vuelos = unBuscador.ejecutarBusqueda();
					List<Vuelo> vuelosAnt = unBuscador.ejecutarAnterior(unaBusqueda.getId());
					assertEquals(vuelos, vuelosAnt);
					return null;
				}
			});	
	}
	
		
		public void testCriterioDeBusquedaPorFechaDeLlegada(){
			SessionManager.runInSession(new Operation<Void>()  {

				public Void execute()  {
					unaBusqueda = new Busqueda(usuario);
					unaBusqueda.setCriterioDeBusqueda(CriterioBusqueda.busquedaPorFechaDeLlegada(6));
					Buscador unBuscador = new Buscador(unaBusqueda);
					unBuscador.guardaBusqueda(unaBusqueda);
					List<Vuelo> vuelos = unBuscador.ejecutarBusqueda();
					List<Vuelo> vuelosAnt = unBuscador.ejecutarAnterior(unaBusqueda.getId());
					assertEquals(vuelos, vuelosAnt);
					return null;
				}
			});	
	}
	
		public void testCriterioDeBusquedaPorOrigen(){
			SessionManager.runInSession(new Operation<Void>()  {

				public Void execute()  {
					unaBusqueda = new Busqueda(usuario);
					unaBusqueda.setCriterioDeBusqueda(CriterioBusqueda.busquedaPorOrigen("Argentina"));
					Buscador unBuscador = new Buscador(unaBusqueda);
					unBuscador.guardaBusqueda(unaBusqueda);
					List<Vuelo> vuelos = unBuscador.ejecutarBusqueda();
					List<Vuelo> vuelosAnt = unBuscador.ejecutarAnterior(unaBusqueda.getId());
					assertEquals(vuelos, vuelosAnt);
					return null;
				}
			});	
	}
		
		public void testCriterioDeBusquedaPorDestino(){
			SessionManager.runInSession(new Operation<Void>()  {

				public Void execute()  {
					unaBusqueda = new Busqueda(usuario);
					unaBusqueda.setCriterioDeBusqueda(CriterioBusqueda.busquedaPorDestino("Brasil"));
					Buscador unBuscador = new Buscador(unaBusqueda);
					unBuscador.guardaBusqueda(unaBusqueda);
					List<Vuelo> vuelos = unBuscador.ejecutarBusqueda();
					List<Vuelo> vuelosAnt = unBuscador.ejecutarAnterior(unaBusqueda.getId());
					assertEquals(vuelos, vuelosAnt);
					return null;
				}
			});	
	}
	
		public void testCriterioDeBusquedaPorDestinoYPorFechaDeLlegada(){
			SessionManager.runInSession(new Operation<Void>()  {

				public Void execute()  {
					unaBusqueda = new Busqueda(usuario);
					unaBusqueda.setCriterioDeBusqueda(CriterioBusqueda.busquedaPorDestino("Brasil"));
					unaBusqueda.andCriterio(CriterioBusqueda.busquedaPorFechaDeLlegada(6));
					Buscador unBuscador = new Buscador(unaBusqueda);
					unBuscador.guardaBusqueda(unaBusqueda);
					List<Vuelo> vuelos = unBuscador.ejecutarBusqueda();
					List<Vuelo> vuelosAnt = unBuscador.ejecutarAnterior(unaBusqueda.getId());
					assertEquals(vuelos, vuelosAnt);
					return null;
				}
			});	
	}
	

		public void testCriterioDeBusquedaPorDestinoOPorFechaDeLlegada(){
			SessionManager.runInSession(new Operation<Void>()  {

				public Void execute()  {
					unaBusqueda = new Busqueda(usuario);
					unaBusqueda.setCriterioDeBusqueda(CriterioBusqueda.busquedaPorDestino("Brasil"));
					unaBusqueda.orCriterio(CriterioBusqueda.busquedaPorFechaDeLlegada(6));
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

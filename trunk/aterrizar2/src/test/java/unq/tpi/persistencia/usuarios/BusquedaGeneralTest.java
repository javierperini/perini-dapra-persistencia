package unq.tpi.persistencia.usuarios;

import java.util.List;

import unq.tpi.persistencia.Vuelo;
import unq.tpi.persistencia.busquedas.Busqueda;
import unq.tpi.persistencia.busquedas.CriterioBusqueda;
import unq.tpi.persistencia.busquedas.CriterioDeOrden;
import unq.tpi.persistencia.daos.SessionManager;
import unq.tpi.persistencia.servicios.Operation;
import unq.tpi.persistencia.servicios.usuario.Buscador;

public class BusquedaGeneralTest extends SetUpCliente {

	public void testOrdernarPorMenorCantidadDeEscalasYPorMenorCosto(){
		SessionManager.runInSession(new Operation<Void>()  {

			public Void execute()  {
				unaBusqueda = new Busqueda(usuario);
				unaBusqueda.setCriterioDeOrden(CriterioDeOrden.ordernarPorMenorCantidadDeEscalas());
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
}

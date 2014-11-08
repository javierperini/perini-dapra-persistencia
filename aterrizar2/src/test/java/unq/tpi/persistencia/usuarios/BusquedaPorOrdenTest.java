package unq.tpi.persistencia.usuarios;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import unq.tpi.persistencia.Asiento;
import unq.tpi.persistencia.Usuario;
import unq.tpi.persistencia.Vuelo;
import unq.tpi.persistencia.busquedas.Busqueda;
import unq.tpi.persistencia.busquedas.CriterioBusqueda;
import unq.tpi.persistencia.busquedas.CriterioDeOrden;
import unq.tpi.persistencia.daos.EntidadDAO;
import unq.tpi.persistencia.daos.SessionManager;
import unq.tpi.persistencia.servicios.Manager;
import unq.tpi.persistencia.servicios.Operation;
import unq.tpi.persistencia.servicios.usuario.Buscador;
import unq.tpi.persistencia.servicios.usuario.Consultar;
import unq.tpi.persistencia.servicios.usuario.EstaReservadoExeption;
import unq.tpi.persistencia.servicios.usuario.ReservardorDeAsiento;

public class BusquedaPorOrdenTest extends SetUpCliente{

	@Test
	public void testApp() throws Exception {
			
			
		}
	
	public void testCriterioDeBusqueda(){
		SessionManager.runInSession(new Operation<Void>()  {

			public Void execute()  {
				Busqueda unaBusqueda = new Busqueda(usuario);
				unaBusqueda.setCriterioDeBusqueda(CriterioBusqueda.busquedaPorAerolinea(tas));
				unaBusqueda.setCriterioDeOrden(CriterioDeOrden.ordernarPorDuracion());
				List<Vuelo> vuelos = new Buscador(unaBusqueda).ejecutarBusqueda();
				List<Vuelo> vuelosAnt = new Buscador(unaBusqueda).ejecutarAnterior(unaBusqueda.getId());
				assertTrue(vuelos == vuelosAnt);
				return null;
			}
		});
	}
	

}

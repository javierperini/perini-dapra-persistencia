package unq.tpi.persistencia.usuarios;

import java.util.List;

import unq.tpi.persistencia.Asiento;
import unq.tpi.persistencia.daos.EntidadDAO;
import unq.tpi.persistencia.daos.SessionManager;
import unq.tpi.persistencia.servicios.Operation;
import unq.tpi.persistencia.servicios.usuario.ReservardorDeAsiento;

public class ReservarAsientoDeTramoTest extends SetUpCliente {
	
	public void testReservarAsiento() throws Exception{
		SessionManager.runInSession(new Operation<Void>() {

			public Void execute() {
				List<Asiento> asientos = new ReservardorDeAsiento(usuario, argentinaBrasil).execute();
				Asiento asiento = new EntidadDAO<Asiento>(Asiento.class).get(asientos.get(0).getId());
				assertTrue(asiento.getEstaReservado());
				return null;
			}
		});
		
		
	
//	
//	public void testReservarUnConjuntoDeAsientos() throws Exception{
//		SessionManager.runInSession(new Operation<Void>() {
//
//			public Void execute() {
//			List<Asiento> asientos2 = new ReservardorDeAsiento(usuario, argentinaBrasil).reservarAsientosMultiples(asientosArgBr);
//			assertTrue(asientos2.containsAll(asientosArgBr));
//			}
//		});
		
		
	}

}

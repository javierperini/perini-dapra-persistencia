package unq.tpi.persistencia.usuarios;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import unq.tpi.persistencia.Asiento;
import unq.tpi.persistencia.daos.EntidadDAO;
import unq.tpi.persistencia.daos.SessionManager;
import unq.tpi.persistencia.servicios.Operation;
import unq.tpi.persistencia.servicios.usuario.EstaReservadoExeption;
import unq.tpi.persistencia.servicios.usuario.ReservardorDeAsiento;

public class ReservarAsientoDeTramoTest extends SetUpCliente {
	
	public void testReservarAsiento() throws Exception{
		SessionManager.runInSession(new Operation<Void>()  {

			public Void execute() throws EstaReservadoExeption {
				List<Asiento> asientos = new ReservardorDeAsiento(usuario, argentinaBrasil).execute();
				Asiento asiento = new EntidadDAO<Asiento>(Asiento.class).get(asientos.get(0).getId());
				assertTrue(asiento.getEstaReservado());
				return null;
			}
		});
	}
	
	@Test(expected= EstaReservadoExeption.class)
	public void testNoPuedoReservarAsiento() throws Exception{
		SessionManager.runInSession(new Operation<Void>() {
					
			public Void execute() throws EstaReservadoExeption {
				ReservardorDeAsiento rAsientos=new ReservardorDeAsiento(usuario, argentinaBrasil);
				rAsientos.execute();
				rAsientos.execute();
				return null;
			}
		});
	}
		
	public void testReservarUnConjuntoDeAsientos() throws Exception{
		SessionManager.runInSession(new Operation<Void>() {

			public Void execute() throws EstaReservadoExeption {
				
			ArrayList<Asiento> asientosArgBr = new ArrayList<Asiento>();
			asientosArgBr.add(a2);
			asientosArgBr.add(a3);
			List<Asiento> asientos2 = new ReservardorDeAsiento(usuario, argentinaBrasil).reservarAsientosMultiples(asientosArgBr);
			assertTrue(asientos2.containsAll(asientosArgBr));
			return null;
			}
		});
		}
		
	public void testNoPuedoReservarUnConjuntoDeAsientos() throws Exception{
		SessionManager.runInSession(new Operation<Void>() {

			public Void execute() throws EstaReservadoExeption {
			ReservardorDeAsiento rAsientos= new ReservardorDeAsiento(usuario, argentinaBrasil);
			rAsientos.execute();
			ArrayList<Asiento> asientosArgBr = new ArrayList<Asiento>();
			asientosArgBr.add(a1);
			asientosArgBr.add(a2);
			List<Asiento> asientos2 = rAsientos.reservarAsientosMultiples(asientosArgBr);
			assertFalse(asientos2.containsAll(asientosArgBr));
			return null;
			}
		});
		}
		public void testHayAsientosDisponibles() throws Exception{
			SessionManager.runInSession(new Operation<Void>() {

				public Void execute() {
				
				ArrayList<Asiento> asientosArgBr = new ArrayList<Asiento>();
				asientosArgBr.add(a2);
				asientosArgBr.add(a3);
				boolean resultado= new ReservardorDeAsiento(usuario, argentinaBrasil).asientoDisponibles(asientosArgBr);
				assertTrue(resultado);
				return null;
				}
			});
		}
		
		public void testNoHayAsientosDisponibles() throws Exception{
			SessionManager.runInSession(new Operation<Void>() {

				public Void execute() throws EstaReservadoExeption {
				ReservardorDeAsiento rAsientos=	new ReservardorDeAsiento(usuario, argentinaBrasil);
				ArrayList<Asiento> asientosArgBr = new ArrayList<Asiento>();
				asientosArgBr.add(a2);
				asientosArgBr.add(a3);
				rAsientos.reservarAsientosMultiples(asientosArgBr);
				assertFalse(rAsientos.asientoDisponibles(asientosArgBr));
				return null;
				}
			});
		}


}
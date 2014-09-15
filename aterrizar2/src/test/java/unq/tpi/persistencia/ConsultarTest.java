package unq.tpi.persistencia;

import unq.tpi.persistencia.servicios.JugadorManager;

public class ConsultarTest extends AbstractHibernateTest {
	public void testApp() throws Exception {
		Jugador j = new JugadorManager().consultarJugador(1);
		assertEquals("Batman", j.getApellido());
		assertEquals("JugadorX", j.getNombre());
		assertEquals(99, (int) j.getNroCamiseta());
	}

}

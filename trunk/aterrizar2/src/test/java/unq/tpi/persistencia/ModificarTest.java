package unq.tpi.persistencia;

import unq.tpi.persistencia.servicios.JugadorManager;

public class ModificarTest extends AbstractHibernateTest {
	public void testApp() throws Exception {
		Jugador j = new JugadorManager().modificarNombre(1,"Juanca");
		assertEquals("Batman", j.getApellido());
		assertEquals("Juanca", j.getNombre());
		assertEquals(99, (int) j.getNroCamiseta());
	}
}

package unq.tpi.persistencia;

import unq.tpi.persistencia.servicios.JugadorManager;

public class InsertarJugadorTest extends AbstractHibernateTest {

	public void testApp() throws Exception {
		new JugadorManager().crearJugador("JugadorX","Batman",99);
	}

}

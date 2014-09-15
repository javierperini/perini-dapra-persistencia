package unq.tpi.persistencia;

import unq.tpi.persistencia.servicios.UsuarioManager;

public class ConsultarTest extends AbstractHibernateTest {
	public void testApp() throws Exception {
		Usuario u = new UsuarioManager().consultarUsuario(1);
		assertEquals("JugadorX", u.getNombre());
	}

}
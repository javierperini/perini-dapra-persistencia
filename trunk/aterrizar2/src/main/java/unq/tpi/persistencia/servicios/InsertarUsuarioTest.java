package unq.tpi.persistencia.servicios;

import unq.tpi.persistencia.AbstractHibernateTest;

public class InsertarUsuarioTest extends AbstractHibernateTest {
	public void testApp() throws Exception {
		new UsuarioManager().crearUsuario("JugadorX");
	}
}

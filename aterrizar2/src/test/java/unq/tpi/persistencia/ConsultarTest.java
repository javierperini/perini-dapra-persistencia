package unq.tpi.persistencia;

import unq.tpi.persistencia.servicios.UsuarioManager;

//public class ConsultarTest extends AbstractHibernateTest {
public class ConsultarTest extends SetUpCliente{
	public void testApp() throws Exception {
		Usuario u = new UsuarioManager().consultarUsuario(usuario.getId());
		assertEquals(usuario.getNombre(), u.getNombre());
	}

}
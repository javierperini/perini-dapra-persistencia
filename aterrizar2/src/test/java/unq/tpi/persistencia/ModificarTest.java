package unq.tpi.persistencia;

import unq.tpi.persistencia.servicios.UsuarioManager;

public class ModificarTest extends AbstractHibernateTest {
	public void testApp() throws Exception {
		Usuario u = new UsuarioManager().modificarNombre(1,"Juanca");
		assertEquals("Juanca", u.getNombre());
	}
}
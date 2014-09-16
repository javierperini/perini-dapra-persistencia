package unq.tpi.persistencia;

import unq.tpi.persistencia.servicios.UsuarioManager;

public class ModificarTest extends SetUpCliente {
	
	public void testApp() throws Exception {
		Usuario u = new UsuarioManager().modificarNombre(usuario.getId(),"Juanca");
		assertEquals("Juanca", u.getNombre());
	}
}
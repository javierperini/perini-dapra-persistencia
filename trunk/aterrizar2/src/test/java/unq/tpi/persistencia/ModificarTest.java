package unq.tpi.persistencia;

import unq.tpi.persistencia.servicios.Manager;
import unq.tpi.persistencia.servicios.ModificarUsuario;

public class ModificarTest extends SetUpCliente {
	
	public void testApp() throws Exception {
		ModificarUsuario consulta= new ModificarUsuario(usuario.getId(),"Juanca");
		Usuario u = new Manager<Usuario>().modificar(consulta);
		assertEquals("Juanca", u.getNombre());
	}
}
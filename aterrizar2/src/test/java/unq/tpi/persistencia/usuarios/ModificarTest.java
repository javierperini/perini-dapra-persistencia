package unq.tpi.persistencia.usuarios;

import unq.tpi.persistencia.Usuario;
import unq.tpi.persistencia.servicios.Manager;
import unq.tpi.persistencia.servicios.usuario.ModificarUsuario;

public class ModificarTest extends SetUpCliente {
	
	public void testApp() throws Exception {
		ModificarUsuario consulta= new ModificarUsuario(usuario.getId(),"Juanca");
		Usuario u = new Manager<Usuario>().modificar(consulta);
		assertEquals("Juanca", u.getNombre());
	}
}
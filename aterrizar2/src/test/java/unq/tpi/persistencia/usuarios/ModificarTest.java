package unq.tpi.persistencia.usuarios;

import unq.tpi.persistencia.Usuario;
import unq.tpi.persistencia.servicios.Manager;
import unq.tpi.persistencia.servicios.usuario.Modificar;

public class ModificarTest extends SetUpCliente {
	
	public void testApp() throws Exception {
		Modificar consulta= new Modificar(usuario.getId(),"Juanca");
		Usuario u = new Manager<Usuario>().ejecutar(consulta);
		assertEquals("Juanca", u.getNombre());
	}
}
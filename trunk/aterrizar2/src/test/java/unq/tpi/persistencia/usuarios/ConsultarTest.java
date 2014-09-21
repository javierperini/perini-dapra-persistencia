package unq.tpi.persistencia.usuarios;

import unq.tpi.persistencia.Usuario;
import unq.tpi.persistencia.servicios.Manager;
import unq.tpi.persistencia.servicios.UsuarioManager;
import unq.tpi.persistencia.servicios.usuario.ConsultarUsuario;

//public class ConsultarTest extends AbstractHibernateTest {
public class ConsultarTest extends SetUpCliente{
	public void testApp() throws Exception {
		ConsultarUsuario consulta=new ConsultarUsuario(usuario.getId());
		Usuario u =  new Manager<Usuario>().consultar(consulta);
		assertEquals(usuario.getNombre(), u.getNombre());
	}

}
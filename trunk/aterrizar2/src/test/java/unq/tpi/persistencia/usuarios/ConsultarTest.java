package unq.tpi.persistencia.usuarios;

import unq.tpi.persistencia.Usuario;
import unq.tpi.persistencia.servicios.Manager;
import unq.tpi.persistencia.servicios.usuario.Consultar;

//public class ConsultarTest extends AbstractHibernateTest {
public class ConsultarTest extends SetUpCliente{
	public void testApp() throws Exception {
		Consultar consulta=new Consultar<Usuario>(Usuario.class, usuario.getId());
		Usuario u =  new Manager<Usuario>().ejecutar(consulta);
		assertEquals(usuario.getNombre(), u.getNombre());
		
	}
	

}
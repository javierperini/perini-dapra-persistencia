package unq.tpi.persistencia.usuarios;

import java.util.List;

import unq.tpi.persistencia.Asiento;
import unq.tpi.persistencia.Usuario;
import unq.tpi.persistencia.daos.SessionManager;
import unq.tpi.persistencia.servicios.Manager;
import unq.tpi.persistencia.servicios.Operation;
import unq.tpi.persistencia.servicios.UsuarioManager;
import unq.tpi.persistencia.servicios.usuario.ConsultarUsuario;

//public class ConsultarTest extends AbstractHibernateTest {
public class ConsultarTest extends SetUpCliente{
	public void testApp() throws Exception {
		ConsultarUsuario consulta=new ConsultarUsuario(usuario.getId());
		Usuario u =  new Manager<Usuario>().consultar(consulta);
		assertEquals(usuario.getNombre(), u.getNombre());
	}

	public void testApp2() throws Exception {
		/*
		SessionManager.runInSession(new Operation<Object>() {
			public Object execute() {
				ConsultarUsuario consulta=new ConsultarUsuario(usuario.getId());
				List<Asiento> m = (List<Asiento>)new Manager<Asiento>().query("from Asiento ");
				
				for (Asiento asiento : m) {
					
					System.out.println(asiento.getId());
					
				}
				return null;
			}
		});
		*/
	}
}
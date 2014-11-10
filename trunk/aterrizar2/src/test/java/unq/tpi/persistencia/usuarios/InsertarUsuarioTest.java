package unq.tpi.persistencia.usuarios;


import unq.tpi.persistencia.Usuario;
import unq.tpi.persistencia.servicios.Manager;
import unq.tpi.persistencia.servicios.usuario.Consultar;
import unq.tpi.persistencia.servicios.usuario.Crear;

public class InsertarUsuarioTest extends SetUpCliente{
	public void testApp() throws Exception {
		Usuario u= new Usuario("JuanCito");
		Crear<Usuario> c= new Crear<Usuario>(u);
		new Manager<Usuario>().ejecutar(c);
		Consultar<Usuario> consulta=new Consultar<Usuario>(Usuario.class, u.getId());
		Usuario p =  new Manager<Usuario>().ejecutar(consulta);
		assertEquals(u.getNombre(), p.getNombre() );
	}
}

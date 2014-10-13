package unq.tpi.persistencia.usuarios;


import unq.tpi.persistencia.Usuario;
import unq.tpi.persistencia.servicios.Manager;
import unq.tpi.persistencia.servicios.usuario.Crear;

public class InsertarUsuarioTest extends SetUpCliente{
	public void testApp() throws Exception {
		new Manager<Usuario>().crear(new Crear<Usuario>(new Usuario("JuanCito")));
	}
	
	
	
}

package unq.tpi.persistencia.usuarios;


import unq.tpi.persistencia.Usuario;
import unq.tpi.persistencia.servicios.Manager;
import unq.tpi.persistencia.servicios.usuario.CrearUsuario;

public class InsertarUsuarioTest extends SetUpCliente{
	public void testApp() throws Exception {
		CrearUsuario consulta= new CrearUsuario("JuanCito");
		new Manager<Usuario>().crear(consulta);
	}
	
	
	
}

package unq.tpi.persistencia;


import unq.tpi.persistencia.servicios.CrearUsuario;
import unq.tpi.persistencia.servicios.Manager;

public class InsertarUsuarioTest extends SetUpCliente{
	public void testApp() throws Exception {
		CrearUsuario consulta= new CrearUsuario("JuanCito");
		new Manager<Usuario>().crear(consulta);
	}
	
	
	
}

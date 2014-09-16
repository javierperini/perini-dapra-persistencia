package unq.tpi.persistencia;


import unq.tpi.persistencia.servicios.UsuarioManager;

public class InsertarUsuarioTest extends SetUpCliente{
	public void testApp() throws Exception {
		new UsuarioManager().crearUsuario("JuanCito");
	}
}

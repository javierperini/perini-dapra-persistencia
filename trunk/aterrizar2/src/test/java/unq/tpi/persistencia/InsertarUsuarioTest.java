package unq.tpi.persistencia;


import unq.tpi.persistencia.servicios.UsuarioManager;

public class InsertarUsuarioTest {
	public void testApp() throws Exception {
		new UsuarioManager().crearUsuario("JugadorX");
	}
}

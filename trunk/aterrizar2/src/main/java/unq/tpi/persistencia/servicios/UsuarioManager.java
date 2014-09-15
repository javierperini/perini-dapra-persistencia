package unq.tpi.persistencia.servicios;

import unq.tpi.persistencia.Usuario;
import unq.tpi.persistencia.daos.SessionManager;

public class UsuarioManager {
	public Usuario consultarJugador(int id) {
		return SessionManager.runInSession(new ConsultarUsuario(id));
	}

	public void crearUsuario(String nombre) {
		SessionManager.runInSession(new CrearUsuario(nombre));
	}

	public Usuario modificarNombre(int id, String nombre) {
		return SessionManager.runInSession(new ModificarUsuario(id,nombre));
	}
}

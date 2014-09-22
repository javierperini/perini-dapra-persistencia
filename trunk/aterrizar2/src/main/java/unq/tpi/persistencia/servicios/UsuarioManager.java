package unq.tpi.persistencia.servicios;



import unq.tpi.persistencia.Usuario;
import unq.tpi.persistencia.daos.SessionManager;
import unq.tpi.persistencia.servicios.usuario.ConsultarUsuario;
import unq.tpi.persistencia.servicios.usuario.CrearUsuario;
import unq.tpi.persistencia.servicios.usuario.ModificarUsuario;

public class UsuarioManager {
	public Usuario consultarUsuario(int id) {
		return SessionManager.runInSession(new ConsultarUsuario(id));
	}

	public Usuario crearUsuario(String nombre) {
		return SessionManager.runInSession(new CrearUsuario(nombre));
	}

	public Usuario modificarNombre(int id, String nombre) {
		return SessionManager.runInSession(new ModificarUsuario(id,nombre));
	}
}
package unq.tpi.persistencia.servicios;



import unq.tpi.persistencia.Usuario;
import unq.tpi.persistencia.daos.SessionManager;
import unq.tpi.persistencia.servicios.usuario.Consultar;
import unq.tpi.persistencia.servicios.usuario.Crear;
import unq.tpi.persistencia.servicios.usuario.Modificar;

public class UsuarioManager {
	public Usuario consultarUsuario(Usuario u) {
		return SessionManager.runInSession(new Consultar(u));
	}

	public Usuario crearUsuario(String nombre) {
		return SessionManager.runInSession(new Crear(nombre));
	}

	public Usuario modificarNombre(int id, String nombre) {
		return SessionManager.runInSession(new Modificar(id,nombre));
	}
}

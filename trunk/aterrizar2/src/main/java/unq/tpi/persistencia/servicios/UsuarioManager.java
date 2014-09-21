package unq.tpi.persistencia.servicios;

import java.math.BigDecimal;

import unq.tpi.persistencia.Usuario;
import unq.tpi.persistencia.daos.SessionManager;
import unq.tpi.persistencia.servicios.usuario.ConsultarUsuario;
import unq.tpi.persistencia.servicios.usuario.CrearUsuario;
import unq.tpi.persistencia.servicios.usuario.ModificarUsuario;

public class UsuarioManager {
	public Usuario consultarUsuario(BigDecimal id) {
		return SessionManager.runInSession(new ConsultarUsuario(id));
	}

	public Usuario crearUsuario(String nombre) {
		return SessionManager.runInSession(new CrearUsuario(nombre));
	}

	public Usuario modificarNombre(BigDecimal id, String nombre) {
		return SessionManager.runInSession(new ModificarUsuario(id,nombre));
	}
}

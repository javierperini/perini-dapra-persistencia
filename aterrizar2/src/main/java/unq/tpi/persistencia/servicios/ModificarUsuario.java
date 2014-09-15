package unq.tpi.persistencia.servicios;

import unq.tpi.persistencia.Usuario;
import unq.tpi.persistencia.daos.EntidadDAO;

public class ModificarUsuario implements Operation<Usuario> {

	private String nombre;
	private int id;

	public ModificarUsuario(int id, String nombre) {
		super();
		this.nombre = nombre;
		this.id = id;
	}

	public Usuario execute() {
		Usuario u =(Usuario) new EntidadDAO(Usuario.class).get(id);
		u.setNombre(nombre);
		return u;
	}

}

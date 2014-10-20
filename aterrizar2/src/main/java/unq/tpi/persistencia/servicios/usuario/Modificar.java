package unq.tpi.persistencia.servicios.usuario;

import unq.tpi.persistencia.Usuario;
import unq.tpi.persistencia.daos.EntidadDAO;
import unq.tpi.persistencia.servicios.Operation;

public class Modificar implements Operation<Usuario> {

	private String nombre;
	private int id;

	public Modificar(int id, String nombre) {
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

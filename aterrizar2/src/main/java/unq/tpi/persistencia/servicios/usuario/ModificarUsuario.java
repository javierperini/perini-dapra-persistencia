package unq.tpi.persistencia.servicios.usuario;

import java.math.BigDecimal;

import unq.tpi.persistencia.Usuario;
import unq.tpi.persistencia.daos.EntidadDAO;
import unq.tpi.persistencia.servicios.Operation;

public class ModificarUsuario implements Operation<Usuario> {

	private String nombre;
	private BigDecimal id;

	public ModificarUsuario(BigDecimal id, String nombre) {
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

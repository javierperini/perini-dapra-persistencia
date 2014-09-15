package unq.tpi.persistencia.servicios;

import unq.tpi.persistencia.Usuario;
import unq.tpi.persistencia.daos.EntidadDAO;

public class CrearUsuario implements Operation<Usuario>{

		private String nombre;

		public CrearUsuario(String nombre) {
			super();
			this.nombre = nombre;
		}

		public Usuario execute() {
			Usuario u = new Usuario(nombre);
			new EntidadDAO(Usuario.class).save(u);
			return u;
		}
	}


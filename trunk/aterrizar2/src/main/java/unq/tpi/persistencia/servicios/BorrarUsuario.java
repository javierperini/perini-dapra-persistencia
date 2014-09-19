package unq.tpi.persistencia.servicios;


import unq.tpi.persistencia.Usuario;
import unq.tpi.persistencia.daos.EntidadDAO;

public class BorrarUsuario implements Operation<Usuario> {

	private int id;
	
	public BorrarUsuario(int id) {
		super();
		this.id = id;
	}

	public Usuario execute() {
		EntidadDAO entidad=new EntidadDAO(Usuario.class);
		Usuario u = (Usuario) entidad.get(id);
		entidad.delete(u);
		return u;
	}

}

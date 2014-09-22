package unq.tpi.persistencia.servicios.usuario;


import unq.tpi.persistencia.Usuario;
import unq.tpi.persistencia.daos.EntidadDAO;
import unq.tpi.persistencia.servicios.Operation;

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

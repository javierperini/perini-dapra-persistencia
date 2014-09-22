package unq.tpi.persistencia.servicios.usuario;



import unq.tpi.persistencia.Usuario;
import unq.tpi.persistencia.daos.EntidadDAO;
import unq.tpi.persistencia.servicios.Operation;

public class ConsultarUsuario implements Operation<Usuario> {


	private int id;
	
	public ConsultarUsuario(int id) {
		super();
		this.id = id;
	}

	public Usuario execute() {
		Usuario u;
		u = (Usuario) new EntidadDAO(Usuario.class).get(id);
		return u;
	}
	
}

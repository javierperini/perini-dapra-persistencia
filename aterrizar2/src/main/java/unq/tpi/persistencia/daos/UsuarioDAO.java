package unq.tpi.persistencia.daos;


import unq.tpi.persistencia.Usuario;

public class UsuarioDAO {
	public Usuario get(int id){
		return (Usuario)SessionManager.getSession().get(Usuario.class,id);
	}

	public void save(Usuario u) {
		SessionManager.getSession().saveOrUpdate(u);
	}
}

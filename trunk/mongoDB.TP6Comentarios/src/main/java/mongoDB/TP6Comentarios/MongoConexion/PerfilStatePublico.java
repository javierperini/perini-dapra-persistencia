package mongoDB.TP6Comentarios.MongoConexion;

public class PerfilStatePublico extends PerfilState{

	public PerfilStatePublico(Perfil perfil) {
		super(perfil);
	}

	public Perfil verPerfil(Usuario usuario) throws PerfilNoVisibleException {
		return usuario.getPerfil();
	}
	
}

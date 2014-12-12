package mongoDB.TP6Comentarios.MongoConexion;

public class PerfilStatePrivado extends PerfilState {

	public PerfilStatePrivado(Perfil perfil) {
		super(perfil);
	}

	public Perfil verPerfil(Usuario usuario) throws PerfilNoVisibleException {
		throw new PerfilNoVisibleException("No podes ver este perfil");
	}
	
}

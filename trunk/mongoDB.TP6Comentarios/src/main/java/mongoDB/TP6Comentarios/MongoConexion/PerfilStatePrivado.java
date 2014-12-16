package mongoDB.TP6Comentarios.MongoConexion;


public class PerfilStatePrivado extends PerfilState {

	public PerfilStatePrivado() {
		// TODO Auto-generated constructor stub
	}
	
	public PerfilStatePrivado(Perfil perfil) {
		super(perfil);
	}

	public Perfil verPerfil(Perfil usuario) throws PerfilNoVisibleException {
		throw new PerfilNoVisibleException("No podes ver este perfil");
	}
	
}

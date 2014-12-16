package mongoDB.TP6Comentarios.MongoConexion;


public class PerfilStatePublico extends PerfilState{

	public PerfilStatePublico() {
		
	}
	
	public PerfilStatePublico(Perfil perfil) {
		super(perfil);
	}

	public Perfil verPerfil(Perfil usuario) throws PerfilNoVisibleException {
		return this.getPerfil();
	}
	
}

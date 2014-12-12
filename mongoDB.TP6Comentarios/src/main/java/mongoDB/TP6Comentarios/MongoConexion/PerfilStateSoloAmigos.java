package mongoDB.TP6Comentarios.MongoConexion;

public class PerfilStateSoloAmigos extends PerfilState{

	public PerfilStateSoloAmigos(Perfil perfil) {
		super(perfil);
	}

	public Perfil verPerfil(Usuario usuario) throws PerfilNoVisibleException {
		if(perfil.getUsuario().soyAmigoDe(usuario)){
			return usuario.getPerfil();
		}
		else{
			throw new PerfilNoVisibleException("No podes ver este perfil");
		}
	}
	
	
}

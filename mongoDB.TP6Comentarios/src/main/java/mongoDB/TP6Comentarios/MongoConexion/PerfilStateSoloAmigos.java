package mongoDB.TP6Comentarios.MongoConexion;


public class PerfilStateSoloAmigos extends PerfilState{

	public PerfilStateSoloAmigos() {
		// TODO Auto-generated constructor stub
	}
	
	public PerfilStateSoloAmigos(Perfil perfil) {
		super(perfil);
	}

	public Perfil verPerfil(Perfil usuario) throws PerfilNoVisibleException {
		if(perfil.soyAmigoDe(usuario)){
			return this.perfil;
		}
		else{
			throw new PerfilNoVisibleException("No podes ver este perfil");
		}
	}
	
	
}

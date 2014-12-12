package mongoDB.TP6Comentarios.MongoConexion;

import com.mongodb.BasicDBObject;

public abstract class PerfilState extends BasicDBObject {

	protected Perfil perfil;
	
	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public PerfilState(Perfil perfil){
		this.perfil = perfil;
	}
	
	public abstract Perfil verPerfil(Usuario usuario)throws PerfilNoVisibleException ;
	
}

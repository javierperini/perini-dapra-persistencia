package mongoDB.TP6Comentarios.MongoConexion;

import net.vz.mongodb.jackson.ObjectId;

import org.codehaus.jackson.annotate.JsonProperty;

import com.mongodb.BasicDBObject;

public abstract class PerfilState extends BasicDBObject {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ObjectId
	@JsonProperty("_id")
	private String id;
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

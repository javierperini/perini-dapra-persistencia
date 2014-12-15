package mongoDB.TP6Comentarios.MongoConexion;

import net.vz.mongodb.jackson.ObjectId;

import org.codehaus.jackson.annotate.JsonProperty;

public class PerfilStatePrivado extends PerfilState {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ObjectId
	@JsonProperty("_id")
	private String id;
	public PerfilStatePrivado(Perfil perfil) {
		super(perfil);
	}

	public Perfil verPerfil(Usuario usuario) throws PerfilNoVisibleException {
		throw new PerfilNoVisibleException("No podes ver este perfil");
	}
	
}

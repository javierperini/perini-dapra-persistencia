package mongoDB.TP6Comentarios.MongoConexion;

import net.vz.mongodb.jackson.ObjectId;

import org.codehaus.jackson.annotate.JsonProperty;

public class PerfilStateSoloAmigos extends PerfilState{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ObjectId
	@JsonProperty("_id")
	private String id;

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

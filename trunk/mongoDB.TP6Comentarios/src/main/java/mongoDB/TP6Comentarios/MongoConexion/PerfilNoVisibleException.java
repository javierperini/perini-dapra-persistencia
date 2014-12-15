package mongoDB.TP6Comentarios.MongoConexion;

import net.vz.mongodb.jackson.ObjectId;

import org.codehaus.jackson.annotate.JsonProperty;

public class PerfilNoVisibleException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ObjectId
	@JsonProperty("_id")
	private String id;
	public PerfilNoVisibleException(String exception) {
		super(exception);
	}
	
}

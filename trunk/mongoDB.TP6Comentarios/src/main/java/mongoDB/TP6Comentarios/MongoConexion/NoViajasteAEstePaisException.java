package mongoDB.TP6Comentarios.MongoConexion;

import net.vz.mongodb.jackson.ObjectId;

import org.codehaus.jackson.annotate.JsonProperty;

public class NoViajasteAEstePaisException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ObjectId
	@JsonProperty("_id")
	private String id;

	public NoViajasteAEstePaisException(String exception){
		super(exception);
	}

}

package mongoDB.TP6Comentarios.MongoConexion;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonSubTypes.Type;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.annotate.JsonTypeInfo.As;

@JsonSubTypes({ 
	@Type(value = PerfilStatePrivado.class, name = "privado"),
	@Type(value = PerfilStatePublico.class, name = "publico"),
	@Type(value = PerfilStateSoloAmigos.class, name = "amigos")
})
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = As.PROPERTY, property = "@class")
public abstract class PerfilState implements Serializable{

	
	@JsonIgnore
	protected Perfil perfil;
	
	public PerfilState() {
		
	}

	
	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public PerfilState(Perfil perfil){
		this.perfil = perfil;
	}
	
	public abstract Perfil verPerfil(Perfil usuario)throws PerfilNoVisibleException ;
	
}

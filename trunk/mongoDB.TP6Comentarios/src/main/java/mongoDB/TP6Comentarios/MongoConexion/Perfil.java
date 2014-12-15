package mongoDB.TP6Comentarios.MongoConexion;

import net.vz.mongodb.jackson.ObjectId;

import org.codehaus.jackson.annotate.JsonProperty;



public class Perfil {
	private PerfilState estadoDePerfil;
	private Usuario usuario;
	@ObjectId
	@JsonProperty("_id")
	private String id;
	public Perfil(Usuario usuario){
		this.estadoDePerfil = new PerfilStatePublico(this);
		this.usuario= usuario;
	}

	public Perfil verPerfil(Usuario usuario) throws PerfilNoVisibleException{
		return this.estadoDePerfil.verPerfil(usuario);
	}
	
	public void comentarDestino(Pais pais, String comentario) throws NoViajasteAEstePaisException{
		if(this.getUsuario().viajeA(pais)){
			pais.comentar(comentario);
		}
		else{
			throw new NoViajasteAEstePaisException("No podes comentar donde no viajaste");
		}
	}

	public Usuario getUsuario() {
		return usuario;
	}
	
	public void darMeGusta(Pais pais) throws NoViajasteAEstePaisException{
		if(this.getUsuario().viajeA(pais)){
			pais.darMeGusta();
		}
		else{
			throw new NoViajasteAEstePaisException("No podes dar me gusta donde no viajaste");
		}
	}
	
	public void darNoMeGusta(Pais pais) throws NoViajasteAEstePaisException{
		if(this.getUsuario().viajeA(pais)){
			pais.darNoMeGusta();
		}
		else{
			throw new NoViajasteAEstePaisException("No podes dar me gusta donde no viajaste");
		}
	}
	
	public void xxxxxxx(Pais pais, String op) throws NoViajasteAEstePaisException{
		if(this.getUsuario().viajeA(pais)){
			//pais.darNoMeGusta();
			//pais
		}
		else{
			throw new NoViajasteAEstePaisException("No podes dar me gusta donde no viajaste");
		}
	}
	
	
	public void cambiarPrivacidadAPrivado(){
		this.estadoDePerfil = new PerfilStatePrivado(this);
	}
	
	public void cambiarPrivacidadAPublico(){
		this.estadoDePerfil = new PerfilStatePublico(this);
	}
	
	public void cambiarPrivacidadASoloAmigos(){
		this.estadoDePerfil = new PerfilStateSoloAmigos(this);
	}
}
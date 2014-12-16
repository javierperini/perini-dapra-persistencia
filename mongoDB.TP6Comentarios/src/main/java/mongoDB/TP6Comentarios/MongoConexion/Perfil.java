package mongoDB.TP6Comentarios.MongoConexion;

import java.io.Serializable;
import java.util.ArrayList;

import net.vz.mongodb.jackson.ObjectId;

import org.codehaus.jackson.annotate.JsonManagedReference;
import org.codehaus.jackson.annotate.JsonProperty;



public class Perfil  implements Serializable {
	
	@ObjectId
	@JsonProperty("_id")
	private String id;
	
	private PerfilState estadoDePerfil;
	private String nombreUsuario;
	private ArrayList<Pais> misViajes = new ArrayList<Pais>();
	private ArrayList<String> amigos = new ArrayList<String>();
	
	public Perfil(){}
	
	public Perfil(String nombreUsuario){
		this.nombreUsuario= nombreUsuario;
	}

	public Perfil verPerfil(Perfil usuario) throws PerfilNoVisibleException{
		return this.estadoDePerfil.verPerfil(usuario);
	}
	
	public void comentarDestino(Pais pais, String comentario) throws NoViajasteAEstePaisException{
		if(this.viajeA(pais)){
			pais.comentar(comentario);
		}
		else{
			throw new NoViajasteAEstePaisException("No podes comentar donde no viajaste");
		}
	}

	public Pais buscarPais(Pais pais){
		  if(this.viajeA(pais)){
			  return pais;
		  }
		  return new Pais();
	}
	
	public void darMeGusta(Pais pais) throws NoViajasteAEstePaisException{
		if(this.viajeA(pais)){
			pais.darMeGusta();
		}
		else{
			throw new NoViajasteAEstePaisException("No podes dar me gusta donde no viajaste");
		}
	}
	
	public void darNoMeGusta(Pais pais) throws NoViajasteAEstePaisException{
		if(this.viajeA(pais)){
			pais.darNoMeGusta();
		}
		else{
			throw new NoViajasteAEstePaisException("No podes dar me gusta donde no viajaste");
		}
	}
	
	public boolean viajeA(Pais unPais) {
		for (Pais p : misViajes) {
			if(unPais.getNombre().toLowerCase().equals(p.getNombre().toLowerCase()))
				return true;
			
		}
		return false;
	}
	
	public void agregarAmigo(String amigo) {
		this.getAmigos().add(amigo);
	}
	
	public void viajarA(Pais unPais) {
		this.getMisViajes().add(unPais);
	}
	
	public boolean soyAmigoDe(Perfil amigo) {
		return this.getAmigos().contains(amigo.getNombreUsuario());
	}

	
	public ArrayList<String> getAmigos() {
		return amigos;
	}

	public void setAmigos(ArrayList<String> amigos) {
		this.amigos = amigos;
	}

	public PerfilState getEstadoDePerfil() {
		return estadoDePerfil;
	}

	public void setEstadoDePerfil(PerfilState estadoDePerfil) {
		this.estadoDePerfil = estadoDePerfil;
		if(this.estadoDePerfil != null)
			this.estadoDePerfil.setPerfil(this);
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public ArrayList<Pais> getMisViajes() {
		return misViajes;
	}

	public void setMisViajes(ArrayList<Pais> misViajes) {
		this.misViajes = misViajes;
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

	public String getId() {
		return id;
	}

}

package mongodbService;

import java.util.List;

import net.vz.mongodb.jackson.DBQuery;
import mongoDB.TP6Comentarios.MongoConexion.NoViajasteAEstePaisException;
import mongoDB.TP6Comentarios.MongoConexion.Pais;
import mongoDB.TP6Comentarios.MongoConexion.Perfil;
import mongoDB.TP6Comentarios.MongoConexion.PerfilNoVisibleException;

public class Consultas {
	private Collection<Perfil> home = SistemDB.instance().collection(Perfil.class);

	public void comentar(Pais pais, Perfil p, String comentario ) throws NoViajasteAEstePaisException{
		Perfil p1 = pedirUsuario(p.getNombreUsuario());
		p1.comentarDestino(pais, comentario);
		home.update(p1.getId(), p1);
	}

	public Perfil pedirUsuario(String nombre) {
		List<Perfil> perfiles = home.getMongoCollection().find(DBQuery.is("nombreUsuario", nombre)).toArray();
		return perfiles.get(0);
	}
	
	public void agregarDestino(Pais pais, Perfil p){
		Perfil p1 = pedirUsuario(p.getNombreUsuario());
		p1.viajarA(pais);
		home.update(p1.getId() , p1);
	}
	
	public void darMeGusta(Pais pais, Perfil p) throws NoViajasteAEstePaisException{
		Perfil p1 = pedirUsuario(p.getNombreUsuario());
		p1.darMeGusta(pais);
		home.update(p1.getId() , p1);
	}
	
	public void darNoMeGusta(Pais pais, Perfil p) throws NoViajasteAEstePaisException{
		Perfil p1 = pedirUsuario(p.getNombreUsuario());
		p1.darNoMeGusta(pais);
		home.update(p1.getId() , p1);
	}
	
	public void cambiarAPerfilPublico(Perfil p){
		Perfil p1 = pedirUsuario(p.getNombreUsuario());
		p1.cambiarPrivacidadAPublico();
		home.update(p1.getId() , p1);
	}
	
	public void cambiarAPerfilPrivado(Perfil p){
		Perfil p1 = pedirUsuario(p.getNombreUsuario());
		p1.cambiarPrivacidadAPrivado();
		home.update(p1.getId() , p1);
	}
	
	public void cambiarAPerfilSoloAmigos(Perfil p){
		Perfil p1 = pedirUsuario(p.getNombreUsuario());
		p1.cambiarPrivacidadASoloAmigos();
		home.update(p1.getId() , p1);
	}
	
	public Perfil verPerfilDe(Perfil perfil, String nombre) throws PerfilNoVisibleException{
		Perfil p1 = this.pedirUsuario(nombre);
		return p1.verPerfil(perfil);
		
	}
	
	public void agregarAmigo(Perfil perfil, String nombre){
		Perfil p1 = this.pedirUsuario(nombre);
		p1.agregarAmigo(perfil.getNombreUsuario());
		home.update(p1.getId() , p1);
	}
	
}

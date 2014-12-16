package mongoDB.TP6Comentarios.MongoExample;

import java.util.Arrays;
import java.util.List;

import mongoDB.TP6Comentarios.MongoConexion.Pais;
import mongoDB.TP6Comentarios.MongoConexion.Perfil;
import mongoDB.TP6Comentarios.MongoConexion.PerfilStatePublico;
import mongodbService.Collection;
import mongodbService.SistemDB;


public class InsertExample {
	
	public static void main(String[] args){
		List<Pais> paises = Arrays.asList(new Pais("Argentina"),new Pais("Brasil"));
		List<String> amigos = Arrays.asList("Mario", "Brasil");
		Perfil perfil= new Perfil("Pepe");
		PerfilStatePublico pp = new PerfilStatePublico(perfil);
		perfil.setEstadoDePerfil(pp);
		
		for ( String u : amigos){
			perfil.agregarAmigo(u);
		}
		for ( Pais p : paises){
			perfil.viajarA(p);
		}
		Collection<Perfil> home = SistemDB.instance().collection(Perfil.class);
		home.insert(perfil);
	}

}

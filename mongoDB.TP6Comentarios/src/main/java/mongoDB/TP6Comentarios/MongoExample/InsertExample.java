package mongoDB.TP6Comentarios.MongoExample;

import java.util.Arrays;
import java.util.List;

import mongoDB.TP6Comentarios.MongoConexion.Pais;
import mongoDB.TP6Comentarios.MongoConexion.Usuario;
import mongodbService.SistemDB;

import com.mongodb.DBCollection;


public class InsertExample {
	
	public static void main(String[] args){
		Usuario hongo = new Usuario("Hongo");
		hongo.crearPerfil();
		List<Usuario> amigos = Arrays.asList(new Usuario("Pepe"), new Usuario("Juan"), new Usuario("Cosme"));
		List<Pais> paises = Arrays.asList(new Pais("Uruguay"),new Pais("Argentina"),new Pais("Brasil"));
		for ( Usuario u : amigos){
			hongo.agregarAmigo(u);
		}
		for ( Pais p : paises){
			hongo.viajarA(p);
		}
		DBCollection home = SistemDB.instance().collection(Usuario.class);
		hongo.crearObjectDb( home);
	}

}

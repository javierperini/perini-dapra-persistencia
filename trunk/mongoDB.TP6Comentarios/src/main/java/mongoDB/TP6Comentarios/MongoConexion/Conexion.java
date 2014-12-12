package mongoDB.TP6Comentarios.MongoConexion;

import java.net.UnknownHostException;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

public class Conexion {
	public static void main(String args[]) {
		/*
		 * try{ // To connect to mongodb server MongoClient mongoClient = new
		 * MongoClient( "localhost" , 27017 ); // Now connect to your databases
		 * DB db = mongoClient.getDB( "test" );
		 * System.out.println("Connect to database successfully"); boolean auth
		 * = db.authenticate("ronnie", "123456".toCharArray());
		 * System.out.println("Authentication: "+auth); }catch(Exception e){
		 * System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		 * }
		 */
		try {

			Mongo mongo = new Mongo("localhost", 27017);
			DB db = mongo.getDB("testdb");

			boolean auth = db.authenticate("lucho", "123456".toCharArray());
			if (auth) {

				DBCollection table = db.getCollection("user");
				Usuario pepe = new Usuario("Pepe");
				Usuario beto = new Usuario("Beto");
				Usuario cacho = new Usuario("Cacho");
				Pais brasil = new Pais("Brasil");
				Pais jamaica = new Pais("Jamaica");
				beto.crearObjectDb(table);
				cacho.crearObjectDb(table);
				pepe.agregarAmigo(beto);
				pepe.agregarAmigo(cacho);
				pepe.viajarA(brasil);
				pepe.viajarA(jamaica);
				pepe.crearPerfil();
				
				System.out.println("1. Find first matched document");
				DBCursor dbObject = table.find(pepe.crearObjectDb(table));
				System.out.println(dbObject);
				 Object q = dbObject.getQuery().get("Pepe");
				//for ( Usuario u : dbObject.getQuery().get("misAmigos")){
					System.out.println(q.toString());
				//}
					dbObject.getKeysWanted();
				System.out.println("Login is successful!");
			} else {
				System.out.println("Login is failed!");
			}
			System.out.println("Done");

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (MongoException e) {
			e.printStackTrace();
		}
	}
}

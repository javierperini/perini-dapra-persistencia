package mongodbTest;


import java.util.List;

import mongoDB.TP6Comentarios.MongoConexion.Usuario;
import mongoDB.TP6Comentarios.MongoExample.InsertExample;
import mongodbService.Collection;
import mongodbService.SistemDB;
import net.vz.mongodb.jackson.DBQuery;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class ExampleTest {
//	private Collection<Usuario> home = SistemDB.instance().collection(Usuario.class);
	
	@Before
	public void fillDB(){
		InsertExample.main(null);
	}
	
	@After
	public void cleanDB(){
//		home.getMongoCollection().drop();
	}
	
	@Test
	public void findByCode(){
//		List<Usuario> usuarios = home.getMongoCollection().find(DBQuery.is("nombre", "Pepe")).toArray();
//		
//		Assert.assertEquals(usuarios.size(), 1);
//		Usuario usuario = usuarios.get(0);
//		
//		Assert.assertEquals(usuario.getNombre(), "Pepe");
		
	}
//	
//	@Test
//	public void findByZone(){
//		List<Producto> productos = home.getMongoCollection().find(DBQuery.in("codigo", "1111111", "2222222", "5555555")).toArray();
//		
//		Assert.assertEquals(productos.size(), 2);
//	}
}

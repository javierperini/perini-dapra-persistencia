package mongodbTest;


import java.util.List;

import mongoDB.TP6Comentarios.MongoConexion.NoViajasteAEstePaisException;
import mongoDB.TP6Comentarios.MongoConexion.Pais;
import mongoDB.TP6Comentarios.MongoConexion.Perfil;
import mongoDB.TP6Comentarios.MongoConexion.PerfilNoVisibleException;
import mongoDB.TP6Comentarios.MongoConexion.PerfilStatePrivado;
import mongoDB.TP6Comentarios.MongoConexion.PerfilStatePublico;
import mongoDB.TP6Comentarios.MongoConexion.PerfilStateSoloAmigos;
import mongoDB.TP6Comentarios.MongoExample.InsertExample;
import mongodbService.Collection;
import mongodbService.Consultas;
import mongodbService.SistemDB;
import net.vz.mongodb.jackson.DBQuery;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class ExampleTest {
	private Collection<Perfil> home = SistemDB.instance().collection(Perfil.class);
	
	Perfil perfil;
	Perfil hongo;
	Consultas c;
	Pais holanda;
	Pais brasil;
	
	
	@Before
	public void fillDB(){
		InsertExample.main(null);
		this.perfil = new Perfil("Pepe");
		this.c = new Consultas();
		this.holanda = new Pais("Yolanda");
		this.brasil = new Pais("Brasil");
		this.hongo = new Perfil("Hongo");
		this.hongo.setEstadoDePerfil(new PerfilStatePublico());
		
	}
	
	@After
	public void cleanDB(){
		home.getMongoCollection().drop();
	}
	
	@Test
	public void findByCode(){
		List<Perfil> perfiles = home.getMongoCollection().find(DBQuery.is("nombreUsuario", "Pepe")).toArray();
		
		Assert.assertEquals(perfiles.size(), 1);
		Perfil usuario = perfiles.get(0);
		
		Assert.assertEquals(usuario.getNombreUsuario(), "Pepe");
		
	}
	
	@Test
	public void agregarDestino(){
		this.c.agregarDestino(holanda, perfil);
		Perfil usuario=this.c.pedirUsuario("Pepe");
		Assert.assertEquals(usuario.getMisViajes().size(), 3);	
	}
	
	@Test
	public void comentar() throws NoViajasteAEstePaisException{
		this.c.comentar(brasil, perfil, "bueno");
		Perfil usuario=this.c.pedirUsuario("Pepe");
		Assert.assertEquals(usuario.buscarPais(brasil).getComentarios().size(), 1);
	}
	
	@Test
	public void megustear() throws NoViajasteAEstePaisException{
		this.c.darMeGusta(brasil, perfil);
		Perfil usuario=this.c.pedirUsuario("Pepe");
		Assert.assertEquals(usuario.buscarPais(brasil).getMeGusta(), 1);
	}
	
	@Test
	public void noMegustear() throws NoViajasteAEstePaisException{
		this.c.darNoMeGusta(brasil, perfil);
		Perfil usuario=this.c.pedirUsuario("Pepe");
		Assert.assertEquals(usuario.buscarPais(brasil).getNoMeGusta(), 1);
	}
	
	@Test
	public void publico(){
		this.c.cambiarAPerfilPublico(perfil);
		Perfil usuario=this.c.pedirUsuario("Pepe");
		Assert.assertEquals(usuario.getEstadoDePerfil().getClass(), PerfilStatePublico.class);
	}
	
	@Test
	public void privado(){
		this.c.cambiarAPerfilPrivado(perfil);
		Perfil usuario=this.c.pedirUsuario("Pepe");
		Assert.assertEquals(usuario.getEstadoDePerfil().getClass(), PerfilStatePrivado.class);
	}
	
	@Test
	public void soloAmigos(){
		this.c.cambiarAPerfilSoloAmigos(perfil);
		Perfil usuario=this.c.pedirUsuario("Pepe");
		Assert.assertEquals(usuario.getEstadoDePerfil().getClass(), PerfilStateSoloAmigos.class);
	}
	
	@Test
	public void visibilidadPublica() throws PerfilNoVisibleException{
		Perfil usuario=this.c.pedirUsuario("Pepe");
		Perfil p = this.c.verPerfilDe(hongo, "Pepe");
		Assert.assertEquals(usuario.getNombreUsuario(), p.getNombreUsuario() );
	}
	
	@Test (expected = PerfilNoVisibleException.class)
	public void visibilidadPrivada() throws PerfilNoVisibleException{
		this.c.cambiarAPerfilPrivado(perfil);
		Perfil p = this.c.verPerfilDe(hongo, "Pepe");
	}

	@Test (expected = PerfilNoVisibleException.class)
	public void visibilidadNoSonAmigos() throws PerfilNoVisibleException{
		this.c.cambiarAPerfilSoloAmigos(perfil);
		Perfil p = this.c.verPerfilDe(hongo, "Pepe");
	}

	@Test 
	public void visibilidadSoloAmigos() throws PerfilNoVisibleException{
		Perfil usuario=this.c.pedirUsuario("Pepe");
		this.c.cambiarAPerfilSoloAmigos(perfil);
		this.c.agregarAmigo(hongo, "Pepe");
		Perfil p = this.c.verPerfilDe(hongo, "Pepe");
		Assert.assertEquals(usuario.getNombreUsuario(), p.getNombreUsuario());
	}
	
}

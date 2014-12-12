package mongoDB.TP6Comentarios.MongoConexion;

import java.awt.List;
import java.util.ArrayList;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

public class Usuario extends BasicDBObject {

	private ArrayList<Pais> misViajes;
	private String nombre;
	private ArrayList<Usuario> amigos;
	private Perfil perfil;

	public Usuario(String nombre) {
		this.nombre = nombre;
		this.misViajes = new ArrayList<Pais>();
		this.amigos = new ArrayList<Usuario>();

	}

	public ArrayList<Pais> getMisViajes() {
		return misViajes;
	}

	public void setMisViajes(ArrayList<Pais> misViajes) {
		this.misViajes = misViajes;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setAmigos(ArrayList<Usuario> amigos) {
		this.amigos = amigos;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public String getNombre() {
		return nombre;
	}

	public ArrayList<Usuario> getAmigos() {
		return amigos;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void agregarAmigo(Usuario amigo) {
		this.getAmigos().add(amigo);
		amigo.getAmigos().add(this);
	}
	
	public void viajarA(Pais unPais) {
		this.getMisViajes().add(unPais);
	}

	public boolean viajeA(Pais unPais) {
		return this.getMisViajes().contains(unPais);
	}

	public boolean soyAmigoDe(Usuario amigo) {
		return this.getAmigos().contains(amigo);
	}

	public void crearPerfil() {
		this.perfil = new Perfil(this);
	}

	public DBObject crearObjectDb(DBCollection collection) {

		BasicDBObject data = new BasicDBObject();
		data.append("nombre", this.nombre);
		data.append("misViajes", this.misViajes);
		data.append("misAmigos", this.amigos);
		data.append("perfil", this.perfil);
		DBObject list = new BasicDBObject(this.nombre, data);

		collection.insert(list);
		return list;

	}

}

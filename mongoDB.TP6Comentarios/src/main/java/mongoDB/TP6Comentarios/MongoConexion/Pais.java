package mongoDB.TP6Comentarios.MongoConexion;

import java.util.ArrayList;

import com.mongodb.BasicDBObject;

public class Pais extends BasicDBObject{

	private String nombre;
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setMeGusta(int meGusta) {
		this.meGusta = meGusta;
	}

	public void setNoMeGusta(int noMeGusta) {
		this.noMeGusta = noMeGusta;
	}

	public void setComentarios(ArrayList<String> comentarios) {
		this.comentarios = comentarios;
	}

	private int meGusta;
	private int noMeGusta;
	private ArrayList<String> comentarios;

	public Pais(String nombre) {
		this.nombre = nombre;
		this.meGusta = 0;
		this.noMeGusta = 0;
		this.comentarios = new ArrayList<String>();
	}

	public String getNombre() {
		return nombre;
	}

	public int getMeGusta() {
		return meGusta;
	}

	public int getNoMeGusta() {
		return noMeGusta;
	}

	public ArrayList<String> getComentarios() {
		return comentarios;
	}

	public void darMeGusta(){
		this.meGusta ++;
	}
	
	public void darNoMeGusta(){
		this.noMeGusta ++;
	}
	
	public void comentar(String comentario){
		this.comentarios.add(comentario);
	}
}

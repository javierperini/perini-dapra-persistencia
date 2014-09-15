package unq.tpi.persistencia;

public class Usuario {
	
	private int id;
	private String nombre;

	public Usuario(String nombre){
		this.setNombre(nombre);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

}

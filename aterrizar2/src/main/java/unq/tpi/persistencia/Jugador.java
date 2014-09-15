package unq.tpi.persistencia;

public class Jugador {
	private String nombre;
	private String apellido;
	private int nroCamiseta;
	private Integer id;

	/**
	 * Es exclusivo para Hibernate no usar 
	 **/
	protected Jugador() {
	}
	
	public Jugador(String nombre, String apellido, Integer nroCamiseta){
		this.nombre = nombre;
		this.apellido = apellido;
		this.nroCamiseta = nroCamiseta;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getNroCamiseta() {
		return nroCamiseta;
	}

	public void setNroCamiseta(Integer nroCamiseta) {
		this.nroCamiseta = nroCamiseta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	@Override
	public String toString() {
		return "Jugador [nombre=" + nombre + ", apellido=" + apellido
				+ ", nroCamiseta=" + nroCamiseta + ", id=" + id + "]";
	}
	
}

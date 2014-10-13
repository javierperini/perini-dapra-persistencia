package unq.tpi.persistencia;



public class Usuario extends Entidad{
	
	private String nombre;
	
	protected Usuario(){
	}
	
	public Usuario(String nombre){
		super();
		this.setNombre(nombre);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	



}

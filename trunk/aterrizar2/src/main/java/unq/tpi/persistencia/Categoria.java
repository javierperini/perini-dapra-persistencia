package unq.tpi.persistencia;

public class Categoria extends Entidad{
	private int precio;
	private String nombre;

	protected Categoria() {
	}
	
	public Categoria(int precio, String nombre){
		this.setPrecio(precio);
		this.setNombre(nombre);
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;		
	}

	public String getNombre() {
		return nombre;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}
}

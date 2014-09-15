package unq.tpi.persistencia;

public class Categoria {
	private int precio;

	protected Categoria() {
	}
	
	public Categoria(int precio){
		this.setPrecio(precio);
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}
}

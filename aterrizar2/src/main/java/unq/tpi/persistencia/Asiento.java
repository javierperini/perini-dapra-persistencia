package unq.tpi.persistencia;


public class Asiento {
	int id;
	int nro;
	Categoria unaCategoria;
	Usuario cliente;
	
	protected Asiento() {
	}
	
	public Asiento(int nro, Categoria unaCategoria){
		this.nro = nro;
	}
	
	public int precioAsiento(){
		return this.unaCategoria.getPrecio();
	}
	
	public int getNro() {
		return nro;
	}

	public void setNro(int nro) {
		this.nro = nro;
	}

	public Usuario getCliente() {
		return cliente;
	}

	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}

	
}

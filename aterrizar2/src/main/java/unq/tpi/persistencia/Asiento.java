package unq.tpi.persistencia;


public class Asiento extends Entidad {
	
	int nro;
	Categoria unaCategoria;
	Usuario compradoPor;
	Boolean estaReservado;
	Usuario reservadoPor;
	
	
	public Usuario getReservadoPor() {
		return reservadoPor;
	}

	public void setReservadoPor(Usuario reservadoPor) {
		this.reservadoPor = reservadoPor;
	}

	protected Asiento() {
	}
	
	public Asiento(int nro, Categoria unaCategoria){
		this.nro = nro;
	}
	
	public Boolean getEstaReservado() {
		return estaReservado;
	}

	public void setEstaReservado(Boolean estaReservado) {
		this.estaReservado = estaReservado;
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

	public Usuario getCompradoPor() {
		return compradoPor;
	}

	public void setCompradoPor(Usuario cliente) {
		this.compradoPor = cliente;
	}

	public void reservarPor(Usuario unUsuario) {
		this.setEstaReservado(true);
		this.setReservadoPor(unUsuario);
	}

	
}
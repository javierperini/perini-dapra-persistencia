package unq.tpi.persistencia;


public class Asiento extends Entidad {
	
	int nro;
	Categoria unaCategoria;
	Usuario reservadoPor;
	private Tramo tramo;
	int precioPorCategoria;

	
	public int getPrecioPorCategoria() {
		return precioPorCategoria;
	}

	public void setPrecioPorCategoria(int precioPorCategoria) {
		this.precioPorCategoria = precioPorCategoria;
	}

	public Categoria getUnaCategoria() {
		return unaCategoria;
	}

	public void setUnaCategoria(Categoria unaCategoria) {
		this.unaCategoria = unaCategoria;
		this.setPrecioPorCategoria(this.unaCategoria.getPrecio());
	}


	public Usuario getReservadoPor() {
		return reservadoPor;
	}

	public void setReservadoPor(Usuario id) {
		this.reservadoPor = id;
	}

	protected Asiento() {
	}
	
	public Asiento(int nro){
		this.nro = nro;
	}
	
	public Asiento(int nro, Tramo miTramo){
		this.nro = nro;
		this.tramo = miTramo;
	}
	
	public Asiento(int nro, Tramo miTramo, Categoria miCategoria){
		this.nro = nro;
		this.tramo = miTramo;
		this.unaCategoria = miCategoria;
	}
	
	public void agregar(Categoria unaCategoria) {
		this.unaCategoria = unaCategoria;
	}
	
	public Boolean getEstaReservado() {
		return reservadoPor!=null;
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

	public void reservarPor(Usuario unUsuario) {
		this.setReservadoPor(unUsuario);
	}

	public Tramo getTramo() {
		return tramo;
	}

	public void setTramo(Tramo tramo) {
		this.tramo = tramo;
	}

	
}

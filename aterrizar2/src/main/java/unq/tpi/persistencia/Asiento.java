package unq.tpi.persistencia;


public class Asiento extends Entidad {
	
	int nro;
	Categoria unaCategoria;
	Usuario compradoPor;
	Boolean estaReservado;
	Usuario reservadoPor;
	private Tramo miTramo;
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

	public Tramo getMiTramo() {
		return miTramo;
	}

	public void setMiTramo(Tramo miTramo) {
		this.miTramo = miTramo;
	}

	public Usuario getReservadoPor() {
		return reservadoPor;
	}

	public void setReservadoPor(Usuario reservadoPor) {
		this.reservadoPor = reservadoPor;
	}

	protected Asiento() {
	}
	
	public Asiento(int nro){
		this.nro = nro;
	}
	
	public Asiento(int nro, Tramo miTramo){
		this.nro = nro;
		this.miTramo = miTramo;
	}
	
	public Asiento(int nro, Tramo miTramo, Categoria miCategoria){
		this.nro = nro;
		this.miTramo = miTramo;
		this.unaCategoria = miCategoria;
	}
	
	public void agregar(Categoria unaCategoria) {
		this.unaCategoria = unaCategoria;
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

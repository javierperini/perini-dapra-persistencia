package unq.tpi.persistencia;


public class Asiento extends Entidad {
	
	int nro;
	Categoria unaCategoria;
	Boolean estaReservado;
	int reservadoPor;
	int idTramo;
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

	public int getMiTramo() {
		return idTramo;
	}

	public void setMiTramo(int miTramo) {
		this.idTramo = miTramo;
	}

	public int getReservadoPor() {
		return reservadoPor;
	}

	public void setReservadoPor(int id) {
		this.reservadoPor = id;
	}

	protected Asiento() {
	}
	
	public Asiento(int nro){
		this.nro = nro;
	}
	
	public Asiento(int nro, int miTramo){
		this.nro = nro;
		this.idTramo = miTramo;
	}
	
	public Asiento(int nro, int miTramo, Categoria miCategoria){
		this.nro = nro;
		this.idTramo = miTramo;
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

	public void reservarPor(Usuario unUsuario) {
		this.setEstaReservado(true);
		this.setReservadoPor(unUsuario.id);
	}

	
}

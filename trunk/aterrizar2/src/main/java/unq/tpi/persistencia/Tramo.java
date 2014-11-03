package unq.tpi.persistencia;

import java.util.ArrayList;
import java.util.List;

public class Tramo extends Entidad{
	private String origen;
	private String destino;
	private int precio;
	private int horaLlegada;
	private int horaSalida;
	private int fechaLlegada;
	private int fechaSalida;
	private List<Asiento> asientos = new ArrayList<Asiento>();
	private Vuelo miVuelo; 
	private int duracionTramo;

	/**
	 * Es exclusivo para Hibernate no usar 
	 **/
	protected Tramo() {
	}
	
	public Tramo(String origen, String destino, Integer precio, int horaLlegada, int horaSalida,int fechaSalida ,int fechaLlegada){
		this.origen = origen;
		this.destino = destino;
		this.precio = precio;
		this.horaLlegada = horaLlegada;
		this.horaSalida = horaSalida;
		this.fechaLlegada = fechaLlegada;
		this.fechaSalida = fechaSalida;
		this.duracionTramo= this.calcularDuracion();
	}
	
	public Tramo(String origen, String destino, Integer precio, int horaLlegada, int horaSalida, Vuelo miVuelo,int fechaDeEntrada, int fechaSalida){
		this.origen = origen;
		this.destino = destino;
		this.precio = precio;
		this.horaLlegada = horaLlegada;
		this.horaSalida = horaSalida;
		this.miVuelo = miVuelo;
		this.fechaLlegada =fechaDeEntrada;
		this.fechaSalida = fechaSalida;
		this.duracionTramo= this.calcularDuracion();
		
	}
	
	private int calcularDuracion() {
		return (this.getFechaLlegada() -this.getFechaSalida())*24 + (this.getHoraLlegada()-this.getHoraSalida());
	}

	public Tramo(String origen, String destino, Integer precio, 
			int horaLlegada, int horaSalida, Vuelo miVuelo , List<Asiento> asientos, int fechaLlegada ,int fechaSalida){
		this.origen = origen;
		this.destino = destino;
		this.precio = precio;
		this.horaLlegada = horaLlegada;
		this.horaSalida = horaSalida;
		this.miVuelo = miVuelo;
		this.setAsientos(asientos);
		this.fechaLlegada = fechaLlegada;
		this.fechaSalida = fechaSalida;
		this.duracionTramo= this.calcularDuracion();
		
	}
	
	
	
	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}

	public Vuelo getMiVuelo() {
		return miVuelo;
	}

	public void setMiVuelo(Vuelo miVuelo) {
		this.miVuelo = miVuelo;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getApellido() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public int getHoraLlegada() {
		return horaLlegada;
	}

	public void setHoraLlegada(int horaLlegada) {
		this.horaLlegada = horaLlegada;
	}

	public int getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(int horaSalida) {
		this.horaSalida = horaSalida;
	}

	public List<Asiento> getAsientos() {
		return asientos;
	}

	public void setAsientos(List<Asiento> asientos) {
		this.asientos = asientos;
	}

	public void agregarAsiento(Asiento asiento){
		this.asientos.add(asiento);
	}
	@Override
	public String toString() {
		return "Tramo [origen=" + origen + ", destino=" + destino
				+ ", precio=" + precio + ", id=" + id + "]";
	}

	public String getDestino() {
		return destino;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(int fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public int getFechaLlegada() {
		return this.fechaLlegada;
	}

	public void setFechaLlegada(int fechaLlegada) {
		this.fechaLlegada = fechaLlegada;
	}

	public int getDuracionTramo() {
		return duracionTramo;
	}

	public void setDuracionTramo(int duracionVuelo) {
		this.duracionTramo = duracionVuelo;
	}
	
}

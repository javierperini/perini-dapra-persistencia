package unq.tpi.persistencia;

import java.util.ArrayList;
import java.util.List;

public class Tramo extends Entidad{
	private String origen;
	private String destino;
	private int precio;
	private int horaLlegada;
	private int horaSalida;
	//private int fechaLlegada;
	//private int fechaSalida;
	private List<Asiento> asientos = new ArrayList<Asiento>();
	private Vuelo miVuelo; 

	/**
	 * Es exclusivo para Hibernate no usar 
	 **/
	protected Tramo() {
	}
	
	public Tramo(String origen, String destino, Integer precio, int horaLlegada, int horaSalida){
		this.origen = origen;
		this.destino = destino;
		this.precio = precio;
		this.horaLlegada = horaLlegada;
		this.horaSalida = horaSalida;
		
	}
	
	public Tramo(String origen, String destino, Integer precio, int horaLlegada, int horaSalida, Vuelo miVuelo){
		this.origen = origen;
		this.destino = destino;
		this.precio = precio;
		this.horaLlegada = horaLlegada;
		this.horaSalida = horaSalida;
		this.miVuelo = miVuelo;
		//this.fechaLlegada =fechaDeEntrada;
		//this.fechaSalida = fechaSalida;
	}
	
	public Tramo(String origen, String destino, Integer precio, 
			int horaLlegada, int horaSalida, Vuelo miVuelo , List<Asiento> asientos){
		this.origen = origen;
		this.destino = destino;
		this.precio = precio;
		this.horaLlegada = horaLlegada;
		this.horaSalida = horaSalida;
		this.miVuelo = miVuelo;
		this.setAsientos(asientos);
		
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
/*
	public int getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(int fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public int getFechaDeEntrada() {
		return this.fechaLlegada;
	}

	public void setFechaDeEntrada(int fechaLlegada) {
		this.fechaLlegada = fechaLlegada;
	}
*/	
}

package unq.tpi.persistencia;

import java.util.List;

public class Tramo {
	private String origen;
	private String destino;
	private int precio;
	private Integer id;
	private int horaLlegada;
	private int horaSalida;
	private List<Asiento> asientos;

	/**
	 * Es exclusivo para Hibernate no usar 
	 **/
	protected Tramo() {
	}
	
	public Tramo(String origen, String destino, Integer precio, int horaLlegada, int horaSalida, List<Asiento> asientos){
		this.origen = origen;
		this.destino = destino;
		this.precio = precio;
		this.horaLlegada = horaLlegada;
		this.horaSalida = horaSalida;
		this.setAsientos(asientos);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
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

	@Override
	public String toString() {
		return "Tramo [origen=" + origen + ", destino=" + destino
				+ ", precio=" + precio + ", id=" + id + "]";
	}
	
}

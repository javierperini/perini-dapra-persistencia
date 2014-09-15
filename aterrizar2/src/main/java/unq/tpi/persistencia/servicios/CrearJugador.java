package unq.tpi.persistencia.servicios;

import unq.tpi.persistencia.Jugador;
import unq.tpi.persistencia.daos.JugadorDAO;

public class CrearJugador implements Operation<Jugador> {
	private String nombre;
	private String apellido;
	private Integer nro;

	public CrearJugador(String nombre, String apellido, Integer nro) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.nro = nro;
	}

	public Jugador execute() {
		Jugador j = new Jugador(nombre, apellido, nro);
		new JugadorDAO().save(j);
		return j;
	}
}

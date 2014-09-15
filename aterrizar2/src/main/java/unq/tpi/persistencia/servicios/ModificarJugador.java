package unq.tpi.persistencia.servicios;

import unq.tpi.persistencia.Jugador;
import unq.tpi.persistencia.daos.JugadorDAO;

public class ModificarJugador implements Operation<Jugador> {

	private String nombre;
	private int id;

	public ModificarJugador(int id,String nombre) {
		super();
		this.nombre = nombre;
		this.id = id;
	}


	public Jugador execute() {
		Jugador j = new JugadorDAO().get(id);
		j.setNombre(nombre);
		return j;
	}

}

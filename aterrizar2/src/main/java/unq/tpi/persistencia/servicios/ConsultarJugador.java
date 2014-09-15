package unq.tpi.persistencia.servicios;

import unq.tpi.persistencia.Jugador;
import unq.tpi.persistencia.daos.JugadorDAO;

public class ConsultarJugador implements Operation<Jugador>{

	private int id;
	
	public ConsultarJugador(int id) {
		super();
		this.id = id;
	}

	public Jugador execute() {
		Jugador j;
		j = new JugadorDAO().get(id);
		return j;
	}
}

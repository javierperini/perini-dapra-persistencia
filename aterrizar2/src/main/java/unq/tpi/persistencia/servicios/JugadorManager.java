package unq.tpi.persistencia.servicios;

import unq.tpi.persistencia.Jugador;
import unq.tpi.persistencia.daos.SessionManager;

public class JugadorManager {
	public Jugador consultarJugador(int id) {
		return SessionManager.runInSession(new ConsultarJugador(id));
	}

	public void crearJugador(String nombre, String apellido, int nro) {
		SessionManager.runInSession(new CrearJugador(nombre, apellido, nro));
	}

	public Jugador modificarNombre(int id, String nombre) {
		return SessionManager.runInSession(new ModificarJugador(id,nombre));
	}
}

package unq.tpi.persistencia.daos;

import unq.tpi.persistencia.Jugador;

public class JugadorDAO {
	public Jugador get(int id){
		return (Jugador)SessionManager.getSession().get(Jugador.class,id);
	}

	public void save(Jugador j) {
		SessionManager.getSession().saveOrUpdate(j);
	}
}

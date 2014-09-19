package unq.tpi.persistencia.servicios;

import unq.tpi.persistencia.daos.SessionManager;

public class Manager<T> {
		
		public T consultar(Operation<T>  consulta) {
			return SessionManager.runInSession(consulta);
		}

		public T crear(Operation<T>  consulta) {
			return SessionManager.runInSession(consulta);
		}

		public T modificar(Operation<T>  consulta) {
			return SessionManager.runInSession(consulta);
		}
	}



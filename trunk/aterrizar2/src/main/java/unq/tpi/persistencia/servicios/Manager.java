package unq.tpi.persistencia.servicios;

import java.util.List;

import org.hibernate.Query;

import unq.tpi.persistencia.Asiento;
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
		public Object session(String consulta){
			return	null;
		}

		public List<Asiento> query(String string) {
			Query q= SessionManager.getSession().createQuery(string);
			return q.list();
		}
	}



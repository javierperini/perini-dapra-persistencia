package unq.tpi.persistencia.servicios;

import java.util.List;

import org.hibernate.Query;

import unq.tpi.persistencia.Asiento;
import unq.tpi.persistencia.daos.SessionManager;

public class Manager<T> implements Operation<List<T>> {
		private String consulta;
		
		public Manager(){
			this.consulta="";
		}
		public Manager(String consulta){
			this.consulta=consulta;
		}
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
		
		public List<T> reservarAsiento() {
			Query q= SessionManager.getSession().createQuery(consulta);
			return q.list();
		}
}



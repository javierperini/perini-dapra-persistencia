package unq.tpi.persistencia.servicios.usuario;

import unq.tpi.persistencia.daos.EntidadDAO;
import unq.tpi.persistencia.servicios.Operation;

public class Crear<T> implements Operation<T>{

		private T entidad;

		public Crear(T entidad) {
			super();
			this.entidad = entidad;
		}

		public T execute() {
			new EntidadDAO(entidad.getClass()).save(entidad);
			return entidad;
		}
	}


package unq.tpi.persistencia.servicios.usuario;


import unq.tpi.persistencia.Usuario;
import unq.tpi.persistencia.daos.EntidadDAO;
import unq.tpi.persistencia.servicios.Operation;

public class Borrar<T> implements Operation<T> {

	private T entidad;
	
	public Borrar(T entidad) {
		super();
		this.entidad = entidad;
	}

	public T reservarAsiento() {
		new EntidadDAO(entidad.getClass()).delete(entidad);
		return entidad;
	}

}

package unq.tpi.persistencia.servicios.usuario;



import unq.tpi.persistencia.Entidad;
import unq.tpi.persistencia.Usuario;
import unq.tpi.persistencia.daos.EntidadDAO;
import unq.tpi.persistencia.servicios.Operation;

public class Consultar<T extends Entidad> implements Operation<T> {

	private T entidad;

	public Consultar(T entidad) {
		super();
		this.entidad = entidad;
	}

	public T reservarAsiento() {
		 new EntidadDAO(entidad.getClass()).get(entidad.getId());
		return entidad;
	}
}

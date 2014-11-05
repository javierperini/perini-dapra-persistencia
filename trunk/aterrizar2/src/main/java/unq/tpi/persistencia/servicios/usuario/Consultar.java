package unq.tpi.persistencia.servicios.usuario;



import unq.tpi.persistencia.Entidad;
import unq.tpi.persistencia.daos.EntidadDAO;
import unq.tpi.persistencia.servicios.Operation;

public class Consultar<T extends Entidad> implements Operation<T> {

	private Class<T> clase;
	private int id;

	public Consultar(Class<T> clase, int id) {
		super();
		this.clase = clase;
		this.id = id;
	}

	public T execute() {
		return new EntidadDAO<T>(clase).get(id);
	}
}

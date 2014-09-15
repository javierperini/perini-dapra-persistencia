package unq.tpi.persistencia.daos;

public class EntidadDAO<T> {
	
	private Class<T> entityType;

	public EntidadDAO(Class<T> entityType) {
		this.entityType = entityType;
	}
	public T get(int id){
		return (T)SessionManager.getSession().get(entityType,id);
	}

	public void save(T e) {
		SessionManager.getSession().saveOrUpdate(e);
	}
}

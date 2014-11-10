package unq.tpi.persistencia;

public class Entidad {
	Integer id;
	
	/**
	 * Superclase entidad
	 *   contiene los id de los objetos de las tablas
	 */
	public Entidad(){
		
	}
	
	public Integer getId(){
		return id;
	}
	
	public void setId(Integer i){
		this.id=i;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entidad other = (Entidad) obj;
		if (!id.equals(other.id)){
			return false;
		}
		return true;
	}
	

}

package unq.tpi.persistencia;

import java.math.BigDecimal;

public class Entidad {
	int id;
	
	/**
	 * Superclase entidad
	 *   contiene los id de los objetos de las tablas
	 */
	public Entidad(){
		
	}
	
	public int getId(){
		return id;
	}
	
	public void setId(int i){
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
		if (id != other.id)
			return false;
		return true;
	}
	

}

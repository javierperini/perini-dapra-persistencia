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

}

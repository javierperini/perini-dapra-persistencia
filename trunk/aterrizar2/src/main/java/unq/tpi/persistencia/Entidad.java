package unq.tpi.persistencia;

import java.math.BigDecimal;

public class Entidad {
	BigDecimal id;
	
	/**
	 * Superclase entidad
	 *   contiene los id de los objetos de las tablas
	 */
	public Entidad(){
		
	}
	
	public BigDecimal getId(){
		return id;
	}
	
	public void setId(BigDecimal i){
		this.id=i;
	}

}

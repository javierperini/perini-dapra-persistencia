package unq.tpi.persistencia.busquedas;

import unq.tpi.persistencia.Aerolinea;
import unq.tpi.persistencia.Categoria;

public class CriterioBusqueda extends Criterio {
	
	public CriterioBusqueda(String criterio) {
		super(criterio);
	}
	
	@Override
	public String getCriterio(){
		return "where "+ super.getCriterio();
	}
	
	
	// Metodos de manipulaci�n de los criterios
	
	@Override
	public void and(Criterio otroCriterio){
		criteriosComplementarios.add(new CriterioBusqueda(" and ".concat(otroCriterio.getCriterio())));
	}
		
	public void or(Criterio otroCriterio){
		criteriosComplementarios.add(new CriterioBusqueda(" or ".concat(otroCriterio.getCriterio())));
	}

	
	// Factory Methods para crear diferentes criterios de busqueda
	
	private static CriterioBusqueda armarCriterio (String condicion, String elementoAmatchear){
		return new CriterioBusqueda(condicion + elementoAmatchear);
	}
	
	public static CriterioBusqueda busquedaPorAerolinea(Aerolinea unaAerolinea){
		return armarCriterio ("idAerolinea = ", unaAerolinea.getId().toString());
	}
	
	public static CriterioBusqueda busquedaPorCategoriaDeAsiento(Categoria unaCategoria){
		return armarCriterio ("idCategoria = ", unaCategoria.getId().toString());
	}
	
	public static CriterioBusqueda busquedaPorFechaDeSalida(Integer unaFechaDeSalida){
		return armarCriterio ("fechaSalida = ", unaFechaDeSalida.toString());
	}
	
	public static CriterioBusqueda busquedaPorFechaDeLlegada(Integer unaFechaDeLlegada){
		return armarCriterio ("fechaLlegada = ", unaFechaDeLlegada.toString());
	}
		
	public static CriterioBusqueda busquedaPorOrigen(String unOrigen){
		return armarCriterio ("origen = ",  unOrigen);
	}
		
	public static CriterioBusqueda busquedaPorDestino(String unDestino){
		return armarCriterio ("destino = ",  unDestino);
	}
}

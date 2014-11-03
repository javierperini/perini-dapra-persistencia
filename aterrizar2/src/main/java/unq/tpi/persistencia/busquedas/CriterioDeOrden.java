package unq.tpi.persistencia.busquedas;

public class CriterioDeOrden extends Criterio {

	public CriterioDeOrden(String criterio) {
		super(criterio);		
	}
	
	@Override
	public String getCriterio(){
		return " group by idTramo  order by "+ super.getCriterio();
	}

	
	// Metodos de manipulaci�n de los criterios
	
	@Override
	public void and(Criterio otroCriterio) {
		criteriosComplementarios.add(new CriterioDeOrden(",".concat(otroCriterio.getCriterio())));	
	}
	
	
	// Factory Methods para crear diferentes criterios de busqueda
	
	private static CriterioDeOrden armarCriterio(String funcion, String columna ){
		return new CriterioDeOrden(funcion +" ( " + columna+ " ) ASC");
	}
	
	public static CriterioDeOrden ordernarPorDuracion(){
		return CriterioDeOrden.armarCriterio("sum","duracionTramo");
	}
	
	public static CriterioDeOrden ordernarPorMenorCosto(){
		return CriterioDeOrden.armarCriterio("count","idTramo");
	}
	
	public static CriterioDeOrden ordernarPorMenorCantidadDeEscalas(){
		return CriterioDeOrden.armarCriterio("sum","duracion");
	}	
}

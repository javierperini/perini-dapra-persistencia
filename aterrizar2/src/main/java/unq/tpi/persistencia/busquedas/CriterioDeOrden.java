package unq.tpi.persistencia.busquedas;

public class CriterioDeOrden extends Criterio {

	public CriterioDeOrden(){
		
	}
	
	public CriterioDeOrden(String criterio) {
		super(criterio);
		
	}

	@Override
	public void and(Criterio otroCriterio) {
		getCriteriosComplementarios().add(new CriterioDeOrden(",".concat(otroCriterio.getCriterioAEjecutarSinWhere())));	
	}
	
	private static CriterioDeOrden armarCriterio(String funcion, String columna ){
		return new CriterioDeOrden(funcion +" ( " + columna+ " ) ASC");
	}
	
	public static CriterioDeOrden ordernarPorDuracion(){
		return CriterioDeOrden.armarCriterio("sum","t.duracionTramo");
	}
	public static CriterioDeOrden ordernarPorMenorCosto(){
		return CriterioDeOrden.armarCriterio("sum","'t.idTramo'");
	}
	public static CriterioDeOrden ordernarPorMenorCantidadDeEscalas(){
		return CriterioDeOrden.armarCriterio("count","t");
	}
	
	public String getCriterioAEjecutar(){
		return " group by 't.idTramo'  order by "+ super.getCriterioAEjecutarSinWhere();
	}

	
}

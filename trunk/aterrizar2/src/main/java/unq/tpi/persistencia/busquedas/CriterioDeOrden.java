package unq.tpi.persistencia.busquedas;

public class CriterioDeOrden extends Criterio {

	public CriterioDeOrden(){
		
	}
	
	public CriterioDeOrden(String criterio) {
		super(criterio);
		
	}

	@Override
	public void and(Criterio otroCriterio) {
		getCriteriosComplementarios().add(new CriterioDeOrden(",".concat(otroCriterio.getCriterio())));	
	}
	
	private static CriterioDeOrden armarCriterio(String funcion, String columna ){
		return new CriterioDeOrden(funcion +" ( " + columna+ " ) ASC");
	}
	
	public static CriterioDeOrden ordernarPorDuracion(){
		return CriterioDeOrden.armarCriterio("sum","t.duracionTramo");
	}
	public static CriterioDeOrden ordernarPorMenorCosto(){
		return CriterioDeOrden.armarCriterio("count","t.idTramo");
	}
	public static CriterioDeOrden ordernarPorMenorCantidadDeEscalas(){
		return CriterioDeOrden.armarCriterio("sum","this.duracion");
	}
	@Override
	public String getCriterio(){
		return " group by idTramo  order by "+ super.getCriterio();
	}

	
}

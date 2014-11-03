package unq.tpi.persistencia.busquedas;

abstract class EstrategiaCriterioDeOrden extends EstrategiaCriterio{
	
	protected EstrategiaCriterioDeOrden(Busqueda busquedaActual) {
		super(busquedaActual);
	}
	
	protected abstract void and(CriterioDeOrden unCriterio);
}

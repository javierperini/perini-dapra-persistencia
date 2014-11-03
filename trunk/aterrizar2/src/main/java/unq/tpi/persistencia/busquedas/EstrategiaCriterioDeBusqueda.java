package unq.tpi.persistencia.busquedas;

abstract class EstrategiaCriterioDeBusqueda extends EstrategiaCriterio{
	
	protected EstrategiaCriterioDeBusqueda(Busqueda busquedaActual) {
		super(busquedaActual);
	}

	protected abstract void and(CriterioBusqueda unCriterio);
	
	protected abstract void or(CriterioBusqueda unCriterio);
}

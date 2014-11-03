package unq.tpi.persistencia.busquedas;

abstract class EstrategiaCriterio {
	
	protected Busqueda busquedaActual;
	
	public EstrategiaCriterio(Busqueda busquedaActual) {
		this.busquedaActual = busquedaActual;
	}

	protected abstract String getCriterio();
}

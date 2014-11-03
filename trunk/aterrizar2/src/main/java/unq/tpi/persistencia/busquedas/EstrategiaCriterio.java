package unq.tpi.persistencia.busquedas;

abstract class EstrategiaCriterio {
	
	public EstrategiaCriterio(Busqueda busquedaActual) {
		this.busquedaActual = busquedaActual;
	}

	protected Busqueda busquedaActual;
}

package unq.tpi.persistencia.busquedas;

class ConCriterioDeBusqueda extends EstrategiaCriterioDeBusqueda {

	protected ConCriterioDeBusqueda(Busqueda busquedaActual) {
		super(busquedaActual);
	}

	@Override
	protected void and(CriterioBusqueda unCriterio) {
		this.busquedaActual.andCriterioDeBusqueda(unCriterio);
	}

	@Override
	protected void or(CriterioBusqueda unCriterio) {
		this.busquedaActual.orCriterioDeBusqueda(unCriterio);
	}
	
	protected String getCriterio(){
		return this.busquedaActual.getCriterioDeBusqueda().getCriterio();
	}

}

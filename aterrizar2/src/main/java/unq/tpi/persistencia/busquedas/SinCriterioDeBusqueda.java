package unq.tpi.persistencia.busquedas;

class SinCriterioDeBusqueda extends EstrategiaCriterioDeBusqueda {

	protected SinCriterioDeBusqueda(Busqueda busquedaActual) {
		super(busquedaActual);
	}
	
	private void agregarCriterio(CriterioBusqueda unCriterio){
		this.busquedaActual.setCriterioDeBusqueda(unCriterio);
		this.busquedaActual.setEstrategiaCriterioDeBusqueda(new ConCriterioDeBusqueda(this.busquedaActual));
	}
	
	@Override
	protected void and(CriterioBusqueda unCriterio) {
		this.agregarCriterio(unCriterio);
	}

	@Override
	protected void or(CriterioBusqueda unCriterio) {
		this.agregarCriterio(unCriterio);
	}

	@Override
	protected String getCriterio() {
		return " ";
	}

}

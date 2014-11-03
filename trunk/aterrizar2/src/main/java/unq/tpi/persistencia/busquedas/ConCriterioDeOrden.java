package unq.tpi.persistencia.busquedas;

public class ConCriterioDeOrden extends EstrategiaCriterioDeOrden {

	protected ConCriterioDeOrden(Busqueda busquedaActual) {
		super(busquedaActual);
	}

	@Override
	protected void and(CriterioDeOrden unCriterio) {
		this.busquedaActual.andCriterioDeOrden(unCriterio);
	}

	@Override
	protected String getCriterio() {
		return this.busquedaActual.getCriterioDeOrden().getCriterio();
	}

}

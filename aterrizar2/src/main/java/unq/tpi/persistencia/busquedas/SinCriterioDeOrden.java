package unq.tpi.persistencia.busquedas;

public class SinCriterioDeOrden extends EstrategiaCriterioDeOrden {

	protected SinCriterioDeOrden(Busqueda busquedaActual) {
		super(busquedaActual);
	}

	@Override
	protected void and(CriterioDeOrden unCriterio) {
		this.busquedaActual.setCriterioDeOrden(unCriterio);
		this.busquedaActual.setEstrategiaCriterioDeOrden(new ConCriterioDeOrden(this.busquedaActual));
	}

	@Override
	protected String getCriterio() {
		return " ";
	}
}

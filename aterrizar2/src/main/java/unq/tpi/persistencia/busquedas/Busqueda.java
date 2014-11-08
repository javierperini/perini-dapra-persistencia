package unq.tpi.persistencia.busquedas;

import unq.tpi.persistencia.Entidad;
import unq.tpi.persistencia.Usuario;

public class Busqueda extends Entidad {

	private CriterioBusqueda criterioDeBusqueda;
	private CriterioDeOrden criterioDeOrden;
	private EstrategiaCriterioDeBusqueda estrategiaCriterioDeBusqueda;
	private EstrategiaCriterioDeOrden estrategiaCriterioDeOrden;
	private String query;
	private Usuario usuario;
	
	public EstrategiaCriterioDeBusqueda getEstrategiaCriterioDeBusqueda() {
		return estrategiaCriterioDeBusqueda;
	}

	public EstrategiaCriterioDeOrden getEstrategiaCriterioDeOrden() {
		return estrategiaCriterioDeOrden;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Busqueda (Usuario usuario){
		this.usuario = usuario;
		this.query = " ";
		this.setEstrategiaCriterioDeBusqueda(new SinCriterioDeBusqueda(this));
		this.setEstrategiaCriterioDeOrden(new SinCriterioDeOrden(this));
	}

	protected void setEstrategiaCriterioDeBusqueda(EstrategiaCriterioDeBusqueda estrategia){
		this.estrategiaCriterioDeBusqueda = estrategia;
	}
	
	protected void setEstrategiaCriterioDeOrden(EstrategiaCriterioDeOrden estrategia){
		this.estrategiaCriterioDeOrden = estrategia;
	}
	
	public CriterioBusqueda getCriterioDeBusqueda() {
		return criterioDeBusqueda;
	}

	protected void setCriterioDeBusqueda(CriterioBusqueda criterioDeBusqueda) {
		this.criterioDeBusqueda = criterioDeBusqueda;
	}

	public CriterioDeOrden getCriterioDeOrden() {
		return criterioDeOrden;
	}

	protected void setCriterioDeOrden(CriterioDeOrden criteriosDeOrden) {
		this.criterioDeOrden = criteriosDeOrden;
	}

	
	// Metodos de modificacion de los criterios de busqueda y de orden
	
	public void andCriterio(CriterioBusqueda nuevoCriterio){
		estrategiaCriterioDeBusqueda.and(nuevoCriterio);
	}
	
	protected void andCriterioDeBusqueda(CriterioBusqueda nuevoCriterio){
		this.criterioDeBusqueda.and(nuevoCriterio);
	}
	
	public void orCriterio(CriterioBusqueda nuevoCriterio){
		estrategiaCriterioDeBusqueda.or(nuevoCriterio);
	}
	
	protected void orCriterioDeBusqueda(CriterioBusqueda nuevoCriterio){
		this.criterioDeBusqueda.or(nuevoCriterio);
	}
	
	public void andCriterio(CriterioDeOrden nuevoCriterio){
		estrategiaCriterioDeOrden.and(nuevoCriterio);
	}
	
	protected void andCriterioDeOrden(CriterioDeOrden nuevoCriterio){
		this.criterioDeOrden.and(nuevoCriterio);
	}
	
	
	// Otros metodos
	
	public void armarBusqueda(){
		this.query = this.query.concat(this.estrategiaCriterioDeBusqueda.getCriterio());
		this.query = this.query.concat(this.estrategiaCriterioDeOrden.getCriterio());
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public String getQuery(){
		return this.query;
	}
}

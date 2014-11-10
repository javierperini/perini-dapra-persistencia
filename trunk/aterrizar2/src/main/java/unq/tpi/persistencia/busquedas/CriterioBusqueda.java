package unq.tpi.persistencia.busquedas;

import unq.tpi.persistencia.Aerolinea;
import unq.tpi.persistencia.Categoria;
import unq.tpi.persistencia.Entidad;

public class CriterioBusqueda extends Criterio {
	
	public CriterioBusqueda() {
	}
	
	public CriterioBusqueda(String criterio) {
		super(criterio);
	}
	
	@Override
	public void and(Criterio otroCriterio){
		getCriteriosComplementarios().add(new CriterioBusqueda(" and ".concat(otroCriterio.getCriterioAEjecutarSinWhere())));
	}
	
	
	public String getCriterioAEjecutar(){
		return "where "+ getCriterioAEjecutarSinWhere();
	}
	
	public void or(Criterio otroCriterio){
		getCriteriosComplementarios().add(new CriterioBusqueda(" or ".concat(otroCriterio.getCriterioAEjecutarSinWhere())));
		
	}

	
	// Factory Methods para crear diferentes criterios de busqueda
	
		private static CriterioBusqueda armarCriterio (String condicion, String elementoAmatchear){
			return new CriterioBusqueda(condicion + elementoAmatchear);
		}
		
		public static CriterioBusqueda busquedaPorAerolinea(Aerolinea unaAerolinea){
			return armarCriterio ("aerolinea.nombre = '", unaAerolinea.getNombre() +"'");
		}
		
		public static CriterioBusqueda busquedaPorCategoriaDeAsiento(Categoria unaCategoria){
			return armarCriterio ("categoria.nombre = '", unaCategoria.getNombre() +"'") ;
		}
		
		public static CriterioBusqueda busquedaPorFechaDeSalida(Integer unaFechaDeSalida){
			return armarCriterio ("t.fechaSalida = '", unaFechaDeSalida.toString() +"'" );
		}
		
		public static CriterioBusqueda busquedaPorFechaDeLlegada(Integer unaFechaDeLlegada){
			return armarCriterio ("t.fechaLlegada = '", unaFechaDeLlegada.toString() +"'");
		}
		
		public static CriterioBusqueda busquedaPorOrigen(String unOrigen){
			return armarCriterio ("t.origen = '",  unOrigen +"'");
		}
		
		public static CriterioBusqueda busquedaPorDestino(String unDestino){
			return armarCriterio ("t.destino = '",  unDestino +"'");
		}
		


}

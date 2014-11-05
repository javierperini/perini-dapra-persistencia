package unq.tpi.persistencia.busquedas;

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
		getCriteriosComplementarios().add(new CriterioBusqueda(" and ".concat(otroCriterio.getCriterio())));
	}
	
	@Override
	public String getCriterio(){
		return "where "+ super.getCriterio();
	}
	
	public void or(Criterio otroCriterio){
		getCriteriosComplementarios().add(new CriterioBusqueda(" or ".concat(otroCriterio.getCriterio())));
		
	}

	
	// Factory Methods para crear diferentes criterios de busqueda
	
		private static CriterioBusqueda armarCriterio (String condicion, String elementoAmatchear){
			return new CriterioBusqueda(condicion + elementoAmatchear);
		}
		
		public static CriterioBusqueda busquedaPorAerolinea(Entidad unaAerolinea){
			return armarCriterio ("this.idAerolinea = ", unaAerolinea.getId().toString());
		}
		
		public static CriterioBusqueda busquedaPorCategoriaDeAsiento(Categoria unaCategoria){
			return armarCriterio ("idCategoria = ", unaCategoria.getId().toString());
		}
		
		public static CriterioBusqueda busquedaPorFechaDeSalida(Integer unaFechaDeSalida){
			return armarCriterio ("fechaSalida = ", unaFechaDeSalida.toString());
		}
		
		public static CriterioBusqueda busquedaPorFechaDeLlegada(Integer unaFechaDeLlegada){
			return armarCriterio ("fechaLlegada = ", unaFechaDeLlegada.toString());
		}
		
		public static CriterioBusqueda busquedaPorOrigen(String unOrigen){
			return armarCriterio ("origen = ",  unOrigen);
		}
		
		public static CriterioBusqueda busquedaPorDestino(String unDestino){
			return armarCriterio ("destino = ",  unDestino);
		}
		


}

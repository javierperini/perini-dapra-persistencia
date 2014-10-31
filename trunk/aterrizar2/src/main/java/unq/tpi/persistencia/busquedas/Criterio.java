package unq.tpi.persistencia.busquedas;

import java.util.ArrayList;
import java.util.List;

import exceptions.NoSePuedeEliminarCriterioDeBusquedaException;
import unq.tpi.persistencia.Aerolinea;
import unq.tpi.persistencia.Categoria;
import unq.tpi.persistencia.Entidad;

public class Criterio extends Entidad {
	
	private String criterio;
	private List<Criterio> criteriosComplementarios = new ArrayList<Criterio>();

	private Criterio(String criterio){
		this.criterio = criterio;
	}
	
	public String getCriterio(){
		String criterios = this.criterio;
		for(Criterio c: this.criteriosComplementarios){
			criterios = criterios.concat(c.getCriterio());
		}
		return criterios;
	}
	
	// Metodos de manipulaci�n de los criterios
	
	public void and(Criterio otroCriterio){
		criteriosComplementarios.add(otroCriterio.and());
	}
	
	public void or(Criterio otroCriterio){
		criteriosComplementarios.add(otroCriterio.or());
	}
	
	private Criterio and(){
		return new Criterio(" and ".concat(this.criterio));
	}
	
	private Criterio or(){
		return new Criterio(" or ".concat(this.criterio));
	}

	public void removeLast() throws NoSePuedeEliminarCriterioDeBusquedaException{
		try{
			criteriosComplementarios.remove(criteriosComplementarios.size() - 1);
		}
		catch (IndexOutOfBoundsException e) {
			throw new NoSePuedeEliminarCriterioDeBusquedaException();
		}
	}
	
	// Factory Methods para crear diferentes criterios de busqueda
	
	public static Criterio busquedaPorAerolinea(Aerolinea unaAerolinea){
		return new Criterio("aerolinea = ".concat(unaAerolinea.getNombre()));
	}
	
	public static Criterio busquedaPorCategoriaDeAsiento(Categoria unaCategoria){
		return new Criterio("categoria = ".concat(unaCategoria.getNombre()));
	}
	
	public static Criterio busquedaPorFechaDeSalida(Integer unaFechaDeSalida){
		return new Criterio("fechaDeSalida = ".concat(unaFechaDeSalida.toString()) );
	}
	
	public static Criterio busquedaPorFechaDeLlegada(Integer unaFechaDeLlegada){
		return new Criterio("fechaDeLlegada = ".concat(unaFechaDeLlegada.toString()));
	}
	
	public static Criterio busquedaPorOrigen(String unOrigen){
		return new Criterio("");
	}
	
	public static Criterio busquedaPorDestino(String unDestino){
		return new Criterio("");
	}
	
	
	public static void main(String args[]){
		Criterio c = new Criterio("criterio1");
		Criterio d = new Criterio("criterio2");
		Criterio e = new Criterio("criterio3");
		c.and(d);
		c.or(e);
		c.and(busquedaPorAerolinea(new Aerolinea("LAN")));
		
		System.out.println(c.getCriterio());
	}
	
}

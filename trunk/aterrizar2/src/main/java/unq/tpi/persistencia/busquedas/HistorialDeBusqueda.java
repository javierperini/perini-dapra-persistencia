package unq.tpi.persistencia.busquedas;

import java.util.ArrayList;
import java.util.List;

public class HistorialDeBusqueda {

	private List<String> historial;
	
	public HistorialDeBusqueda(){
		this.historial= new ArrayList<String>();
	}

	public void agregar(String query) {
		this.historial.add(query);		
	}
	
	public String pedir(int i){
		return this.historial.get(i);
	}

}

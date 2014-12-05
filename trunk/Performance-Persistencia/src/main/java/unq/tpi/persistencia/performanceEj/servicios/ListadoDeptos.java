package unq.tpi.persistencia.performanceEj.servicios;

import java.util.List;

import unq.tpi.persistencia.performanceEj.daos.DepartmentDAO;
import unq.tpi.persistencia.performanceEj.daos.ElementosDeOtroFiltro;
import unq.tpi.persistencia.performanceEj.model.Department;

public class ListadoDeptos extends AbstractListado {

	@Override
	protected String getFilename() {
		return "./target/Deptos.csv";
	}

	@Override
	protected void doListado() throws Exception {
		List<ElementosDeOtroFiltro> numeroNombreYManagerDelDepto = new DepartmentDAO().getNumeroNombreYManagerDelDepto();
		
		this.addColumn("Codigo").addColumn("Nombre").addColumn("Manager").newLine();
		
		for(ElementosDeOtroFiltro e: numeroNombreYManagerDelDepto){
			addColumn(e.getNroDepto());
			addColumn(e.getNombreDepto());
			//addColumn(e.getNombreManager());
			newLine();
		}
	}

}

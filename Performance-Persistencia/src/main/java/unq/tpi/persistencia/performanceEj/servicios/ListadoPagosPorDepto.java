package unq.tpi.persistencia.performanceEj.servicios;

import java.util.ArrayList;
import java.util.List;

import unq.tpi.persistencia.performanceEj.daos.DepartmentDAO;
import unq.tpi.persistencia.performanceEj.model.Department;
import unq.tpi.persistencia.performanceEj.model.ElementosDeUnFiltro;

public class ListadoPagosPorDepto extends AbstractListado {

	private String num;
	private Department depto = null;
	private List<ElementosDeUnFiltro> elem = new ArrayList<ElementosDeUnFiltro>();

	public ListadoPagosPorDepto(String num) {
		this.num = num;
	}

	@Override
	protected void doListado() throws Exception {
		
		elem = new DepartmentDAO().getByCodeFullNameTitleAndSalary(num);
		//depto = new DepartmentDAO().getByCode(num);

		this.newLine();
		//this.addColumn("Total").addColumn(depto.getTotalSalaries()).newLine();
		
		double suma = 0.0;
		for (ElementosDeUnFiltro e : elem){
			suma += e.getAmount();
		}
		
		System.out.println(suma);
		
		this.addColumn("Total").addColumn(suma).newLine();
		this.newLine();
		
		this.addColumn("Nombre Completo");
		this.addColumn("Titulo");
		this.addColumn("Monto");
		this.newLine();
		
		
		for (ElementosDeUnFiltro e : elem) {
			this.addColumn(e.fullName());
			this.addColumn("");
			this.addColumn(e.getAmount());
			this.newLine();
		}
		
	}

	@Override
	public String getFilename() {
		return "./target/PagosPorDepto.csv";
	}
}

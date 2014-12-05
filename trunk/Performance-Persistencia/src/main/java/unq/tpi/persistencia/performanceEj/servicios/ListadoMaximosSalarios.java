package unq.tpi.persistencia.performanceEj.servicios;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import unq.tpi.persistencia.performanceEj.daos.EmployeeDAO;
import unq.tpi.persistencia.performanceEj.model.Employee;

public class ListadoMaximosSalarios extends AbstractListado{

	@Override
	protected String getFilename() {
		return "./target/MaximosSalarios.csv";
	}

	@Override
	protected void doListado() throws Exception {
//		List<Employee> empleados = new EmployeeDAO().getMaximosSalarios();
//		
//		
//		addColumn("Nombre").addColumn("Sueldo").newLine();
//		
//		for(int i=0;i<10;i++){
//			Employee e = empleados.get(i);
//			addColumn(e.getFullName()).addColumn(e.getSalary()).newLine();
//		}
		
		
		List<Employee> empleados = new EmployeeDAO().getMaximosSalarios();
	
		addColumn("Nombre").addColumn("Sueldo").newLine();
		
		for(Employee employe:empleados){
			addColumn(employe.getFirstName()).addColumn(employe.getMaxSalary()).newLine();
		}
		
		
	}

}

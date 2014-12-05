package unq.tpi.persistencia.performanceEj.servicios;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import unq.tpi.persistencia.performanceEj.daos.DepartmentDAO;
import unq.tpi.persistencia.performanceEj.daos.EmpleadosConUnFiltro;
import unq.tpi.persistencia.performanceEj.daos.EmployeeDAO;
import unq.tpi.persistencia.performanceEj.model.Department;
import unq.tpi.persistencia.performanceEj.model.Employee;
import unq.tpi.persistencia.performanceEj.model.Salary;

public class ListadoDetalleEmpleado extends AbstractListado {

	private int num;
	
	public ListadoDetalleEmpleado(int num) {
		super();
		this.num = num;
	}

	@Override
	protected String getFilename() {
		return "./target/DetalleEmpleado-" + num +  ".csv";
	}

	@Override
	protected void doListado() throws Exception {
		Employee e = new EmployeeDAO().getByCode(num);
		Department nombreDepto = e.getDepartment();
		String depto = e.getDepartment().getNumber();
		String manager = e.getDepartment().getManager().getFullName();
		
		addColumn("Codigo").addColumn(num).newLine();
		addColumn("Nombre").addColumn(e.getFirstName()).newLine();
		addColumn("Departamento").addColumn(e.getDepartment().getName()).newLine();
		addColumn("Manager").addColumn(e.getDepartment().getManager().getFullName()).newLine();
		addColumn("Salario Actual").addColumn(e.getSalary()).newLine();
		addColumn("Cargo").addColumn(e.getTitle()).newLine();
		
		
//		addColumn("Codigo").addColumn(e.getId()).newLine();
//		addColumn("Nombre").addColumn(e.getFirstName()).newLine();
//		addColumn("Departamento").addColumn(e.getDepartment().getName()).newLine();
//		addColumn("Manager").addColumn(e.getDepartment().getManager().getFullName()).newLine();
//		addColumn("Salario Actual").addColumn(e.getSalary()).newLine();
//		addColumn("Cargo").addColumn(e.getTitle()).newLine();
		newLine();
		
		addColumn("Salario Historico").newLine();
		
		addColumn("Salario").addColumn("Desde").addColumn("Hasta").newLine();
		for(Salary s:e.getSalaries()){
			addColumn(s.getAmount());
			addColumn(s.getFrom());
			addColumn(s.getTo());
			newLine();
		}
		
		
		//Employee e = (Employee)new EmployeeDAO().getByCode(num);
//		EmpleadosConUnFiltro e = new EmployeeDAO().getByCode2(num);
//		
//		addColumn("Codigo").addColumn(e.getCodigo()).newLine();
//		addColumn("Nombre").addColumn(e.getNombre()).newLine();
//		addColumn("Departamento").addColumn(e.getDepartamento()).newLine();
//		addColumn("Manager").addColumn(e.getManager()).newLine();
//		//addColumn("Salario Actual").addColumn(e.getLastSalary()).newLine();
//		addColumn("Cargo").addColumn(e.getCargo()).newLine();
//		newLine();
//		
//		addColumn("Salario Historico").newLine();
//		
//		addColumn("Salario").addColumn("Desde").addColumn("Hasta").newLine();
////		for(Salary s:e.getSalarios()){
////			addColumn(s.getAmount());
////			addColumn(s.getFrom());
////			addColumn(s.getTo());
////			newLine();
////		}
		
		
	}
		
	private void addColumn(Date date) {
		try {
			this.addColumn(new SimpleDateFormat("dd-MM-yyyy").format(date));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}

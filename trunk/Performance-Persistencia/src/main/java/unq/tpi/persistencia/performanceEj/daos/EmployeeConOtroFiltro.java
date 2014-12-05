package unq.tpi.persistencia.performanceEj.daos;

import java.util.Date;
import java.util.List;
import java.util.Set;

import unq.tpi.persistencia.performanceEj.model.Gender;
import unq.tpi.persistencia.performanceEj.model.Salary;

public class EmployeeConOtroFiltro {

	private int idEmpleado;
	private Date fechaNacimiento;
	private Gender genero;
	private Date fechaContratacion;
	private int cantidadDeptos;
	private int cantidadDeptosHistoricos;
	private Set<String> titulos;
	private List<String> titulosHistoricos;
	private List<Salary> salaries;


	public EmployeeConOtroFiltro(int idEmpleado, Date fechaNacimiento,
			Gender genero, Date fechaContratacion, int cantidadDeptos,
			int cantidadDeptosHistoricos, Set<String> titulos, List<String> titulosHistoricos,
			List<Salary> salaries) {
		super();
		this.idEmpleado = idEmpleado;
		this.fechaNacimiento = fechaNacimiento;
		this.genero = genero;
		this.fechaContratacion = fechaContratacion;
		this.cantidadDeptos = cantidadDeptos;
		this.cantidadDeptosHistoricos = cantidadDeptosHistoricos;
		this.titulos = titulos;
		this.setTitulosHistoricos(titulosHistoricos);
		this.salaries = salaries;
	}

	public String getTitulo(){
		if(this.getTitulos().isEmpty())
			return null;
		
		return this.getTitulos().iterator().next();
	}
	
	public Double getSalary(){
		return this.getSalaries().get(this.getSalaries().size()-1).getAmount();
	}
	
	public int getIdEmpleado() {
		return idEmpleado;
	}


	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}


	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}


	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


	public Gender getGenero() {
		return genero;
	}


	public void setGenero(Gender genero) {
		this.genero = genero;
	}


	public Date getFechaContratacion() {
		return fechaContratacion;
	}


	public void setFechaContratacion(Date fechaContratacion) {
		this.fechaContratacion = fechaContratacion;
	}


	public int getCantidadDeptos() {
		return cantidadDeptos;
	}


	public void setCantidadDeptos(int cantidadDeptos) {
		this.cantidadDeptos = cantidadDeptos;
	}


	public int getCantidadDeptosHistoricos() {
		return cantidadDeptosHistoricos;
	}


	public void setCantidadDeptosHistoricos(int cantidadDeptosHistoricos) {
		this.cantidadDeptosHistoricos = cantidadDeptosHistoricos;
	}


	public Set<String> getTitulos() {
		return titulos;
	}


	public void setTitulos(Set<String> titulos) {
		this.titulos = titulos;
	}


	public List<Salary> getSalaries() {
		return salaries;
	}


	public void setSalaries(List<Salary> salaries) {
		this.salaries = salaries;
	}

	public List<String> getTitulosHistoricos() {
		return titulosHistoricos;
	}

	public void setTitulosHistoricos(List<String> titulosHistoricos) {
		this.titulosHistoricos = titulosHistoricos;
	}

	

}

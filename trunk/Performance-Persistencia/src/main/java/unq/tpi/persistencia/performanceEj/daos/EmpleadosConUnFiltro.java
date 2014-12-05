package unq.tpi.persistencia.performanceEj.daos;

import java.util.List;

import unq.tpi.persistencia.performanceEj.model.Salary;

public class EmpleadosConUnFiltro {

	private int codigo;
	private String nombre;
	private String departamento;
	private String cargo;
	private String manager;

	
	public EmpleadosConUnFiltro(int codigo, String nombre, String departamento,
			String cargo, String manager) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.departamento = departamento;
		this.cargo = cargo;
		this.manager = manager;
	}


	public int getCodigo() {
		return codigo;
	}		
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamentos) {
		this.departamento = departamentos;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}
}

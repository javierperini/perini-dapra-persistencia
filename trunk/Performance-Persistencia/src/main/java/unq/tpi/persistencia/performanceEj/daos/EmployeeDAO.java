package unq.tpi.persistencia.performanceEj.daos;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;

import unq.tpi.persistencia.performanceEj.model.Department;
import unq.tpi.persistencia.performanceEj.model.ElementosDeUnFiltro;
import unq.tpi.persistencia.performanceEj.model.Employee;
import unq.tpi.persistencia.performanceEj.model.Gender;
import unq.tpi.persistencia.performanceEj.model.Salary;
import unq.tpi.persistencia.util.SessionManager;

public class EmployeeDAO {

	public Employee getByName(final String name, final String lastName) {
	//public EmployeeConOtroFiltro getByName(final String name, final String lastName) {
		Session session = SessionManager.getSession();
		return (Employee) session
				.createQuery(
						"from Employee where firstName = :name and lastName = :lastName").setCacheable(true)
				.setParameter("name", name).setParameter("lastName", lastName)
				.uniqueResult();
		
//		return (EmployeeConOtroFiltro) SessionManager.getSession()
//		.createQuery("select new EmployeeConOtroFiltro(emp.id as idEmpleado , emp.birthDate as fechaNacimiento, "
//				+ "emp.gender as genero, emp.hireDate as fechaContratacion, count(d) as cantidadDeptos, "
//				+ "count(hd) as cantidadDeptosHistoricos, "
//				+ "titulos, " +
//				"titulosHistoricos, "
//				+ "salaries) " +
//				"from Employee emp " +
//				"join emp.departments d " +
//				"join emp.historicDepartments hd " +
//				"join emp.titles titulos "+
//				"join emp.historicTitles titulosHistoricos " + 
//				"join emp.salaries salaries " +
//				"where emp.salaries.to = '9999-01-01' and emp.firstName = :firstName and emp.lastName = :lastName ").setCacheable(true)
//				.setParameter("firstName", name).setParameter("lastName", lastName)
//				.uniqueResult();
	}
		
//	assertEquals(11052, e.getId());
//	assertEquals(sdf.parse("1960-03-16"), e.getBirthDate());
//	assertEquals(Gender.F, e.getGender());
//	assertEquals(sdf.parse("1988-11-11"), e.getHireDate());
//	assertEquals(0,e.getDepartments().size());
//	assertNull(e.getDepartment());
//	assertEquals(2,e.getHistoricDepartments().size());
//	assertNull(e.getTitle());					
//	assertEquals(1,e.getHistoricTitles().size());	
//	assertEquals(51339.0, e.getSalary());
	
	
	
	@SuppressWarnings("unchecked")
	public List<Employee> getMaximosSalarios() {
		Session session = SessionManager.getSession();
		return (List<Employee>) session
				.createQuery("select new Employee(emp.firstName, s.amount) " +
				"from Employee emp " +
				"inner join emp.salaries s " +
				"where s.to = '9999-01-01' " +
				"order by s.amount desc").setMaxResults(10)
				.list();
	}

	
	
	@SuppressWarnings("unchecked")
	public List<Employee> getAll() {
		Session session = SessionManager.getSession();
		return session.createCriteria(Employee.class).list();
	}

	public Employee getByCode (int id) {
		Session session = SessionManager.getSession();
		return (Employee) session.load(Employee.class, id);
	}
	
	public EmpleadosConUnFiltro getByCode2(int unId) {
		Session session = SessionManager.getSession();
		
//		return (EmpleadosConUnFiltro) session
//				.createQuery(
//						"select new EmpleadosConUnFiltro(e.id, e.firstName, d.name , "
//						+ "m.firstName) "
//						+ "from Department as d "
//						+ "join d.employees e "
//						+ "join d.managers m "
//						+ "where e.id = :unId ").setCacheable(true)
//				.setParameter("unId", unId)
//				.uniqueResult();
		
		
		
//		
		
		
		// Separar consulta de cosas con la consulta de salario, la de salario, me da una
		// lista de retorno...
		
		
		return (EmpleadosConUnFiltro) session.createCriteria(Employee.class)
				.add(Restrictions.eq("id",unId))
				.setFetchMode("titles", FetchMode.JOIN)
				.createAlias("departments", "departamentos")
				.createAlias("departamentos.managers", "manager")
				.setProjection(( Projections.projectionList()
						.add( Projections.property("id"),"codigo")
						.add( Projections.property("firstName"), "nombre" )	
						.add(Projections.property("departamentos.name"), "departamento" )
						.add(Projections.property("titles"),"cargo")
						.add(Projections.property("manager.firstName"),"manager")
				))						
				.uniqueResult();
		//return null;
		
		
	}
	

	
	
	
	
	
	
	
	

}

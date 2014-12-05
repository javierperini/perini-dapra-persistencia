package unq.tpi.persistencia.performanceEj.daos;

import java.util.Date;
import java.util.List;

import org.hibernate.FetchMode;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;

import unq.tpi.persistencia.performanceEj.model.Department;
import unq.tpi.persistencia.performanceEj.model.ElementosDeUnFiltro;
import unq.tpi.persistencia.util.SessionManager;

public class DepartmentDAO {

	public Department getByName(final String name) {
		Session session = SessionManager.getSession();
		return (Department) session
				.createQuery("from Department where name = :name").setCacheable(true)
				.setParameter("name", name).uniqueResult();
	}

	public Department getByCode(String num) {
		Session session = SessionManager.getSession();
		return (Department) session.get(Department.class, num);
	}

	

	public List<ElementosDeUnFiltro> getByCodeFullNameTitleAndSalary(String num) {
		Session session = SessionManager.getSession();		
		return (List<ElementosDeUnFiltro>) session.createCriteria(Department.class)
				.add(Restrictions.eq("number",num))
				//.setFetchMode("employees", FetchMode.JOIN)
				//.setFetchMode("employees.salaries", FetchMode.JOIN)
				//.setFetchMode("employees.titles", FetchMode.JOIN)
				.createAlias("employees", "employee")
				.createAlias("employee.salaries", "salarios")
//				.add(Restrictions.eq("salarios.to", "9999-01-01"))
				.setProjection(Projections.projectionList()
						.add(Projections.property("employee.firstName"),"firstName")
						.add(Projections.property("employee.lastName"),"lastName")
						//.add(Projections.property("employee.titles"),"titles")
						.add(Projections.property("salarios.amount"),"amount"))
				.setResultTransformer(Transformers.aliasToBean(ElementosDeUnFiltro.class))
				.list();
	}


	public List<ElementosDeOtroFiltro> getNumeroNombreYManagerDelDepto() {		
		Session session = SessionManager.getSession();
		return (List<ElementosDeOtroFiltro>) session.createCriteria(Department.class)
				.setProjection( Projections.projectionList()
				.add( Projections.property("number"),"nroDepto")
				.add( Projections.property("name"), "nombreDepto" ))			
				.setResultTransformer(Transformers.aliasToBean(ElementosDeOtroFiltro.class)).list();
	}


}

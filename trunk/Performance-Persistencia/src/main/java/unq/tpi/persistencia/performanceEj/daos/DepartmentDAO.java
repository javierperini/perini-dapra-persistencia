package unq.tpi.persistencia.performanceEj.daos;

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

	@SuppressWarnings("unchecked")
	public List<Department> getAll() {
		Session session = SessionManager.getSession();
		return session.createCriteria(Department.class).list();
	}

	public ElementosDeUnFiltro getByCodeFullNameTitleAndSalary(String num) {
		Session session = SessionManager.getSession();		
		return (ElementosDeUnFiltro) session.createCriteria(Department.class)
				.add(Restrictions.eq("number",num))
				.setFetchMode("employees", FetchMode.JOIN)
				.setFetchMode("employees.salaries", FetchMode.JOIN)
				.setFetchMode("employees.titles", FetchMode.JOIN)
				.createAlias("employees", "employee")
				.createAlias("employee.salaries", "salarios")
				.setProjection(Projections.projectionList()
						.add(Projections.property("employee.firstName"),"firstName")
						.add(Projections.property("employee.titles"),"titles")
						.add(Projections.property("salarios.amount")))
				.setResultTransformer(Transformers.aliasToBean(ElementosDeUnFiltro.class))
			    .uniqueResult();
	}

}

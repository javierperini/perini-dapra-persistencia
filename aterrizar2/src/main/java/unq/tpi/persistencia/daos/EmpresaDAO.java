package unq.tpi.persistencia.daos;

import unq.tpi.persistencia.Empresa;

public class EmpresaDAO {
	public Empresa get(int id){
		return (Empresa)SessionManager.getSession().get(Empresa.class,id);
	}

	public void save(Empresa e) {
		SessionManager.getSession().saveOrUpdate(e);
	}
}

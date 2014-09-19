package unq.tpi.persistencia;

import unq.tpi.persistencia.servicios.CrearUsuario;
import unq.tpi.persistencia.servicios.Manager;

public abstract class SetUpCliente extends AbstractHibernateTest{
	
	Usuario usuario ; 
	
	public void setUp(){
		CrearUsuario consulta= new CrearUsuario("usuario");
		usuario = new Manager<Usuario>().crear(consulta);
		
	}
}

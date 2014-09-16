package unq.tpi.persistencia;

import unq.tpi.persistencia.servicios.UsuarioManager;

public abstract class SetUpCliente extends AbstractHibernateTest{
	
	Usuario usuario ; 
	
	public void setUp(){
		 
		usuario = new UsuarioManager().crearUsuario("usuario");
		
	}
}

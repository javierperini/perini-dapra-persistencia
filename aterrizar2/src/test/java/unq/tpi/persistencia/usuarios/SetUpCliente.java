package unq.tpi.persistencia.usuarios;

import unq.tpi.persistencia.AbstractHibernateTest;
import unq.tpi.persistencia.Usuario;
import unq.tpi.persistencia.servicios.Manager;
import unq.tpi.persistencia.servicios.usuario.CrearUsuario;

public abstract class SetUpCliente extends AbstractHibernateTest{
	
	Usuario usuario ; 
	
	public void setUp(){
		CrearUsuario consulta= new CrearUsuario("usuario");
		usuario = new Manager<Usuario>().crear(consulta);
		
	}
}

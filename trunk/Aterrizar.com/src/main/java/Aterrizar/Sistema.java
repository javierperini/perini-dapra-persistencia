package Aterrizar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;


public class Sistema {

	private EnviadorDeMail enviadorDeMail;
	private Conector conector;
	

	public Sistema(EnviadorDeMail enviadorDeMail, Conector conector) {
		this.enviadorDeMail = enviadorDeMail;
		this.conector = conector;
	}

	public void registrar(Usuario usuario) throws Exception, ExcepcionUsuarioRepetido {
		
		if (this.esUsuarioRepetido(usuario)){
			 throw new ExcepcionUsuarioRepetido("Usuario ya registrado");
		}else{
			String s1 = usuario.getNombreUsuario();
			String s2 = usuario.getNombre();
			String s3 = usuario.getApellido();
			String s4 = usuario.getEmail();
			int s5 = usuario.getFecha();
			String s6 = usuario.getNombreUsuario();
			String s7 = "1";
			this.conector.insertar("Aterrizar ", Arrays.asList("NOMBRE_USUARIO", "NOMBRE","APELLIDO","EMAIL","FECHA","CODIGO_VALIDACION","PASSWORD"), s1, s2, s3, s4, s5, s6,s7);
			this.enviarMail(usuario.getEmail(),usuario);
		}
	}

	private void enviarMail(String email, Usuario usuario) throws Exception {
		if(this.mailValido(email,usuario)){
			Mail m= new Mail("Yase registro ahora valide su cuenta.Su codigo es"+usuario.getNombreUsuario() ,usuario.getCorreo(),"Sistema@chan.com");
			this.enviadorDeMail.enviar(m);
		}
		
	}

	private boolean mailValido(String email,Usuario usuario) throws Exception {
		
		return usuario.getNombreUsuario().equals(conector.seleccionar(Arrays.asList("NOMBRE_USUARIO"), "aterrizar","EMAIL", email));
	}

	private boolean esUsuarioRepetido(Usuario usuario) throws Exception {
		
		return usuario.getNombreUsuario().equals(conector.seleccionar(Arrays.asList("NOMBRE_USUARIO"), "Aterrizar","NOMBRE_USUARIO", usuario.getNombreUsuario()));
	}

	public void validarCuenta(String codigo) throws Exception {
		if(this.cuentaSinValidar(codigo)){
			this.conector.modificar("Aterrizar"," VALIDADO ", "True" ,"CODIGO_VALIDACION", codigo);
			 
		}else{
			 throw new ValidacionException("No existe codigo de validacion");
		}
	}

	private boolean cuentaSinValidar(String codigo) throws Exception {
		
		return codigo.equals(this.conector.seleccionar(Arrays.asList("CODIGO_VALIDACION"), "Aterrizar", "CODIGO_VALIDACION", codigo));
	
	}

	public void ingresarUsuario(Usuario usuario, String pass) throws Exception {
		if(this.usuarioExiste(usuario,pass)){
			this.conector.modificar("Aterrizar", "CONECTADO", "True", "NOMBRE_USUARIO", usuario.getNombreUsuario());
		}else{
			throw new UsuarioNoExiste("El usuario no existe");
			}
		}

	private boolean usuarioExiste(Usuario usuario,String pass) throws Exception {
		
		return pass.equals(conector.seleccionar(Arrays.asList(" PASSWORD "), "Aterrizar","NOMBRE_USUARIO", usuario.getNombreUsuario()));
		}
	}


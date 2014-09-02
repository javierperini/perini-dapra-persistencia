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
		}
		else{
			String s1 = usuario.getNombreUsuario();
			String s2 = usuario.getNombre();
			String s3 = usuario.getApellido();
			String s4 = usuario.getEmail();
			int s5 = usuario.getFecha();
			String s6 = "AAAA";
			this.conector.insertar("Aterrizar ", Arrays.asList("NOMBRE_USUARIO", "NOMBRE","APELLIDO","EMAIL","FECHA","PASSWORD"), s1, s2, s3, s4, s5, s6);
		}
	}

	private boolean esUsuarioRepetido(Usuario usuario) throws Exception {
		
		return usuario.getNombreUsuario().equals(conector.seleccionar(Arrays.asList("NOMBRE_USUARIO"), "Aterrizar","NOMBRE_USUARIO", usuario.getNombreUsuario()));
	}

	public void validarCuenta(String codigo) throws Exception {
		if(this.cuentaSinValidar(codigo)){
			this.conector.modificar("Aterrizar","VALIDADO","TRUE","CODIGO_VALIDACION", codigo);
			 
		}else{
			 throw new ValidacionException("No existe codigo de validacion");
		}
	}

	private boolean cuentaSinValidar(String codigo) throws Exception {
		
		return codigo.equals(this.conector.seleccionar(Arrays.asList("CODIGO_VALIDACION"), "Aterrizar", "CODIGO_VALIDACION", codigo));
	
	}
/*
	public void ingresarUsuario(Usuario usuario, String pass) throws Exception {
		if(this.usuarioExiste(usuario.getNombreUsuario(),pass)){
			try{
				//conn = this.getConnection();
				// MODIFICAR TABLA
				ps = conn.prepareStatement("UPDATE ATERRIZAR SET CONECTADO= ?");
				ps.setBoolean(1,true);
				ps.close();
				}finally{
				if(ps != null)
					ps.close();
				if(conn != null)
					conn.close();
				}
			}else{
				new UsuarioNoExiste("EL usuario no existe");
				}
		}

	private boolean usuarioExiste(String nombreUsuario, String pass) throws Exception {
		boolean res=false;
		try{
			//conn = this.getConnection();
			ps = conn.prepareStatement("SELECT (NOMBRE_USUARIO,PASSWORD) FROM Aterrizar WHERE CODIGO_VALIDACION = (?,?)");
			ps.setString(1,nombreUsuario);
			ps.setString(2,pass);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				 res = nombreUsuario.equals(rs.getString("NOMBRE_USUARIO")) && pass.equals(rs.getString("PASSWORD"));
			}
			ps.close();
		}finally{
			if(ps != null)
				ps.close();
			if(conn != null)
				conn.close();
		}
		
		
		return res;
	}*/
	}


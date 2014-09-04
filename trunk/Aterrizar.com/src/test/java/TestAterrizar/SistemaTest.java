package TestAterrizar;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Aterrizar.Conector;
import Aterrizar.CorreoElectronico;
import Aterrizar.EnviadorDeMail;
import Aterrizar.ExcepcionUsuarioRepetido;
import Aterrizar.Sistema;
import Aterrizar.Usuario;
import Aterrizar.UsuarioNoExiste;
import Aterrizar.ValidacionException;

public class SistemaTest {
	
	
	Sistema sistema;
	Usuario lcuelgue;
	Conector conector;
	private Usuario lcuelgue2;
	
	
	@Before
	public void setUp() throws Exception {
		
		conector = new Conector();
		this.sistema = new Sistema(new EnviadorDeMail(), conector);
		//Usuario pepe = new Usuario("Pepito", "Pepe", "Sanchez");
		CorreoElectronico correo= new CorreoElectronico("lala");
		this.lcuelgue = new Usuario("Colguetti", "Luciano", "Olmedo",correo,12356);
		this.lcuelgue2 = new Usuario("Hola", "Luciano", "Olmedo",correo,12356);
	}

	@Test
	public void testCuandoIngresoUsuarioYNoEstaEnElSistema() throws Exception {
	
		this.sistema.registrar(lcuelgue);
		Connection conn = null;
		PreparedStatement ps = null;
		String nombreUsuario=" ";
		try{
			conn = this.getConnection();
			ps = conn.prepareStatement("SELECT NOMBRE_USUARIO FROM Aterrizar WHERE NOMBRE_USUARIO = ?");
			ps.setString(1,"Colguetti");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
			 nombreUsuario = rs.getString("NOMBRE_USUARIO");
			}
			ps.close();
		}finally{
			if(ps != null)
				ps.close();
			if(conn != null)
				conn.close();
		}
		assertEquals("Se espera que el nombre de usuario sea igual ","Colguetti", nombreUsuario);
		
	}
	
	@Test   (expected=ExcepcionUsuarioRepetido.class)
	public void testCuandoIngresoUsuarioYEstaEnElSistema() throws Exception,ExcepcionUsuarioRepetido{
		this.sistema.registrar(lcuelgue);
		this.sistema.registrar(lcuelgue);
	}
	@Test 
	public void testValidarCuentaConElCodigoDeValidacion() throws Exception{
		this.sistema.registrar(lcuelgue);
		this.sistema.validarCuenta(lcuelgue.getNombreUsuario());
		Connection conn = null;
		PreparedStatement ps = null;
		boolean validado=false;
		try{
			conn = this.getConnection();
			ps = conn.prepareStatement("SELECT (VALIDADO) FROM Aterrizar WHERE CODIGO_VALIDACION = ?");
			ps.setString(1,"Colguetti");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				validado = rs.getBoolean("VALIDADO");
			 }
			
			ps.close();
		}finally{
			if(ps != null)
				ps.close();
			if(conn != null)
				conn.close();
		}
		assertTrue(validado);
	}
	
	@Test   (expected=ValidacionException.class)
	public void testCuandoIngresaCodigoYNoEstaEnElSistema() throws Exception,ValidacionException{
		this.sistema.validarCuenta("3");
	}
	
	@Test
	public void testIngresarUsuarioResgistrado() throws UsuarioNoExiste, Exception{
		
		this.sistema.registrar(lcuelgue);
		this.sistema.ingresarUsuario(lcuelgue,"1");
		Connection conn = null;
		PreparedStatement ps = null;
		boolean conectado=false;
		try{
			conn = this.getConnection();
			ps = conn.prepareStatement("SELECT CONECTADO FROM Aterrizar WHERE NOMBRE_USUARIO= ?");
			ps.setString(1,"Colguetti");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
			conectado = rs.getBoolean("CONECTADO");
			 }
			ps.close();
		}finally{
			if(ps != null)
				ps.close();
			if(conn != null)
				conn.close();
		}
		assertTrue(conectado);
	}
	
	@Test   (expected=UsuarioNoExiste.class)
	public void testIngresoElusuarioYNoExisteEnElSistema() throws Exception,UsuarioNoExiste{
		this.sistema.ingresarUsuario(lcuelgue,"2222");
	}
	
	
	
	private Connection getConnection() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost/Epers_Ej1","root","root");
	}
	
	@After
	public void limpiarTabla() throws Exception{
		this.conector.limpiarTabla();
	}
	
}

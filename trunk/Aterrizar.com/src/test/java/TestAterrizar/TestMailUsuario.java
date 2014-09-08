package TestAterrizar;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Aterrizar.Conector;
import Aterrizar.CorreoElectronico;
import Aterrizar.EnviadorDeMail;
import Aterrizar.ExcepcionUsuarioRepetido;
import Aterrizar.Sistema;
import Aterrizar.Usuario;

public class TestMailUsuario {

	private Conector conector;
	private Sistema sistema;
	private Usuario lcuelgue;
	private CorreoElectronico correo;

	@Before
	public void setUp() throws Exception {
		this.conector = new Conector();
		this.sistema = new Sistema(new EnviadorDeMail(), conector);
		this.correo= new CorreoElectronico("lala");
		this.lcuelgue = new Usuario("Colguetti", "Luciano", "Olmedo",correo,12356);
	}

	@Test
	public void testUsuarioNombre() {
		assertEquals("Luciano",lcuelgue.getNombre());
	}
	
	@Test
	public void testUsuarioNombre_Usuario() {
		assertEquals("Colguetti",lcuelgue.getNombreUsuario());
	}
	
	@Test
	public void testUsuarioApellido() {
		assertEquals("Olmedo",lcuelgue.getApellido());
	}
	
	@Test
	public void testUsuarioFecha() {
		assertEquals(12356,lcuelgue.getFecha());
	}
	
	@Test
	public void testSeRegistraUnUsuarioYLeLlegaCorreo() throws ExcepcionUsuarioRepetido, Exception{
		this.sistema.registrar(lcuelgue);
		assertEquals(1,correo.leerCorreo().size());
	}
	
	@After
	public void limpiarTabla() throws Exception{
		this.conector.limpiarTabla("Aterrizar");
	}

}

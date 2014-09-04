package Aterrizar;

public class Usuario {

	String nombreUsuario;
	String nombre;
	String apellido;
	CorreoElectronico email; 
	int fecha;
	
	public Usuario(String nombreUsuario, String nombre, String apellido,
			CorreoElectronico email, int fecha) {
		this.nombreUsuario = nombreUsuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email= email;
		this.fecha = fecha;
		
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getEmail() {
		return email.getNombre(); 
	}

	public int getFecha() {
		return fecha;
	}

	public CorreoElectronico getCorreo() {
		
		return email;
	}

	

}

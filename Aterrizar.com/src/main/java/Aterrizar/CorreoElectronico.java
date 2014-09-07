package Aterrizar;

import java.util.ArrayList;

public class CorreoElectronico {
	
	private String nombre;
	private ArrayList<Mail> correos;

	public CorreoElectronico(String nombre){
		this.nombre=nombre;
		this.correos= new ArrayList<Mail>();
	}
	
	public String getNombre() {
		   
		return this.nombre;
	}
	
	public void recibirEmail(Mail m){
		correos.add(m);

	}
	public ArrayList<Mail> leerCorreo(){
		return this.correos;
	}

}

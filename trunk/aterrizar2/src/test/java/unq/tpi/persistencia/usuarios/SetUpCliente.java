package unq.tpi.persistencia.usuarios;

import unq.tpi.persistencia.AbstractHibernateTest;
import unq.tpi.persistencia.Aerolinea;
import unq.tpi.persistencia.Asiento;
import unq.tpi.persistencia.Empresa;
import unq.tpi.persistencia.Tramo;
import unq.tpi.persistencia.Usuario;
import unq.tpi.persistencia.Vuelo;
import unq.tpi.persistencia.servicios.Manager;
import unq.tpi.persistencia.servicios.usuario.Borrar;
import unq.tpi.persistencia.servicios.usuario.Crear;

public abstract class SetUpCliente extends AbstractHibernateTest{
	
	Usuario usuario ; 
	Empresa asatej;
	Aerolinea lan;
	Aerolinea tas;
	Vuelo vueloLan;
	Vuelo vueloTas;
	Tramo argentinaBrasil;
	Tramo chinaBsAs;
	Asiento a1;
	Asiento a2;
	Asiento b1;
	Asiento a3;
	Asiento b2;
	Asiento b3;
	
	
	public void setUp(){
		usuario = new Usuario("Luciano");
		asatej = new Empresa("Asatej");
		lan = new Aerolinea("Lan", asatej);
		tas = new Aerolinea("Tas", asatej);
		vueloLan = new Vuelo("F11", lan);
		vueloTas = new Vuelo("G15", tas);
		argentinaBrasil = new Tramo("Argentina", "Brasil", 20, 15, 24, vueloLan,4,5);
		chinaBsAs = new Tramo("China", "BsAs", 30, 2, 1, vueloTas,3,6);
		a1 = new Asiento(1, argentinaBrasil);
		a2 = new Asiento(2, argentinaBrasil);
		a3 = new Asiento(3, argentinaBrasil);
		b1 = new Asiento(6, chinaBsAs);
		b2 = new Asiento(4, chinaBsAs);
		b3 = new Asiento(5, chinaBsAs);	
		
		
		asatej.agregarAerolinea(lan);
		asatej.agregarAerolinea(tas);
		lan.agregarVuelo(vueloLan);
		tas.agregarVuelo(vueloTas);
		vueloLan.agregar(argentinaBrasil);
		vueloTas.agregar(chinaBsAs);
		argentinaBrasil.agregarAsiento(a1);
		chinaBsAs.agregarAsiento(b1);
		argentinaBrasil.agregarAsiento(a2);
		argentinaBrasil.agregarAsiento(a3);
		chinaBsAs.agregarAsiento(b2);
		chinaBsAs.agregarAsiento(b3);
		new Manager<Usuario>().ejecutar(new Crear<Usuario>(usuario));
		new Manager<Empresa>().ejecutar(new Crear<Empresa>(asatej));
	}
	
	public void tearDown(){
//		new Manager<Empresa>().ejecutar(new Borrar<Empresa>(asatej));
//		new Manager<Usuario>().ejecutar(new Borrar<Usuario>(usuario));
	}
}

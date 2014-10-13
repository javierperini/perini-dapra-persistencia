package unq.tpi.persistencia.servicios.usuario;

import java.util.List;

import org.hibernate.Query;

import unq.tpi.persistencia.Asiento;
import unq.tpi.persistencia.Tramo;
import unq.tpi.persistencia.Usuario;
import unq.tpi.persistencia.daos.SessionManager;
import unq.tpi.persistencia.servicios.Operation;

public class ReservardorDeAsiento implements Operation<List<Asiento>>{
	private Usuario usuario;
	private Tramo tramo;

	public ReservardorDeAsiento(Usuario usuario, Tramo idTramo){
		this.usuario= usuario;
		this.tramo= idTramo;
	}

	public List<Asiento> execute() {
		Query q= SessionManager.getSession().createQuery("from Asiento where tramo = :tramo and reservadoPor is null");
		q.setParameter("tramo", this.tramo);
		List<Asiento>asientos =q.list();
		 if(!asientos.isEmpty())
	    	asientos.get(0).reservarPor(this.usuario);
		 
		 return asientos;	
	    }	
	
	public List<Asiento> reservarAsientosMultiples(List<Asiento> asientosReq) {
		Query q= SessionManager.getSession().createQuery("from Asiento where tramo = :tramo and reservadoPor is null");
		q.setParameter("tramo", this.tramo);
		List<Asiento>asientos =q.list();
		 if(this.estanLibres(asientos, asientosReq)){
			 for(Asiento a : asientos)
				a.reservarPor(this.usuario);
			 }
	    return asientos;	
	    }	
	
	public boolean estanLibres(List<Asiento> asientos, List<Asiento> asientosReq){
		return !asientos.isEmpty() && asientos.containsAll(asientosReq);
	}

}

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

	private List<Asiento> consultaAsientosDisponibles() {
		Query q= SessionManager.getSession().createQuery("from Asiento where tramo = :tramo and reservadoPor is null");
		q.setParameter("tramo", this.tramo);
		List<Asiento>asientos =q.list();
		return asientos;
	}
	public List<Asiento> execute() throws EstaReservadoExeption {
		List<Asiento> asientos = consultaAsientosDisponibles();
		 if(!asientos.isEmpty())
			this.reservar(asientos.get(0));
		 return asientos;	
	    }

	private void reservar(Asiento asiento) throws EstaReservadoExeption {
		if(!asiento.getEstaReservado()){
			asiento.reservarPor(this.usuario);
		}
		else{
			throw new EstaReservadoExeption("Esta reservado no se puede hacer mas nada, llame a ...");
		}
	}	
	
	public List<Asiento> reservarAsientosMultiples(List<Asiento> asientosReq) throws EstaReservadoExeption {
		List<Asiento> asientos = consultaAsientosDisponibles();
		 if(this.estanLibres(asientos, asientosReq)){
			 for(Asiento a : asientos)
				try {
					this.reservar(a);
				}catch(EstaReservadoExeption e){
					this.sacarReserva(asientos);
				}
			 }
	    return asientos;	
	    }	
	
	private void sacarReserva(List<Asiento> asientos) {
		for (Asiento a: asientos){
			a.setReservadoPor(null);
		}
	}

	public boolean asientoDisponibles(List<Asiento> asientosReq){
		List<Asiento> asientos = consultaAsientosDisponibles();
		return this.estanLibres(asientos, asientosReq);
	}

	
	public boolean estanLibres(List<Asiento> asientos, List<Asiento> asientosReq){
		return !asientos.isEmpty() && asientos.containsAll(asientosReq);
	}

}

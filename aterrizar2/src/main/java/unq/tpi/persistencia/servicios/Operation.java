package unq.tpi.persistencia.servicios;

import unq.tpi.persistencia.servicios.usuario.EstaReservadoExeption;


public interface Operation<T> {
	public T reservarAsiento() throws EstaReservadoExeption;
}

package ec.edu.uce.repository.jpa;

import ec.edu.uce.modelo.jpa.TarjetaCredito;

public interface ITarjetaRepo {

	void InsertarTarjeta(TarjetaCredito tarjeta);
	
	void ActualizarTarjeta(TarjetaCredito tarjeta);
	
	TarjetaCredito BuscarNumero(String numero);
	
}

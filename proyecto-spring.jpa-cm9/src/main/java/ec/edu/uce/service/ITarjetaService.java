package ec.edu.uce.service;

import java.math.BigDecimal;

import ec.edu.uce.modelo.jpa.TarjetaCredito;

public interface ITarjetaService {

	void InsertarTarjeta(TarjetaCredito tarjeta);
	
	void ActualizarTarjeta(TarjetaCredito tarjeta);
	
	TarjetaCredito BuscarNumero(String numero);
	
	void CargoTarjeta(String numero, BigDecimal valorConsumo);
}

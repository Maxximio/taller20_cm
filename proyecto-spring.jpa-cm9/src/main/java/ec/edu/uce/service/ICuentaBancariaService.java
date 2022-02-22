package ec.edu.uce.service;

import ec.edu.uce.modelo.jpa.CuentaBancaria;

public interface ICuentaBancariaService {

	void InsertarCuentaBancariaService(CuentaBancaria cuenta);
	
	void ActualizarCuentaBancariaService(CuentaBancaria cuenta);
}

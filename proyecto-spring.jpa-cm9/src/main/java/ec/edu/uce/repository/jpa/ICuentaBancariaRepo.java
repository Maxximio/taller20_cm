package ec.edu.uce.repository.jpa;

import ec.edu.uce.modelo.jpa.CuentaBancaria;

public interface ICuentaBancariaRepo {

	void InsertarCuentaBancaria(CuentaBancaria cuenta);
	
	void ActualizarCuentaBancaria(CuentaBancaria cuenta);
	
	void ActualizarCuentaBancaria2(CuentaBancaria cuenta);
	
	CuentaBancaria BuscarPorNumero(String numero);
	
}

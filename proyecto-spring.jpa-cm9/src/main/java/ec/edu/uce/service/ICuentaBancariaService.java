package ec.edu.uce.service;

import java.math.BigDecimal;

import ec.edu.uce.modelo.jpa.CuentaBancaria;

public interface ICuentaBancariaService {

	void InsertarCuentaBancariaService(CuentaBancaria cuenta);
	
	void ActualizarCuentaBancariaService(CuentaBancaria cuenta);
	
	CuentaBancaria BuscarPorNumeroService(String numero);
	
	void realizarTransferencia(String origen,String destino, BigDecimal valorTransferir);
}

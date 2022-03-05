package ec.edu.uce.service;

import java.math.BigDecimal;

import ec.edu.uce.modelo.jpa.CuentaBancaria;

public interface ICuentaBancariaService {

	void InsertarCuentaBancariaService(CuentaBancaria cuenta);
	
	void ActualizarCuentaBancariaService(CuentaBancaria cuenta);
	
	CuentaBancaria BuscarPorNumeroService(String numero);
	
	void realizarTransferencia(String origen,String destino, BigDecimal valorTransferir);
	
	public void propagaciónMandatory();

	void realizarTransferenciaExpress(String origen, String destino, BigDecimal valorTransferir);

	void realizarTransferenciaExpressInicial(String origen, String destino, BigDecimal valorTransferir);

	void realizarTransferenciaExpressInicialNoT(String origen, String destino, BigDecimal valorTransferir);

	void enviarMail();

	void enviarMailNoT();
}

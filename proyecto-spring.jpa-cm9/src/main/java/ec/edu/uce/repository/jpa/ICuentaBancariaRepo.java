package ec.edu.uce.repository.jpa;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import ec.edu.uce.modelo.jpa.CuentaBancaria;

public interface ICuentaBancariaRepo {

	void InsertarCuentaBancaria(CuentaBancaria cuenta);
	
	void ActualizarCuentaBancaria(CuentaBancaria cuenta);
	
	void ActualizarCuentaBancaria2(CuentaBancaria cuenta);
	
	CuentaBancaria BuscarPorNumero(String numero);

	public void propagaciónMandatory();

	void enviarMail(String asunto);
	
}

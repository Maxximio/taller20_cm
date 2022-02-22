package ec.edu.uce.service;

import java.math.BigDecimal;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.jpa.CuentaBancaria;
import ec.edu.uce.repository.jpa.ICuentaBancariaRepo;

@Service
public class CuentaBancariaServiceImpl implements ICuentaBancariaService{

	@Autowired
	private ICuentaBancariaRepo cuentaRepo;
	
	@Override
	public void InsertarCuentaBancariaService(CuentaBancaria cuenta) {
		this.cuentaRepo.InsertarCuentaBancaria(cuenta);
	}

	@Override
	public void ActualizarCuentaBancariaService(CuentaBancaria cuenta) {
		this.cuentaRepo.ActualizarCuentaBancaria(cuenta);
	}

	@Override
	public CuentaBancaria BuscarPorNumeroService(String numero) {
		return this.cuentaRepo.BuscarPorNumero(numero);
	}

	@Override
	@Transactional//todo lo de aqui abajo se considera una transaccion
	public void realizarTransferencia(String origen, String destino, BigDecimal valorTransferir) {
		
		CuentaBancaria CuentaOrigen= this.cuentaRepo.BuscarPorNumero(origen);
		
		CuentaBancaria CuentaDestino=this.cuentaRepo.BuscarPorNumero(destino);
		
		BigDecimal Transferenci1=CuentaOrigen.getSaldo().subtract(valorTransferir);
		CuentaOrigen.setSaldo(Transferenci1);
		
		BigDecimal Transferenci2 =CuentaDestino.getSaldo().add(valorTransferir);
		CuentaDestino.setSaldo(Transferenci2);
		CuentaDestino.setTipo(null);
		
		this.cuentaRepo.ActualizarCuentaBancaria(CuentaOrigen);
		this.cuentaRepo.ActualizarCuentaBancaria(CuentaDestino);
	}

}

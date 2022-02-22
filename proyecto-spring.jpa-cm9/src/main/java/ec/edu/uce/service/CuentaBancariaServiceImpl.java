package ec.edu.uce.service;

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

}

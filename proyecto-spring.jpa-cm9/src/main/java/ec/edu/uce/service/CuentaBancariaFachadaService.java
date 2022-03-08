package ec.edu.uce.service;

import java.math.BigDecimal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;


@Service
public class CuentaBancariaFachadaService {

	private static final Logger LOG= LogManager.getLogger(CuentaBancariaFachadaService.class);

	
	@Autowired
	private ICuentaBancariaService bancariaService;
	
	public void realizarTransferenciaExpressInicialNoT(String origen, String destino, BigDecimal valorTransferir) {
		LOG.info("prueba 1"+TransactionSynchronizationManager.isActualTransactionActive());
		this.bancariaService.realizarTransferenciaExpress(origen, destino, valorTransferir);
	}
}

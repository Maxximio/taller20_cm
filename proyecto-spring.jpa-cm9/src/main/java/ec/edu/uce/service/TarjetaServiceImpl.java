package ec.edu.uce.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.jpa.Consumo;
import ec.edu.uce.modelo.jpa.TarjetaCredito;
import ec.edu.uce.repository.jpa.IConsumoRepo;
import ec.edu.uce.repository.jpa.ITarjetaRepo;

@Service
public class TarjetaServiceImpl implements ITarjetaService{

	@Autowired
	private ITarjetaRepo tarjRepo;
	
	@Autowired
	private IConsumoRepo consuRepo;
	
	@Override
	public void InsertarTarjeta(TarjetaCredito tarjeta) {
		this.tarjRepo.InsertarTarjeta(tarjeta);
	}

	@Override
	public void ActualizarTarjeta(TarjetaCredito tarjeta) {
		this.tarjRepo.ActualizarTarjeta(tarjeta);
	}

	@Override
	public TarjetaCredito BuscarNumero(String numero) {
		return this.tarjRepo.BuscarNumero(numero);
	}

	@Override
	public void CargoTarjeta(String numero, BigDecimal valorRetirar) {
		
		TarjetaCredito Tarjeta=this.tarjRepo.BuscarNumero(numero);
		
		Consumo consu=new Consumo();
		
		BigDecimal Tansaccion=Tarjeta.getCupo().subtract(valorRetirar);
		Tarjeta.setCupo(Tansaccion);
		
		LocalDateTime ahora = LocalDateTime.now();
		consu.setFechaConsumo(ahora);
		consu.setValorConsumo(valorRetirar);
		consu.setTarjeta_credito(Tarjeta);
		
		consuRepo.InsertarConsumo(consu);
		tarjRepo.ActualizarTarjeta(Tarjeta);
		
	}

}
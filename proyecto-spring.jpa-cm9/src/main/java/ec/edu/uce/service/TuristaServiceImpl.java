package ec.edu.uce.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.Turista;
import ec.edu.uce.repository.jpa.ITuristaRepo;

@Service
public class TuristaServiceImpl implements ITuristaService{

	@Autowired
	private ITuristaRepo turRepo;
	
	@Override
	public List<Turista> obtenerTuristas() {
		List<Turista> lista=this.turRepo.GenerarTuristaCriteria();
		List<Turista> listaCalculada=this.calcularSaldo(lista);
		return listaCalculada;
	}

	private List<Turista> calcularSaldo(List <Turista> ListaTuristas){
		for(Turista turista:ListaTuristas) {
			BigDecimal saldo=turista.getValor().subtract(turista.getAbono());
			turista.setSaldo(saldo);	
			//System.out.println("el saldo ha sido: "+saldo);
		}
		return ListaTuristas;
	}

	@Override
	public void insertarTuristasService(Turista turista) {
		this.turRepo.insertarTurista(turista);
	}
	
}

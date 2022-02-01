package ec.edu.uce;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ec.edu.uce.modelo.Paciente;
import ec.edu.uce.modelo.Receta;
import ec.edu.uce.modelo.jpa.Abogado;
import ec.edu.uce.modelo.jpa.Arquitecto;
import ec.edu.uce.modelo.jpa.Chofer;
import ec.edu.uce.modelo.jpa.DetalleFactura;
import ec.edu.uce.modelo.jpa.Doctor;
import ec.edu.uce.modelo.jpa.Factura;
import ec.edu.uce.modelo.jpa.Guardia;
import ec.edu.uce.modelo.jpa.Mesero;
import ec.edu.uce.repository.jpa.GuardiaRepoImpl;
import ec.edu.uce.service.IAbogadoService;
import ec.edu.uce.service.IArquitectoSerivce;
import ec.edu.uce.service.IChoferService;
import ec.edu.uce.service.IDoctorService;
import ec.edu.uce.service.IFacturaService;
import ec.edu.uce.service.IGestorCitaService;
import ec.edu.uce.service.IGuardiaService;
import ec.edu.uce.service.IMeseroService;
import ec.edu.uce.service.IPacienteService;

@SpringBootApplication
public class Application implements CommandLineRunner{
	
	private static final Logger LOG= LogManager.getLogger(GuardiaRepoImpl.class);
	
	@Autowired
	private IGestorCitaService gestorServ;
	
	@Autowired
	private IGuardiaService guardService;
	
	@Autowired
	private IFacturaService facService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		
		
		Factura miFactura=new Factura();
		miFactura.setCedula("124534745");
		LocalDateTime miFecha=LocalDateTime.of(1999, Month.AUGUST,8,12,45);
		
		miFactura.setFecha(miFecha);
		miFactura.setNumero("123124-124-1212");
		
		//contruimos la lista 
		List<DetalleFactura> detalles=new ArrayList<>();
		
		DetalleFactura d1=new DetalleFactura();
		d1.setCantidad(5);
		d1.setPrecio(new BigDecimal(14.25));
		d1.setFactura(miFactura);
		
		detalles.add(d1);
		
		DetalleFactura d2=new DetalleFactura();
		d2.setCantidad(1);
		d2.setPrecio(new BigDecimal(3.5));
		d2.setFactura(miFactura);	
		
		detalles.add(d2);
		
		miFactura.setDetalles(detalles);
		
		this.facService.insertarFacturaService(miFactura);
		

		//Guardia guard =new Guardia();
		//guard.setNombre("Carlos");
		//guard.setApellido("Alvarado");
		//guard.setEdificio("Licuadora");
		
		//Guardia guard2 =new Guardia();
		//guard2.setId(3);
		//guard2.setNombre("Ricardo");
		//guard2.setApellido("Montalvo");
		//guard2.setEdificio("Plaza Toros");
		
		//this.guardService.InsertarGuardiaService(guard);
		//System.out.println(this.guardService.buscarGuardiaApellidoService("Montalvo"));
		//this.guardService.buscarGuardiaService(3);
		//System.out.println(this.guardService.buscarGuardiaService(3));
		//this.guardService.borrarGuardiaService(3);
		//this.guardService.ActualizarGuardiaService(guard2);
		
		//busca con created query
		//Guardia gApellido =this.guardService.buscarGuardiaApellidoService("Alvarado");
		//System.out.println(gApellido);
		
		//busca la lista
		//Guardia gApellido =this.guardService.buscarGuardiaApellidoListaService("Alvarado");
		//System.out.println(gApellido);
		
		//busca con el typed query
		//Guardia gApellido =this.guardService.buscarGuardiaApellidoIype("Alvarado");
		//System.out.println(gApellido);
		
		//busca con named query
		//Guardia gApellido =this.guardService.buscarGuardiaApellidoNamedService("Alvarado");
		//LOG.info("El guardia ha sido: "+gApellido);
		
		//busca con native query
		//Guardia gApellido =this.guardService.buscarGuardiaApellidoNamedService("Alvarado");
		//LOG.info("El guardia ha sido: "+gApellido);
		
		//buscar con named native
		//Guardia gApellido =this.guardService.buscarGuardiaApellidoNamedNativeService("Alvarado");
		//LOG.info("El guardia ha sido: "+gApellido);
		
		//buscar con criteria
		//Guardia gApellido =this.guardService.buscarGuardiaApellidoCriteriaService("Alvarado");
		//LOG.info("El guardia ha sido: "+gApellido);
		
		//buscar con criteria and
		//Guardia gApellido1 =this.guardService.buscarGuardiaApellidoCriteriaAndService("Alvarado","Carlos");
		//LOG.info("El guardia ha sido: "+gApellido1);
				
		//buscar con criteria or
		//List <Guardia> gApellido2 =this.guardService.buscarGuardiaApellidoCriteriaOrService("Alvarado","Ricardo");
		//for(Guardia g: gApellido2) {
		//	LOG.info("El guardia ha sido: "+g);
		//}
		
	}

}

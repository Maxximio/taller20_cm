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
import ec.edu.uce.modelo.Turista;
import ec.edu.uce.modelo.jpa.Ciudadano;
import ec.edu.uce.modelo.jpa.Cliente;
import ec.edu.uce.modelo.jpa.CuentaBancaria;
import ec.edu.uce.modelo.jpa.DetalleFactura;
import ec.edu.uce.modelo.jpa.Empleado;
import ec.edu.uce.modelo.jpa.Factura;
import ec.edu.uce.modelo.jpa.FacturaSencilla;
import ec.edu.uce.modelo.jpa.Guardia;
import ec.edu.uce.repository.jpa.GuardiaRepoImpl;
import ec.edu.uce.service.ICiudadanoService;
import ec.edu.uce.service.ICuentaBancariaService;
import ec.edu.uce.service.IDetalleService;
import ec.edu.uce.service.IFacturaService;
import ec.edu.uce.service.IGestorCitaService;
import ec.edu.uce.service.IGuardiaService;
import ec.edu.uce.service.IPacienteService;
import ec.edu.uce.service.ITuristaService;

@SpringBootApplication
public class Application implements CommandLineRunner{
	
	private static final Logger LOG= LogManager.getLogger(GuardiaRepoImpl.class);
	
	@Autowired
	private IGestorCitaService gestorServ;
	
	@Autowired
	private IGuardiaService guardService;
	
	@Autowired
	private IFacturaService facService;
	
	@Autowired
	private IDetalleService detaService;
	
	@Autowired
	private ICiudadanoService ciuService;
	
	@Autowired
	private ICuentaBancariaService cubaService;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		
		CuentaBancaria c1=new CuentaBancaria();
		c1.setNumero("2145234523141");
		c1.setClienteCedula("0123124");
		c1.setSaldo(new BigDecimal(100.00));
		c1.setTipo("corriente");
		
		CuentaBancaria c2=new CuentaBancaria();
		c2.setNumero("124141213124");
		c2.setClienteCedula("012313124");
		c2.setSaldo(new BigDecimal(200.00));
		c2.setTipo("ahorros");
		
		//cubaService.InsertarCuentaBancariaService(c1);
		//cubaService.InsertarCuentaBancariaService(c2);
		
		cubaService.realizarTransferencia("2145234523141", "124141213124", new BigDecimal(20.00));
		
/////////////////////taller 28/////////////////////////
		/*Turista tur1=new Turista();
		tur1.setNombre("Sebastian");
		tur1.setValor(new BigDecimal(200.00));
		tur1.setAbono(new BigDecimal(100.00));
		
		turService.insertarTuristasService(tur1);
		LOG.info(turService.obtenerTuristas());*/
		
////////////////////////taller 27///////////////////
	/*	Cliente cli=new Cliente();
		cli.setNombre("Luisa");
		
		List<String>listaT=new ArrayList<>();
		listaT.add("5232343");
		listaT.add("6343434");
		
		LocalDateTime miFecha=LocalDateTime.of(1999, Month.AUGUST,8,12,45);
		
		List <FacturaSencilla> listaF =this.facService.buscarSencillaPorFechaJOINFetchService(miFecha);
		LOG.info("Longitud"+listaF.size());
		for(FacturaSencilla factu: listaF) {
			LOG.info("Las Facturas han sido: "+factu.toString());
		}
		*/
		
////////////////////////taller 26///////////////////
		/*Factura miFactura=new Factura();
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
		
		List <Factura> listaF =this.facService.buscarPorFechaJOINFetchService(miFecha);
		LOG.info("Longitud"+listaF.size());
		for(Factura factu: listaF) {
			LOG.info("Las Facturas han sido: "+factu.toString());
		}*/
		
		//this.facService.insertarFacturaService(miFactura);
		//this.facService.buscarPorFechaJOINRigth(miFecha);
		
		/*List <Factura> listaF =this.facService.buscarPorFechaJOINLeftService(miFecha);
		LOG.info("Longitud"+listaF.size());
		for(Factura factu: listaF) {
			LOG.info("Las Facturas han sido: "+factu.toString());
		}*/
		
		/*List <Factura> listaF1 =this.facService.buscarPorFechaJOINFetchService(miFecha);
		LOG.info("Longitud"+listaF1.size());
		for(Factura factu1: listaF1) {
			LOG.info("Las Facturas han sido: "+factu1.toString());
		}*/
		
		
		/*Ciudadano ciu=new Ciudadano();
		ciu.setNombre("Carlos");
		ciu.setApellido("Montalvo");
		
		Empleado empl =new Empleado();
		empl.setIess("asfqwe2342");
		empl.setSalario(new BigDecimal(500.30));

		empl.setCiudadania(ciu);
		ciu.setEmpleados(empl);
		
		ciuService.insertarCiudadanoService(ciu);*/
		
		/*Factura miFactura=new Factura();
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
		
		this.facService.insertarFacturaService(miFactura);*/
		

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

package ec.edu.uce.interfaces.funcionales;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.hibernate.internal.build.AllowSysOut;

public class MainFuncional {

	public static void main(String[] args) {
		
		//SUPPLIER
		System.out.println("--------SUPPLIER---------");
		IPersonaSupplier<String> supplier =new PersonaSupplier();
		System.out.println(supplier.get());
		
		IPersonaSupplier<String> supplierChino =new PersonaSupplierChino();
		System.out.println(supplierChino.get());
		
		IPersonaSupplier<String> supplier1=() ->  {return"Hola Mundo con llaves";};
		System.out.println(supplier1.get());
		
		IPersonaSupplier<String> supplierChino1=() ->  "*algo en chino";
		System.out.println(supplierChino1.get());
		
		ConsumoInterfacesFuncionales consumo=new ConsumoInterfacesFuncionales();
		String resultado = consumo.consumirInterface(() -> "Hola Mundo!!!");
		System.out.println(resultado);
		
		//Supplier en Java
		Stream<String> test=Stream.generate(()->"Hola Hola").limit(3);//100
		test.forEach( X->System.out.println(X+" prueba"));

		
		//CONSUMER
		System.out.println("--------CONSUMER---------");
		IPersonaConsummer<Integer> personaConsummer=number ->System.out.println(number);
		personaConsummer.accept(7);
		
		IPersonaConsummer<Integer> personaConsummer1=number ->System.out.println(number.intValue()+1);
		personaConsummer1.accept(7);
		
		consumo.consumirConsumer(number -> System.out.println(number+10),2);
		
		//Consumer Java
		List<Integer> listaNumeros=Arrays.asList(1,2,3,4,5,6);
		listaNumeros.forEach(number ->System.out.println(number));
		
		//PREDICATE
		System.out.println("--------PREDICATE---------");
		boolean resultado2= consumo.consumirPredicate((cadena)->cadena.contains("a"), "Carlos");
		System.out.println(resultado2);
		
		//predicate en Java
		Stream<Integer>numerosFiltrados=listaNumeros.stream().filter((cadena)->cadena >2);
		numerosFiltrados.forEach(num -> System.out.println(num) );
		
		//FUNTION
		System.out.println("--------FUNTION---------");
		Integer nuevoValor=consumo.consumirFuntion(cadena -> Integer.parseInt(cadena)+7, "2");
		System.out.println(nuevoValor);
		
		//funtion Java
		Stream<String> listaCambiada= listaNumeros.stream().map(cadena ->cadena.toString()+" N");
		listaCambiada.forEach(cadena ->System.out.println(cadena));
		
		//lista Numeros
		//listaNumeros.stream().reduce(null);
		
	}
	
}


//muchas de las interfaces de java reciben interfaces funcionales
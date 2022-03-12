package ec.edu.uce.interfaces.funcionales;



public class MainMetodosReferenciados {

	public static void main(String[] args) {
		
		//1. Implementados por clases
		IPersonaSupplier<String> persona =new PersonaSupplierImpl();
		String mensaje=persona.get();
		System.out.println(mensaje);
		
		//2. Implementar por Lambdas
		IPersonaSupplier<String> persona1=() -> "Se implemento por lambda";
		String mensaje1=persona1.get();
		System.out.println(mensaje1);
		
		//3. Metodos Referenciados
		PersonaSupplierImpl personaImpl=new PersonaSupplierImpl();
		IPersonaSupplier<String> persona2=personaImpl::get;
		String mensaje2=persona2.get();
		System.out.println(mensaje2);
		
		//3.1
		PersonaSupplierSin personaSin=new PersonaSupplierSin();
		
		IPersonaSupplier<String> persona3 =personaSin::get;
		String mensaje3=persona3.get();
		System.out.println(mensaje3);
			
		IPersonaSupplier<Integer> persona4 = personaSin::get3;
		
		//3.2
		PersonaPredicateImpl personaPred=new PersonaPredicateImpl();
		
		IPersonaPredicate<String> personaPred2=personaPred::evaluar;
		
		boolean nombre =personaPred2.evaluar("mensaje3");
		
		
		IPersonaPredicate<String> personaPredi3=valor1 -> valor1.contains("Z");
		boolean respuestas =personaPredi3.evaluar("ARROZ");
		
		prueba (personaPred::evaluar);
	}

	public static boolean prueba(IPersonaPredicate<String>args1) {
		return args1.evaluar("Mensaje");
	}
	
}

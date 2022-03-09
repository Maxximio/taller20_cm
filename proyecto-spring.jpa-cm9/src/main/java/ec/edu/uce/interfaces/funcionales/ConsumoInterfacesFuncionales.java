package ec.edu.uce.interfaces.funcionales;

public class ConsumoInterfacesFuncionales {

	public String consumirInterface(IPersonaSupplier<String> funcion) {
		return funcion.get();
	}
	
	
	public void consumirConsumer(IPersonaConsummer<Integer>funcion,Integer valor) {
		funcion.accept(valor);
	}
	
	public boolean consumirPredicate(IPersonaPredicate<String>funcion,String valor) {
		return funcion.evaluar(valor);
		 
	}
	
	public Integer consumirFuntion(IPersonaFunction<String, Integer>funtion,String cadena) {
		return funtion.apply(cadena);
	}
}

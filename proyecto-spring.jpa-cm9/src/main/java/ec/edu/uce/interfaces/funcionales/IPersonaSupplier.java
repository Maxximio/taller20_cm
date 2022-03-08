package ec.edu.uce.interfaces.funcionales;

@FunctionalInterface 
public interface IPersonaSupplier<T> {
	public T get(); //no es necesario declarar public
}

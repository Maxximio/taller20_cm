package ec.edu.uce.interfaces.funcionales;

@FunctionalInterface
public interface IPersonaPredicate<T> {
	
	boolean evaluar(T agr1);
}

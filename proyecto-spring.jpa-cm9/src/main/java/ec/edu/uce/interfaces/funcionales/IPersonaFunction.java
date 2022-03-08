package ec.edu.uce.interfaces.funcionales;

@FunctionalInterface
public interface IPersonaFunction<T,R> {

	R apply(T arg1);
}

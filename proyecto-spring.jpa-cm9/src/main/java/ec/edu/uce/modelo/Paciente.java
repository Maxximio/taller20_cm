package ec.edu.uce.modelo;

public class Paciente {

	private Integer Id;
	private String nombre;
	private String apellido;
	private Integer edad;
	
	//metodo set y get
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	
	//to string
	@Override
	public String toString() {
		return "Paciente [Id=" + Id + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + "]";
	}
	
}

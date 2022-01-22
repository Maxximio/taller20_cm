package ec.edu.uce.modelo.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;

@Entity
@NamedQuery(name="Guardia.buscarPorApellido",query="select g from Guardia g where g.apellido=:valor")
//@NamedQueries para mas de un query
@Table(name="guardia")//Es absolutamente necesario cuando la tabla tiene un nombre diferente
public class Guardia {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_guardia1")
	@SequenceGenerator(name="seq_guardia1",sequenceName = "seq_guardia",allocationSize = 1)
	private Integer id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="apellido")
	private String apellido;
	
	@Column(name="edificio")
	private String edificio;
	
	
	//set y get
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getEdificio() {
		return edificio;
	}
	public void setEdificio(String edificio) {
		this.edificio = edificio;
	}
	
	
	//to string
	
	@Override
	public String toString() {
		return "Guardia [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", edificio=" + edificio + "]";
	}
	
}

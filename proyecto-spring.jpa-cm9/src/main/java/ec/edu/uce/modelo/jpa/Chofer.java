package ec.edu.uce.modelo.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="chofer")
public class Chofer {

	@Id
	@Column(name="matricula")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_chofer")
	@SequenceGenerator(name="seq_chofer",sequenceName = "seq_chofer",allocationSize = 1)
	private Integer matricula;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="placa")
	private Integer placa;

	public Integer getMatricula() {
		return matricula;
	}

	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getPlaca() {
		return placa;
	}

	public void setPlaca(Integer placa) {
		this.placa = placa;
	}

	@Override
	public String toString() {
		return "Chofer [matricula=" + matricula + ", nombre=" + nombre + ", placa=" + placa + "]";
	}
	
	
}

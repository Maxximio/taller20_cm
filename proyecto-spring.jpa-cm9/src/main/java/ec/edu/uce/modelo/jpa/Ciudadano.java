package ec.edu.uce.modelo.jpa;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ciudadano")
public class Ciudadano {

	@Id
	@Column(name="ciu_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_ciu")
	@SequenceGenerator(name="seq_ciu",sequenceName = "seq_ciu",allocationSize = 1)
	private Integer id;
	
	@Column(name="ciu_nombre")
	private String nombre;
	
	@Column(name="ciu_apellido")
	private String apellido;
	
	@OneToOne(mappedBy = "ciudadano",cascade=CascadeType.ALL)
	private Empleado empleado;

	//get y set
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

	public Empleado getEmpleados() {
		return empleado;
	}

	public void setEmpleados(Empleado empleados) {
		this.empleado = empleados;
	}
	
}
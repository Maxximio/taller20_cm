package ec.edu.uce.modelo.jpa;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="empleado")
public class Empleado {

	@Id
	@Column(name="empl_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_empl")
	@SequenceGenerator(name="seq_empl",sequenceName = "seq_empl",allocationSize = 1)
	private Integer id;
	
	@Column(name="empl_iess")
	private String iess;
	
	@Column(name="empl_salario")
	private BigDecimal salario;
	
	@OneToOne
	@JoinColumn(name="empl_id_ciudadano")
	private Ciudadano ciudadano;

	//get y set
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Ciudadano getCiudadania() {
		return ciudadano;
	}

	public void setCiudadania(Ciudadano ciudadania) {
		this.ciudadano = ciudadania;
	}
	
	public String getIess() {
		return iess;
	}

	public void setIess(String iess) {
		this.iess = iess;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}
	
	
	
}

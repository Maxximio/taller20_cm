package ec.edu.uce.modelo.jpa;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tarjeta_credito")
public class TarjetaCredito {

	@Id
	@Column(name="tarj_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_tarjeta")
	@SequenceGenerator(name="seq_tarjeta",sequenceName = "seq_tarjeta",allocationSize = 1)
	private Integer id;
	
	@Column(name="tarj_numero")
	private String numero;
	
	@Column(name="tarj_cedula")
	private String cedula;
	
	@Column(name="tarj_cupo")
	private BigDecimal cupo;
	
	@OneToMany(mappedBy = "tarjeta_credito",cascade=CascadeType.ALL)
	private List<Consumo> consumo;

	//get y set
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public BigDecimal getCupo() {
		return cupo;
	}

	public void setCupo(BigDecimal cupo) {
		this.cupo = cupo;
	}

	public List<Consumo> getConsumo() {
		return consumo;
	}

	public void setConsumo(List<Consumo> consumo) {
		this.consumo = consumo;
	}
	
	
	
}

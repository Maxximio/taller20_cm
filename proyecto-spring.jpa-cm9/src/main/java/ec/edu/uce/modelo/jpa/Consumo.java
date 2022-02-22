package ec.edu.uce.modelo.jpa;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="consumo")
public class Consumo {

	@Id
	@Column(name="consu_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_consumo")
	@SequenceGenerator(name="seq_consumo",sequenceName = "seq_consumo",allocationSize = 1)
	private Integer id;
	
	@Column(name="consu_valor_consumo")
	private BigDecimal valorConsumo;
	
	@Column(name="consu_fecha_consumo")
	private LocalDateTime fechaConsumo;
	
	@ManyToOne
	@JoinColumn(name="tarj_id")
	private TarjetaCredito tarjeta_credito;

	
	//set y get
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getValorConsumo() {
		return valorConsumo;
	}

	public void setValorConsumo(BigDecimal valorConsumo) {
		this.valorConsumo = valorConsumo;
	}

	public LocalDateTime getFechaConsumo() {
		return fechaConsumo;
	}

	public void setFechaConsumo(LocalDateTime fechaConsumo) {
		this.fechaConsumo = fechaConsumo;
	}

	public TarjetaCredito getTarjeta_credito() {
		return tarjeta_credito;
	}

	public void setTarjeta_credito(TarjetaCredito tarjeta_credito) {
		this.tarjeta_credito = tarjeta_credito;
	}
	
	
	
}


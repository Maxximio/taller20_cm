package ec.edu.uce.modelo.jpa;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="cliente")
public class Cliente {

	@Id
	@Column(name="cli_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cli")
	@SequenceGenerator(name="seq_cli",sequenceName = "seq_cli",allocationSize = 1)
	private Integer id;
	
	@Column(name="cli_nombre") 
	private String nombre;
	
	@ElementCollection//relaciona con un unico dato
	private List<String>telefonos;

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

	public List<String> getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(List<String> telefonos) {
		this.telefonos = telefonos;
	}
}

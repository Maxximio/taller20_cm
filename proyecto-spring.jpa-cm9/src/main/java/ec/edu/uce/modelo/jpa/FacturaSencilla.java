package ec.edu.uce.modelo.jpa;

public class FacturaSencilla {

	private String numero;
	private String cedula;
	
	//constructor
	
	public FacturaSencilla() {}//constructor por defecto
	
	public FacturaSencilla(String numero, String cedula) {//constructor(mandatorio)
		super();
		this.numero = numero;
		this.cedula = cedula;
	}
	
	//set y get
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

	//to String
	@Override
	public String toString() {
		return "FacturaSencilla [numero=" + numero + ", cedula=" + cedula + "]";
	}
	
	
	
}

package dbclases;

public class Balance {

	private String nombre;
	private String tipo;
	private Float saldo;
	
	public Balance(String nombre, String tipo, float saldo)
	{
		this.nombre = nombre;
		this.tipo = tipo;
		this.saldo = saldo;
	}
	
	public String getNombre() {
		return nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public Float getSaldo() {
		return saldo;
	}
}

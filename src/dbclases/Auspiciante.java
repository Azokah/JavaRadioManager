package dbclases;

public class Auspiciante {

	private String nombre;
	private float saldo;
	
	public Auspiciante(String nombre, float saldo) {
		this.nombre = nombre;
		this.saldo = saldo;
	}

	public String getNombre() {
		return nombre;
	}

	public float getSaldo() {
		return saldo;
	}


}
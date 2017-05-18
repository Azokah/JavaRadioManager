package dbclases;

public class Conductor {

	private String nombre;
	private float sueldo;
	public Conductor(String nombre, float sueldo) {
		this.nombre = (nombre);
		this.sueldo = (sueldo);
	}
	public String getNombre() {
		return nombre;
	}

	public float getSueldo() {
		return sueldo;
	}


}
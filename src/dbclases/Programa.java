package dbclases;

public class Programa {
	
	private String nombre;
	private String horario;
	private String conductor;
	private String productor;
	private String auspiciante;
	
	public Programa( String nombre, String horario, String conductor, String productor, String auspiciante)
	{
		this.nombre = nombre;
		this.horario = horario;
		this.conductor = conductor;
		this.productor = productor;
		this.auspiciante = auspiciante;
	}
	
	public String getAuspiciante() {
		return auspiciante;
	}

	public void setAuspiciante(String auspiciante) {
		this.auspiciante = auspiciante;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	public String getConductor() {
		return conductor;
	}
	public void setConductor(String conductor) {
		this.conductor = conductor;
	}
	public String getProductor() {
		return productor;
	}
	public void setProductor(String productor) {
		this.productor = productor;
	}
	

}

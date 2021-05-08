package entities;

public class Empleado {
	
	private String nombre;
	private String sexo;
	private int dni;
	private int legajo;
	private int totalhora;
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public void setDni (int dni) {
		this.dni = dni;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getSexo() {
		return sexo;
	}
	
	public int getDni() {
		return dni;
	}
	
	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}
	
	public int getLegajo() {
		return legajo;
	}
	
	public void setHora(int hora) {
		this.totalhora = hora;
	}
	
	public int getHora() {
		return totalhora;
	}

}

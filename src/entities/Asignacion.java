package entities;

public class Asignacion {
	private int id_grupo;
	private int legajo;

	public void setEmpleado(int legajo) {
		this.legajo = legajo;
	}
	
	public void setGrupo(int id_grupo) {
		this.id_grupo = id_grupo;
	}
	
	public int getEmpleado() {
		return legajo;
	}

	public int getGrupo() {
		return id_grupo;
	}
}

package entities;

public class Tarea {
	private int id_tarea;
	private String desc;
	private int id_grupo;
	private int hora = 0;
	
	public void setGrupo(int id_grupo) {
		this.id_grupo = id_grupo;
	}
	
	public int getGrupo() {
		return id_grupo;
	}
	
	public void setId(int id_tarea) {
		this.id_tarea = id_tarea;
	}
	
	public int getId() {
		return id_tarea;
	}
	
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public String getDesc() {
		return desc;
	}
	
	public int getHora() {
		return hora;
	}
	
	public void setHora(int hora) {
		this.hora = hora;
	}

}

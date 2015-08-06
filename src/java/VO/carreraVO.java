package VO;

public class carreraVO {
 
	private int id_carrera;
	private String nombre_carrera;
	private String descripcion_carrera;
	private int id_facultad;

	public int getid_carrera() {
		return this.id_carrera;
	}

	public void setid_carrera(int id_carrera) {
		this.id_carrera=id_carrera;
	}

	public String getnombre_carrera() {
		return this.nombre_carrera;
	}

	public void setnombre_carrera(String nombre_carrera) {
		this.nombre_carrera=nombre_carrera;
	}

	public String getdescripcion_carrera() {
		return this.descripcion_carrera;
	}

	public void setdescripcion_carrera(String descripcion_carrera) {
		this.descripcion_carrera=descripcion_carrera;
	}

	public int getid_facultad() {
		return this.id_facultad;
	}

	public void setid_facultad(int id_facultad) {
		this.id_facultad=id_facultad;
	}

}
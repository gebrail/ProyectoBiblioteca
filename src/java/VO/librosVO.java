package VO;import java.sql.Date;


public class librosVO {
 
	private int id_libro;
	private String autor_libro;
	private String idioma_libro;
	private String editorial_libro;
	private Date aniopublicado_libro;
	private String estado_libro;
	private String categoria_libro;
	private String nombre_libro;
	private int id_disponibilidad;

	public int getid_libro() {
		return this.id_libro;
	}

	public void setid_libro(int id_libro) {
		this.id_libro=id_libro;
	}

	public String getautor_libro() {
		return this.autor_libro;
	}

	public void setautor_libro(String autor_libro) {
		this.autor_libro=autor_libro;
	}

	public String getidioma_libro() {
		return this.idioma_libro;
	}

	public void setidioma_libro(String idioma_libro) {
		this.idioma_libro=idioma_libro;
	}

	public String geteditorial_libro() {
		return this.editorial_libro;
	}

	public void seteditorial_libro(String editorial_libro) {
		this.editorial_libro=editorial_libro;
	}

	public Date getaniopublicado_libro() {
		return this.aniopublicado_libro;
	}

	public void setaniopublicado_libro(Date aniopublicado_libro) {
		this.aniopublicado_libro=aniopublicado_libro;
	}

	public String getestado_libro() {
		return this.estado_libro;
	}

	public void setestado_libro(String estado_libro) {
		this.estado_libro=estado_libro;
	}

	public String getcategoria_libro() {
		return this.categoria_libro;
	}

	public void setcategoria_libro(String categoria_libro) {
		this.categoria_libro=categoria_libro;
	}

	public String getnombre_libro() {
		return this.nombre_libro;
	}

	public void setnombre_libro(String nombre_libro) {
		this.nombre_libro=nombre_libro;
	}

	public int getid_disponibilidad() {
		return this.id_disponibilidad;
	}

	public void setid_disponibilidad(int id_disponibilidad) {
		this.id_disponibilidad=id_disponibilidad;
	}

}
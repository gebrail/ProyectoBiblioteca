package VO;import java.sql.Date;


public class prestamosVO {
 
	private int id_prestamo;
	private int id_persona;
	private Date fecha_prestamo;
	private Date fechaentrega_prestamo;
	private int id_bibliotecario;

	public int getid_prestamo() {
		return this.id_prestamo;
	}

	public void setid_prestamo(int id_prestamo) {
		this.id_prestamo=id_prestamo;
	}

	public int getid_persona() {
		return this.id_persona;
	}

	public void setid_persona(int id_persona) {
		this.id_persona=id_persona;
	}

	public Date getfecha_prestamo() {
		return this.fecha_prestamo;
	}

	public void setfecha_prestamo(Date fecha_prestamo) {
		this.fecha_prestamo=fecha_prestamo;
	}

	public Date getfechaentrega_prestamo() {
		return this.fechaentrega_prestamo;
	}

	public void setfechaentrega_prestamo(Date fechaentrega_prestamo) {
		this.fechaentrega_prestamo=fechaentrega_prestamo;
	}

	public int getid_bibliotecario() {
		return this.id_bibliotecario;
	}

	public void setid_bibliotecario(int id_bibliotecario) {
		this.id_bibliotecario=id_bibliotecario;
	}

}
package VO;import java.sql.Date;


public class devolucionesVO {
 
	private int id_devolucion;
	private Date fechaentrega_devolucion;
	private int id_prestamo;

	public int getid_devolucion() {
		return this.id_devolucion;
	}

	public void setid_devolucion(int id_devolucion) {
		this.id_devolucion=id_devolucion;
	}

	public Date getfechaentrega_devolucion() {
		return this.fechaentrega_devolucion;
	}

	public void setfechaentrega_devolucion(Date fechaentrega_devolucion) {
		this.fechaentrega_devolucion=fechaentrega_devolucion;
	}

	public int getid_prestamo() {
		return this.id_prestamo;
	}

	public void setid_prestamo(int id_prestamo) {
		this.id_prestamo=id_prestamo;
	}

}
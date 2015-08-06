package VO;

public class multasVO {
 
	private int id_multa;
	private String estado_multa;
	private int id_devolucion;
	private int numerodias_multa;
	private int valor_multa;

	public int getid_multa() {
		return this.id_multa;
	}

	public void setid_multa(int id_multa) {
		this.id_multa=id_multa;
	}

	public String getestado_multa() {
		return this.estado_multa;
	}

	public void setestado_multa(String estado_multa) {
		this.estado_multa=estado_multa;
	}

	public int getid_devolucion() {
		return this.id_devolucion;
	}

	public void setid_devolucion(int id_devolucion) {
		this.id_devolucion=id_devolucion;
	}

	public int getnumerodias_multa() {
		return this.numerodias_multa;
	}

	public void setnumerodias_multa(int numerodias_multa) {
		this.numerodias_multa=numerodias_multa;
	}

	public int getvalor_multa() {
		return this.valor_multa;
	}

	public void setvalor_multa(int valor_multa) {
		this.valor_multa=valor_multa;
	}

}
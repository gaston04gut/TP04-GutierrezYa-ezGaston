package ar.edu.unju.fi.model;

public class Carrera {

	private String codigo;
	private String nombre;
	private int cantAnios;
	private String estado;

	public Carrera() {
		// TODO Auto-generated constructor stub
	}

	public Carrera(String codigo, String nombre, int cantAnios, String estado) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.cantAnios = cantAnios;
		this.estado = estado;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantAnios() {
		return cantAnios;
	}

	public void setCantAnios(int cantAnios) {
		this.cantAnios = cantAnios;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}

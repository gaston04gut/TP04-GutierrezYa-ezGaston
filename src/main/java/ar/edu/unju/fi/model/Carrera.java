package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

@Component
public class Carrera {

	private String codigo;
	private String nombre;
	private int cantAnios;
	private Boolean estado;

	public Carrera() {
		// TODO Auto-generated constructor stub
	}

	public Carrera(String codigo, String nombre, int cantAnios, Boolean estado) {
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

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

}
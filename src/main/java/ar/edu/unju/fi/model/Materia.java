package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

@Component
public class Materia {
	private String codigo;
	private String nombre;
	private String curso;
	private int cantidadHoras;
	private modalidad modalidad;
	private Docente docente;
	private String carrera;
	private Boolean estado;

	public Materia() {
		// TODO Auto-generated constructor stub
	}

	public Materia(String codigo, String nombre, String curso, int cantidadHoras,
			ar.edu.unju.fi.model.Materia.modalidad modalidad, Docente docente, String carrera, Boolean estado) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.curso = curso;
		this.cantidadHoras = cantidadHoras;
		this.modalidad = modalidad;
		this.docente = docente;
		this.carrera = carrera;
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

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public int getCantidadHoras() {
		return cantidadHoras;
	}

	public void setCantidadHoras(int cantidadHoras) {
		this.cantidadHoras = cantidadHoras;
	}

	public modalidad getModalidad() {
		return modalidad;
	}

	public void setModalidad(modalidad modalidad) {
		this.modalidad = modalidad;
	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	enum modalidad {
		PRESENCIAL, VIRTUAL;
	}

}

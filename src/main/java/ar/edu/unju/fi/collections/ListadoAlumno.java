package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.model.Alumno;

public class ListadoAlumno {

	public static List<Alumno> alumnos = new ArrayList<Alumno>();

	public static List<Alumno> listarAlumnos() {
		List<Alumno> alumnosTrue = new ArrayList<Alumno>();

		for (Alumno alumno : alumnos) {
			if (alumno.getEstado() == true) {
				alumnosTrue.add(alumno);
			}
		}
		return alumnosTrue;
	}

	public static Alumno buscarAlumno(String libretaU) {
		for (Alumno a : alumnos) {
			if (a.getLibretaUni().equals(libretaU)) {
				return a;
			}
		}
		return null;
	}

	public static void agregarAlumno(Alumno a) {
		a.setEstado(true);
		alumnos.add(a);
	}

	public static void modificarAlumno(Alumno alumnoMod) {
		alumnoMod.setEstado(true);
		for (int i = 0; i < alumnos.size(); i++) {
			Alumno a = alumnos.get(i);
			if (a.getLibretaUni().equals(alumnoMod.getLibretaUni())) {
				alumnos.set(i, alumnoMod);
				break;
			}
		}
	}

	public static void eliminarAlumno(String LibretaU) {
		for (int i = 0; i < alumnos.size(); i++) {
			Alumno a = alumnos.get(i);
			if (a.getLibretaUni().equals(LibretaU)) {
				a.setEstado(false);
				break;
			}
		}
	}
}

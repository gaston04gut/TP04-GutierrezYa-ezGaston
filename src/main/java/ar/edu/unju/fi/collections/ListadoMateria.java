package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.model.Materia;

public class ListadoMateria {

	public static List<Materia> materias = new ArrayList<Materia>();

	public static List<Materia> listarMaterias() {
		List<Materia> materiasTrue = new ArrayList<Materia>();
		for (Materia materia : materias) {
			if (materia.getEstado() == true) {
				materiasTrue.add(materia);
			}
		}
		return materiasTrue;
	}

	public static Materia buscarMateria(String codigo) {
		for (Materia m : materias) {
			if (m.getCodigo().equals(codigo)) {
				return m;
			}
		}
		return null;
	}

	public static void agregarMateria(Materia m) {
		m.setEstado(true);
		materias.add(m);
	}

	public static void modificarMateria(Materia materiaMod) {
		materiaMod.setEstado(true);
		for (int i = 0; i < materias.size(); i++) {
			Materia m = materias.get(i);
			if (m.getCodigo().equals(materiaMod.getCodigo())) {
				materias.set(i, materiaMod);
				break;
			}
		}
	}

	public static void eliminarMateria(String codigo) {
		for (int i = 0; i < materias.size(); i++) {
			Materia m = materias.get(i);
			if (m.getCodigo().equals(codigo)) {
				m.setEstado(false);
				break;
			}
		}
	}

}

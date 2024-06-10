package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.model.Docente;

public class ListadoDocente {

	public static List<Docente> docentes = new ArrayList<Docente>();

	public static List<Docente> listarDocentes() {
		List<Docente> docentesTrue = new ArrayList<Docente>();
		for (Docente docente : docentes) {
			if (docente.getEstado() == true) {
				docentesTrue.add(docente);
			}
		}
		return docentesTrue;
	}

	public static Docente buscarDocente(String legajo) {
		for (Docente d : docentes) {
			if (d.getLegajo().equals(legajo)) {
				return d;
			}
		}
		return null;
	}

	public static void agregarDocente(Docente d) {
		d.setEstado(true);
		docentes.add(d);
	}

	public static void modificarDocente(Docente docenteMod) {
		docenteMod.setEstado(true);
		for (int i = 0; i < docentes.size(); i++) {
			Docente d = docentes.get(i);
			if (d.getLegajo().equals(docenteMod.getLegajo())) {
				docentes.set(i, docenteMod);
				break;
			}
		}
	}

	public static void eliminarDocente(String legajo) {
		for (int i = 0; i < docentes.size(); i++) {
			Docente d = docentes.get(i);
			if (d.getLegajo().equals(legajo)) {
				d.setEstado(false);
				break;
			}
		}
	}

}

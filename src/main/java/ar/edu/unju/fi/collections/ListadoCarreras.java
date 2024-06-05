package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.model.Carrera;

public class ListadoCarreras {
	public static List<Carrera> carreras = new ArrayList<Carrera>();

	public static List<Carrera> listarCarreras() {
		List<Carrera> carrerasTrue = new ArrayList<Carrera>();

		for (Carrera carrera : carreras) {
			if (carrera.getEstado() == true) {
				carrerasTrue.add(carrera);
			}
		}
		return carrerasTrue;
	}

	public static Carrera buscarCarrera(String codigo) {
		for (Carrera c : carreras) {
			if (c.getCodigo().equals(codigo)) {
				return c;
			}
		}
		return null;
	}

	public static void agregarCarrera(Carrera c) {
		c.setEstado(true);
		carreras.add(c);
	}

	public static void modificarCarrera(Carrera carreraMod) {
		for (int i = 0; i < carreras.size(); i++) {
			Carrera c = carreras.get(i);
			if (c.getCodigo().equals(carreraMod.getCodigo())) {
				carreras.set(i, carreraMod);
				break;
			}
		}
	}

	public static void eliminarCarrera(String codigo) {
		// carreras.removeIf(carrera -> carrera.getCodigo().equals(codigo));
		for (int i = 0; i < carreras.size(); i++) {
			Carrera c = carreras.get(i);
			if (c.getCodigo().equals(codigo)) {
				c.setEstado(false);
				break;
			}
		}
	}

}

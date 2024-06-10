package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.ListadoAlumno;
import ar.edu.unju.fi.model.Alumno;

@Controller
public class AlumnoController {
	@Autowired
	Alumno nuevoAlumno = new Alumno();

	@GetMapping("/formularioAlumno")
	public ModelAndView getFormAlumno() {

		ModelAndView modelView = new ModelAndView("formAlumno");
		modelView.addObject("nuevoAlumno", nuevoAlumno);
		modelView.addObject("bandera", false);
		return modelView;
	}

	@PostMapping("/guardarAlumno")
	public ModelAndView saveAlumno(@ModelAttribute("nuevoAlumno") Alumno alumnoGuardar) {

		// guardar
		ListadoAlumno.agregarAlumno(alumnoGuardar);
		// mostrar
		ModelAndView modelView = new ModelAndView("listaDeAlumnos");
		modelView.addObject("listadoAlumnos", ListadoAlumno.listarAlumnos());

		return modelView;
	}

	@GetMapping("/eliminarAlumno/{libretaUni}")
	public ModelAndView eliminarAlumnoDelListado(@PathVariable(name = "libretaUni") String libretaUni) {
		// borrar
		ListadoAlumno.eliminarAlumno(libretaUni);

		// mostrar
		ModelAndView modelView = new ModelAndView("listaDeAlumnos");
		modelView.addObject("listadoAlumnos", ListadoAlumno.listarAlumnos());

		return modelView;
	}

	@GetMapping("/modificarAlumno/{libretaUni}")
	public ModelAndView modificarAlumnno(@PathVariable(name = "libretaUni") String libretaUni) {
		//
		nuevoAlumno = ListadoAlumno.buscarAlumno(libretaUni);

		// mostrar
		ModelAndView modelView = new ModelAndView("formAlumno");
		modelView.addObject("nuevoAlumno", nuevoAlumno);
		modelView.addObject("bandera", true);
		return modelView;
	}

	@PostMapping("/modificarAlumno")
	public ModelAndView updateAlumno(@ModelAttribute("nuevoAlumno") Alumno alumnoModificado) {

		// guardar

		ListadoAlumno.modificarAlumno(alumnoModificado);
		// mostrar el listado

		ModelAndView modelView = new ModelAndView("listaDeAlumnos");
		modelView.addObject("listadoAlumnos", ListadoAlumno.listarAlumnos());
		return modelView;
	}

	@GetMapping("/guardarAlumno")
	public ModelAndView verAlumno() {

		ModelAndView modelView = new ModelAndView("listaDeAlumnos");
		modelView.addObject("listadoAlumnos", ListadoAlumno.listarAlumnos());

		return modelView;
	}

}

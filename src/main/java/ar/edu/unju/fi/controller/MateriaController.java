package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.ListadoCarreras;
import ar.edu.unju.fi.collections.ListadoDocente;
import ar.edu.unju.fi.collections.ListadoMateria;
import ar.edu.unju.fi.model.Materia;

@Controller
public class MateriaController {
	@Autowired
	Materia nuevaMateria = new Materia();

	@GetMapping("/formularioMateria")
	public ModelAndView getFormMateria() {
		ModelAndView modelView = new ModelAndView("formMateria");
		modelView.addObject("nuevaMateria", nuevaMateria);

		modelView.addObject("listadoDocentes", ListadoDocente.listarDocentes());
		modelView.addObject("listadoCarreras", ListadoCarreras.listarCarreras());

		modelView.addObject("bandera", false);
		return modelView;
	}

	@PostMapping("/guardarMateria")
	public ModelAndView saveMateria(@ModelAttribute("nuevaMateria") Materia materiaGuardar) {
		materiaGuardar.setDocente(ListadoDocente.buscarDocente(materiaGuardar.getDocente().getLegajo()));
		materiaGuardar.setCarrera(ListadoCarreras.buscarCarrera(materiaGuardar.getCarrera().getCodigo()));
		ListadoMateria.agregarMateria(materiaGuardar);

		ModelAndView modelView = new ModelAndView("listaDeMaterias");
		modelView.addObject("listadoMaterias", ListadoMateria.listarMaterias());
		return modelView;

	}

	@GetMapping("/eliminarMateria/{codigo}")
	public ModelAndView eliminarMateria(@PathVariable(name = "codigo") String codigo) {
		ListadoMateria.eliminarMateria(codigo);

		ModelAndView modelView = new ModelAndView("listaDeMaterias");
		modelView.addObject("listadoMaterias", ListadoMateria.listarMaterias());
		return modelView;
	}

	@GetMapping("/modificarMateria/{codigo}")
	public ModelAndView modificarMateria(@PathVariable(name = "codigo") String codigo) {
		nuevaMateria = ListadoMateria.buscarMateria(codigo);

		ModelAndView modelView = new ModelAndView("formMateria");
		modelView.addObject("nuevaMateria", nuevaMateria);
		modelView.addObject("bandera", true);

		modelView.addObject("listadoDocentes", ListadoDocente.listarDocentes());
		modelView.addObject("listadoCarreras", ListadoCarreras.listarCarreras());

		return modelView;
	}

	@PostMapping("/modificarMateria")
	public ModelAndView updateMateria(@ModelAttribute("nuevaMateria") Materia materiaMod) {

		materiaMod.setDocente(ListadoDocente.buscarDocente(materiaMod.getDocente().getLegajo()));
		materiaMod.setCarrera(ListadoCarreras.buscarCarrera(materiaMod.getCarrera().getCodigo()));

		ListadoMateria.modificarMateria(materiaMod);
		ModelAndView modelView = new ModelAndView("listaDeMaterias");
		modelView.addObject("listadoMaterias", ListadoMateria.listarMaterias());
		return modelView;
	}

	@GetMapping("/guardarMateria")
	public ModelAndView verMateria() {
		ModelAndView modelView = new ModelAndView("listaDeMaterias");
		modelView.addObject("listadoMaterias", ListadoMateria.listarMaterias());
		return modelView;
	}

}

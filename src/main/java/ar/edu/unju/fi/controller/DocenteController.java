package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.ListadoDocente;
import ar.edu.unju.fi.model.Docente;

@Controller
public class DocenteController {
	@Autowired
	Docente nuevoDocente = new Docente();

	@GetMapping("/formularioDocente")
	public ModelAndView getFormDocente() {

		ModelAndView modelView = new ModelAndView("formDocente");
		modelView.addObject("nuevoDocente", nuevoDocente);
		modelView.addObject("bandera", false);
		return modelView;
	}

	@PostMapping("/guardarDocente")
	public ModelAndView saveDocente(@ModelAttribute("nuevoDocente") Docente docenteGuardar) {

		ListadoDocente.agregarDocente(docenteGuardar);

		ModelAndView modelView = new ModelAndView("listaDeDocentes");
		modelView.addObject("listadoDocentes", ListadoDocente.listarDocentes());
		return modelView;
	}

	@GetMapping("/eliminarDocente/{legajo}")
	public ModelAndView eliminarDocenteDelListado(@PathVariable(name = "legajo") String legajo) {
		ListadoDocente.eliminarDocente(legajo);

		ModelAndView modelView = new ModelAndView("listaDeDocentes");
		modelView.addObject("listadoDocentes", ListadoDocente.listarDocentes());
		return modelView;
	}

	@GetMapping("/modificarDocente/{legajo}")
	public ModelAndView modificarDocenteDelListado(@PathVariable(name = "legajo") String legajo) {
		nuevoDocente = ListadoDocente.buscarDocente(legajo);

		ModelAndView modelView = new ModelAndView("formDocente");
		modelView.addObject("nuevoDocente", nuevoDocente);
		modelView.addObject("bandera", true);
		return modelView;
	}

	@PostMapping("/modificarDocente")
	public ModelAndView updateDocente(@ModelAttribute("nuevoDocente") Docente docenteModificado) {

		// guardar
		ListadoDocente.modificarDocente(docenteModificado);

		// mostrar el listado

		ModelAndView modelView = new ModelAndView("listaDeDocentes");
		modelView.addObject("listadoDocentes", ListadoDocente.listarDocentes());
		return modelView;
	}

	@GetMapping("/guardarDocente")
	public ModelAndView verDocente() {
		ModelAndView modelView = new ModelAndView("listaDeDocentes");
		modelView.addObject("listadoDocentes", ListadoDocente.listarDocentes());
		return modelView;
	}

}

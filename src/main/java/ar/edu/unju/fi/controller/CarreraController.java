package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.ListadoCarreras;
import ar.edu.unju.fi.model.Carrera;

@Controller
public class CarreraController {

	@Autowired
	Carrera nuevaCarrera = new Carrera();

	@GetMapping("/formularioCarrera")
	public ModelAndView getFormCarrera() {

		ModelAndView modelView = new ModelAndView("formCarrera");
		modelView.addObject("nuevaCarrera", nuevaCarrera);
		modelView.addObject("bandera", false);
		return modelView;
	}

	@PostMapping("/guardarCarrera")
	public ModelAndView saveCarrera(@ModelAttribute("nuevacarrera") Carrera carreraGuardar) {

		// agregando el estado

		// guardar
		ListadoCarreras.agregarCarrera(carreraGuardar);
		// mostrar
		ModelAndView modelView = new ModelAndView("listaDeCarreras");
		modelView.addObject("listadoCarreras", ListadoCarreras.listarCarreras());

		return modelView;
	}

	@GetMapping("/eliminarCarrera/{codigo}")
	public ModelAndView eliminarCarreraDelListado(@PathVariable(name = "codigo") String codigo) {
		// borrar
		ListadoCarreras.eliminarCarrera(codigo);

		// mostrar
		ModelAndView modelView = new ModelAndView("listaDeCarreras");
		modelView.addObject("listadoCarreras", ListadoCarreras.listarCarreras());
		return modelView;
	}

	@GetMapping("/modificarCarrera/{codigo}")
	public ModelAndView modificarCarrera(@PathVariable(name = "codigo") String codigo) {
		//
		nuevaCarrera = ListadoCarreras.buscarCarrera(codigo);

		// ListadoCarreras.modificarCarrera(nuevaCarrera);
		// mostrar
		ModelAndView modelView = new ModelAndView("formCarrera");
		modelView.addObject("nuevaCarrera", nuevaCarrera);
		modelView.addObject("bandera", true);
		return modelView;
	}

	@PostMapping("/modificarCarrera")
	public ModelAndView updateCarrera(@ModelAttribute("nuevaCarrera") Carrera carreraModificada) {

		// guardar
		ListadoCarreras.modificarCarrera(carreraModificada);

		// mostrar el listado
		ModelAndView modelView = new ModelAndView("listaDeCarreras");
		modelView.addObject("listadoCarreras", ListadoCarreras.listarCarreras());

		return modelView;
	}

	@GetMapping("/guardarCarrera")
	public ModelAndView verCarrera() {

		ModelAndView modelView = new ModelAndView("listaDeCarreras");
		modelView.addObject("listadoCarreras", ListadoCarreras.listarCarreras());
		return modelView;
	}

}

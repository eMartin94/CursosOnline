package idat.edu.pe.daa2.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import idat.edu.pe.daa2.jpa.modelo.CursosModel;
import idat.edu.pe.daa2.jpa.modelo.MultimediaModel;
import idat.edu.pe.daa2.jpa.servicios.CursosService;
import idat.edu.pe.daa2.jpa.servicios.MultimediaService;

@Controller
@RequestMapping("/multimedia")
public class MultimediaController {

	@Autowired
	private MultimediaService multimediaServicio;
	
	@Autowired
	private CursosService cursosServicio;
	
	@RequestMapping("/listarMultimedia")
	public String listarMultimedia(Model model) {
		List<MultimediaModel> listaMultimedia = multimediaServicio.buscarTodo();
		model.addAttribute("listaMultimedia", listaMultimedia);
		return "/moduloMultimedia/listarMultimedia";
	}
	
	@RequestMapping("/nuevo")
	public String nuevaMultimedia(Model model) {
		MultimediaModel multimedia = new MultimediaModel();
		model.addAttribute("multimedia", multimedia);
		
		List<CursosModel> listaCursos = cursosServicio.buscarTodo();
		model.addAttribute("lstCursos", listaCursos);
		
		return "/moduloMultimedia/nuevoMultimedia";
	}
	
	@RequestMapping(value = "/guardar", method = RequestMethod.POST)
	public String crearMultimedia(@ModelAttribute("multimedia") MultimediaModel multimedia) {
		multimediaServicio.crear(multimedia);
		return "redirect:/multimedia/listarMultimedia";
	}
	
	@RequestMapping(value = "/actualizar/{id}")
	public ModelAndView editarMultimedia(@PathVariable(name= "id") int id) {
		ModelAndView mav = new ModelAndView("/moduloMultimedia/editarMultimedia");
		MultimediaModel multimedia = multimediaServicio.buscarPorID(id);
		mav.addObject("multimedia", multimedia);
		
		List<CursosModel> listaCursos = cursosServicio.buscarTodo();
		mav.addObject("lstCursos", listaCursos);
		
		return mav;
	}
	
	@RequestMapping(value = "/eliminar/{id}")
	public String eliminarMultimedia(@PathVariable(name= "id") int id) {
		multimediaServicio.borrarPorID(id);
		return "redirect:/multimedia/listarMultimedia";
	}
}

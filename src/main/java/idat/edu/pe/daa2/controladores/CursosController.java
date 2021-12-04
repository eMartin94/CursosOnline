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

import idat.edu.pe.daa2.jpa.modelo.CategoriaModel;
import idat.edu.pe.daa2.jpa.modelo.CursosModel;
import idat.edu.pe.daa2.jpa.servicios.CategoriaService;
import idat.edu.pe.daa2.jpa.servicios.CursosService;

@Controller
@RequestMapping("/cursos")
public class CursosController {

	@Autowired
	private CursosService cursosServicio;
	
	
	@Autowired
	private CategoriaService categoriaServicio;
	
	@RequestMapping("/listarCursos")
	public String listarCursos(Model model) {
		List<CursosModel> listaCursos = cursosServicio.buscarTodo();
		model.addAttribute("listaCursos", listaCursos);
		return "/moduloCursos/listarCursos";
	}
	
	@RequestMapping("/nuevo")
	public String nuevaCursos(Model model) {
		CursosModel cursos = new CursosModel();
		model.addAttribute("cursos", cursos);
		
		List<CategoriaModel> listaCategoria = categoriaServicio.buscarTodo();
		model.addAttribute("lstCategoria", listaCategoria);
		
		return "/moduloCursos/nuevaCursos";
	}
	
	@RequestMapping(value = "/guardar", method = RequestMethod.POST)
	public String crearCursos(@ModelAttribute("cursos") CursosModel cursos) {
		cursosServicio.crear(cursos);
		return "redirect:/cursos/listarCursos";
	}
	
	@RequestMapping(value = "/actualizar/{id}")
	public ModelAndView editarCursos(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("/moduloCursos/editarCursos");
		CursosModel cursos = cursosServicio.buscarPorID(id);
		mav.addObject("cursos", cursos);
	
		
		List<CategoriaModel> listaCategoria = categoriaServicio.buscarTodo();
		mav.addObject("lstCategoria", listaCategoria);
		
		return mav;
	}
	
	@RequestMapping(value = "/eliminar/{id}")
	public String eliminarCursos(@PathVariable(name = "id") int id) {
		cursosServicio.borrarPorID(id);
		return "redirect:/cursos/listarCursos";
	}
	
}

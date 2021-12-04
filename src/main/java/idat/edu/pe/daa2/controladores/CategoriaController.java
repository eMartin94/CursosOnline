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
import idat.edu.pe.daa2.jpa.servicios.CategoriaService;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaServicio;
	
	@RequestMapping("/listarCategoria")
	public String listarCategorias(Model model) {
		List<CategoriaModel> listaCategorias = categoriaServicio.buscarTodo();
		model.addAttribute("listaCategorias", listaCategorias);
		return "/moduloCategoria/listarCategoria";
	}
	
	@RequestMapping("/nuevo")
	public String nuevaCategoria(Model model) {
		CategoriaModel categoria = new CategoriaModel();
		model.addAttribute("categoria", categoria);
		return "/moduloCategoria/nuevaCategoria";
	}
	
	@RequestMapping(value = "/guardar", method = RequestMethod.POST)
	public String crearCategoria(@ModelAttribute("categoria") CategoriaModel categoria) {
		categoriaServicio.crear(categoria);
		return "redirect:/categorias/listarCategoria";
	}
	
	@RequestMapping(value = "/actualizar/{id}")
	public ModelAndView editarCategoria(@PathVariable(name= "id") int id) {
		ModelAndView mav = new ModelAndView("/moduloCategoria/editarCategoria");
		CategoriaModel categoria = categoriaServicio.buscarPorID(id);
		mav.addObject("categoria", categoria);
		return mav;
	}
	
	@RequestMapping(value = "/eliminar/{id}")
	public String eliminarCategoria(@PathVariable(name= "id") int id) {
		categoriaServicio.borrarPorID(id);
		return "redirect:/categorias/listarCategoria";
	}
}

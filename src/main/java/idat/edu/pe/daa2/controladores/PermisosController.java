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

import idat.edu.pe.daa2.jpa.modelo.PermisosModel;
import idat.edu.pe.daa2.jpa.servicios.PermisosService;

@Controller
@RequestMapping("/permisos")
public class PermisosController {

	@Autowired
	private PermisosService permisosServicio;
	
	@RequestMapping("/listarPermisos")
	public String listarPermisos(Model model) {
		List<PermisosModel> listaPermisos = permisosServicio.buscarTodo();
		model.addAttribute("listaPermisos", listaPermisos);
		return "/moduloPermisos/listarPermisos";
	}
	
	@RequestMapping("/nuevo")
	public String nuevaPermisos(Model model) {
		PermisosModel permisos = new PermisosModel();
		model.addAttribute("permisos", permisos);
		return "/moduloPermisos/nuevoPermisos";
	}
	
	@RequestMapping(value = "/guardar", method = RequestMethod.POST)
	public String crearPermisos(@ModelAttribute("permisos") PermisosModel permisos) {
		permisosServicio.crear(permisos);
		return "redirect:/permisos/listarPermisos";
	}
	
	@RequestMapping(value = "/actualizar/{id}")
	public ModelAndView editarPermisos(@PathVariable(name= "id") int id) {
		ModelAndView mav = new ModelAndView("/moduloPermisos/editarPermisos");
		PermisosModel permisos = permisosServicio.buscarPorID(id);
		mav.addObject("permisos", permisos);
		return mav;
	}
	
	@RequestMapping(value = "/eliminar/{id}")
	public String eliminarPermisos(@PathVariable(name= "id") int id) {
		permisosServicio.borrarPorID(id);
		return "redirect:/permisos/listarPermisos";
	}
}

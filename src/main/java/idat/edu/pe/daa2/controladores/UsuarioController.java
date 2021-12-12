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
import idat.edu.pe.daa2.jpa.modelo.UsuarioModel;
import idat.edu.pe.daa2.jpa.servicios.PermisosService;
import idat.edu.pe.daa2.jpa.servicios.UsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioServicio;
	
	@Autowired
	private PermisosService permisosServicio;
	
	@RequestMapping("/listarUsuario")
	public String listarUsuarios(Model model) {
		List<UsuarioModel> listaUsuarios = usuarioServicio.buscarTodo();
		model.addAttribute("listaUsuarios", listaUsuarios);
		return "/moduloUsuario/listarUsuario";
	}
	
	@RequestMapping("/nuevo")
	public String nuevaUsuario(Model model) {
		UsuarioModel usuario = new UsuarioModel();
		model.addAttribute("usuario", usuario);
		
		List<PermisosModel> listaPermisos = permisosServicio.buscarTodo();
		model.addAttribute("lstPermisos", listaPermisos);
		
		return "/moduloUsuario/nuevoUsuario";
	}
	
	@RequestMapping(value = "/guardar", method = RequestMethod.POST)
	public String crearUsuario(@ModelAttribute("usuario") UsuarioModel usuario) {
		usuarioServicio.crear(usuario);
		return "redirect:/usuarios/listarUsuario";
	}
	
	@RequestMapping(value = "/actualizar/{id}")
	public ModelAndView editarUsuario(@PathVariable(name= "id") int id) {
		ModelAndView mav = new ModelAndView("/moduloUsuario/editarUsuario");
		UsuarioModel usuario = usuarioServicio.buscarPorID(id);
		mav.addObject("usuario", usuario);
		
		List<PermisosModel> listaPermisos = permisosServicio.buscarTodo();
		mav.addObject("lstPermisos", listaPermisos);
		
		return mav;
	}
	
	@RequestMapping(value = "/eliminar/{id}")
	public String eliminarUsuario(@PathVariable(name= "id") int id) {
		usuarioServicio.borrarPorID(id);
		return "redirect:/usuarios/listarUsuario";
	}
}

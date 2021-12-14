package idat.edu.pe.daa2.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import idat.edu.pe.daa2.jpa.modelo.PermisosModel;
import idat.edu.pe.daa2.jpa.modelo.UsuarioModel;
import idat.edu.pe.daa2.jpa.repositorios.UsuarioRepository;
import idat.edu.pe.daa2.jpa.servicios.PermisosService;

@Controller
public class AppController {

	@Autowired
	private UsuarioRepository usuarioRepo;
	
	private PermisosService permisosServicio;
	
	@GetMapping("/register")
	public String formRegristro(Model model) {
		model.addAttribute("user", new UsuarioModel());
		List<PermisosModel> listaPermisos = permisosServicio.buscarTodo();
		model.addAttribute("lstPermisos", listaPermisos);
		return "formRegistro";
	}
	
	@PostMapping("/process_register")
	public String processRegister(UsuarioModel user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getContrasena());
		user.setContrasena(encodedPassword);
		
		usuarioRepo.save(user);
		
		return "index";
	}
}

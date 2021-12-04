package idat.edu.pe.daa2.controladores.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import idat.edu.pe.daa2.jpa.modelo.CategoriaModel;
import idat.edu.pe.daa2.jpa.servicios.CategoriaService;

@RestController
@RequestMapping("/rest/categorias")
public class CategoriaRestController {

	@Autowired
	private CategoriaService servicioCategoria;
	
	@GetMapping
	public ResponseEntity<Object> buscarTodo(){
		List<CategoriaModel> lstCategoria = servicioCategoria.buscarTodo();
		return new ResponseEntity<Object>(lstCategoria, HttpStatus.OK);
	}
}

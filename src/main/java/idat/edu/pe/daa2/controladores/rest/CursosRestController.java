package idat.edu.pe.daa2.controladores.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import idat.edu.pe.daa2.jpa.modelo.CursosModel;
import idat.edu.pe.daa2.jpa.servicios.CursosService;

@RestController
@RequestMapping("/rest/cursos")
public class CursosRestController {

	@Autowired
	private CursosService servicioCursos;
	
	@GetMapping
	public ResponseEntity<Object> buscarTodo(){
		List<CursosModel> lstCursos = servicioCursos.buscarTodo();
		return new ResponseEntity<Object>(lstCursos, HttpStatus.OK);
	}
}

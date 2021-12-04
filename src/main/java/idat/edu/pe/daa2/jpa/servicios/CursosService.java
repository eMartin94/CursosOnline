package idat.edu.pe.daa2.jpa.servicios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idat.edu.pe.daa2.jpa.modelo.CursosModel;
import idat.edu.pe.daa2.jpa.repositorios.CursosRepository;

@Service
@Transactional
public class CursosService {

	@Autowired
	private CursosRepository cursosRepositorio;
	
	public CursosService() {
		
	}
	
	//Listar
	public List<CursosModel> buscarTodo(){
		return (List<CursosModel>) cursosRepositorio.findAll();
	}
	
	//Crear
	public CursosModel crear(CursosModel cursos) {
		return cursosRepositorio.save(cursos);
	}
	
	//Actualizar
	public CursosModel actualizar(CursosModel cursosActualizar) {
		CursosModel cursosActual = cursosRepositorio.findById(cursosActualizar.getIdCursos()).get();
		cursosActual.setIdCursos(cursosActualizar.getIdCursos());
		cursosActual.setNomCurso(cursosActualizar.getNomCurso());
		cursosActual.setDescripCurso(cursosActualizar.getDescripCurso());
		cursosActual.setPrecio(cursosActualizar.getPrecio());
		
		CursosModel cursosActualizado = cursosRepositorio.save(cursosActual);
		return cursosActualizado;
	}
	
	//Buscar
	public CursosModel buscarPorID(Integer id) {
		return cursosRepositorio.findById(id).get();
	}
	
	//Eliminar
	public void borrarPorID(Integer id) {
		cursosRepositorio.deleteById(id);
	}
}

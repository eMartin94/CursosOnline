package idat.edu.pe.daa2.jpa.servicios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idat.edu.pe.daa2.jpa.modelo.MultimediaModel;
import idat.edu.pe.daa2.jpa.repositorios.MultimediaRepository;

@Service
@Transactional
public class MultimediaService {

	@Autowired
	private MultimediaRepository multimediaRepositorio;
	
	public MultimediaService() {
		
	}
	
	//Listar
	public List<MultimediaModel> buscarTodo(){
		return (List<MultimediaModel>) multimediaRepositorio.findAll();
	}
	
	//Crear
	public MultimediaModel crear(MultimediaModel multimedia) {
		return multimediaRepositorio.save(multimedia);
	}
	
	//Actualizar
	public MultimediaModel actualizar(MultimediaModel multimediaActualizar) {
		MultimediaModel multimediaActual = multimediaRepositorio.findById(multimediaActualizar.getIdMultimedia()).get();
		multimediaActual.setIdMultimedia(multimediaActualizar.getIdMultimedia());
		multimediaActual.setDescripcion(multimediaActualizar.getDescripcion());					
		multimediaActual.setFecSubida(multimediaActualizar.getFecSubida());
		
		MultimediaModel multimediaActualizado = multimediaRepositorio.save(multimediaActual);
		return multimediaActualizado;
	}
	
	//Buscar
	public MultimediaModel buscarPorID(Integer id) {
		return multimediaRepositorio.findById(id).get();
	}
	
	//Eliminar
	public void borrarPorID(Integer id) {
		multimediaRepositorio.deleteById(id);
	}
}


package idat.edu.pe.daa2.jpa.servicios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idat.edu.pe.daa2.jpa.modelo.CategoriaModel;
import idat.edu.pe.daa2.jpa.repositorios.CategoriaRepository;

@Service
@Transactional
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepositorio;
	
	public CategoriaService() {
		
	}
	
	public List<CategoriaModel> buscarTodo(){
		return (List<CategoriaModel>) categoriaRepositorio.findAll();
	}
	
	public CategoriaModel crear(CategoriaModel categoria) {
		return categoriaRepositorio.save(categoria);
	}
	
	public CategoriaModel actualizar(CategoriaModel categoriaActualizar) {
		CategoriaModel categoriaActual = categoriaRepositorio.findById(categoriaActualizar.getIdCategoria()).get();
		categoriaActual.setIdCategoria(categoriaActualizar.getIdCategoria());
		categoriaActual.setNomCategoria(categoriaActualizar.getNomCategoria());
		
		CategoriaModel categoriaActualizado = categoriaRepositorio.save(categoriaActual);
		return categoriaActualizado;
	}
	
	public CategoriaModel buscarPorID(Integer id) {
		return categoriaRepositorio.findById(id).get();
	}
	
	public void borrarPorID(Integer id) {
		categoriaRepositorio.deleteById(id);
	}
}

package idat.edu.pe.daa2.jpa.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import idat.edu.pe.daa2.jpa.modelo.CategoriaModel;

public interface CategoriaRepository extends CrudRepository<CategoriaModel, Integer>{

	@Query(value = "SELECT c FROM CategoriaModel c WHERE c.nomCategoria = ?1")
	public List<CategoriaModel> buscarCategoriaPorNomCategoria(String nomCategoria);
	
	@Query(value = "SELECT c FROM CategoriaModel c WHERE c.nomCategoria like CONCAT(?1, '%')")
	public List<CategoriaModel> buscarCategoriaLikeNomCategoria(String nomCategoria);
}

package idat.edu.pe.daa2.jpa.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import idat.edu.pe.daa2.jpa.modelo.CursosModel;



public interface CursosRepository extends CrudRepository<CursosModel, Integer>{

	@Query(value = "SELECT c FROM CursosModel c WHERE c.nomCurso = ?1")
	public List<CursosModel> buscarCursosPorNomCurso(String nomCurso);
	
	@Query(value = "SELECT c FROM CursosModel c WHERE c.nomCurso like CONCAT(?1, '%')")
	public List<CursosModel> buscarCursosLikeNomCurso(String nomCurso);
	
	//Nombre del curso que coincida
	@Query(value = "Select c from CursosModel c where c.nomCurso like %?1%")
	public List<CursosModel> findCursoByNameLike(String nomCurso);
}

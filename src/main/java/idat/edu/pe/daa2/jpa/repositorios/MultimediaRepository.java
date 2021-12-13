package idat.edu.pe.daa2.jpa.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import idat.edu.pe.daa2.jpa.modelo.MultimediaModel;

public interface MultimediaRepository extends CrudRepository<MultimediaModel, Integer>{

	@Query(value = "SELECT m FROM MultimediaModel m WHERE m.descripcion = ?1")
	public List<MultimediaModel> buscarMultimediaPorDescripcion(String descripcion);
	
	@Query(value = "SELECT m FROM MultimediaModel m WHERE m.descripcion like CONCAT(?1, '%')")
	public List<MultimediaModel> buscarMultimediaLikeDescripcion(String descripcion);
}

package idat.edu.pe.daa2.jpa.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import idat.edu.pe.daa2.jpa.modelo.PermisosModel;

public interface PermisosRepository extends CrudRepository<PermisosModel, Integer>{

	@Query(value = "SELECT p FROM PermisosModel p WHERE p.nomPermiso = ?1")
	public List<PermisosModel> buscarCategoriaPorNomPermiso(String nomPermiso);
	
	@Query(value = "SELECT p FROM PermisosModel p WHERE p.nomPermiso like CONCAT(?1, '%')")
	public List<PermisosModel> buscarCategoriaLikeNomPermiso(String nomPermiso);
}

package idat.edu.pe.daa2.jpa.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import idat.edu.pe.daa2.jpa.modelo.UsuarioModel;

public interface UsuarioRepository extends CrudRepository<UsuarioModel, Integer>{

//	@Query(value = "SELECT p FROM UsuarioModel p WHERE p.correo = ?1")
//	public List<UsuarioModel> buscarUsuarioPorCorreo(String correo);
	
	@Query(value = "SELECT p FROM UsuarioModel p WHERE p.correo = ?1")
	public UsuarioModel findByCorreo(String correo);
	
//	@Query(value = "SELECT p FROM UsuarioModel p WHERE p.correo like CONCAT(?1, '%')")
//	public List<UsuarioModel> buscarUsuarioLikeNombre(String correo);
}

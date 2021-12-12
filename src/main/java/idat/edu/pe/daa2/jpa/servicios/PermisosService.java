package idat.edu.pe.daa2.jpa.servicios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idat.edu.pe.daa2.jpa.modelo.PermisosModel;
import idat.edu.pe.daa2.jpa.repositorios.PermisosRepository;

@Service
@Transactional
public class PermisosService {

	@Autowired
	private PermisosRepository permisosRepositorio;
	
	public PermisosService() {
		
	}
	
	public List<PermisosModel> buscarTodo(){
		return (List<PermisosModel>) permisosRepositorio.findAll();
	}
	public PermisosModel crear(PermisosModel permisos) {
		return permisosRepositorio.save(permisos);
	}
	
	public PermisosModel actualizar(PermisosModel permisosActualizar) {
		PermisosModel permisosActual = permisosRepositorio.findById(permisosActualizar.getIdPermisos()).get();
		permisosActual.setIdPermisos(permisosActualizar.getIdPermisos());
		permisosActual.setNomPermiso(permisosActualizar.getNomPermiso());
		
		PermisosModel permisosActualizado = permisosRepositorio.save(permisosActual);
		return permisosActualizado;
	}
	
	public PermisosModel buscarPorID(Integer id) {
		return permisosRepositorio.findById(id).get();
	}
	
	public void borrarPorID(Integer id) {
		permisosRepositorio.deleteById(id);
	}
	
}

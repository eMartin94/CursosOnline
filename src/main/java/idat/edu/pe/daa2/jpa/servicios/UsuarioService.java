package idat.edu.pe.daa2.jpa.servicios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idat.edu.pe.daa2.jpa.modelo.UsuarioModel;
import idat.edu.pe.daa2.jpa.repositorios.UsuarioRepository;

@Service
@Transactional
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepositorio;
	
	public UsuarioService() {
		
	}
	
	//Listar
	public List<UsuarioModel> buscarTodo(){
		return (List<UsuarioModel>) usuarioRepositorio.findAll();
	}
	
	//Crear
	public UsuarioModel crear(UsuarioModel usuario) {
		return usuarioRepositorio.save(usuario);
	}
	
	//Actualizar
	public UsuarioModel actualizar(UsuarioModel usuarioActualizar) {
		UsuarioModel usuarioActual = usuarioRepositorio.findById(usuarioActualizar.getIdUsuario()).get();
		usuarioActual.setIdUsuario(usuarioActualizar.getIdUsuario());
		usuarioActual.setNombre(usuarioActualizar.getNombre());
		usuarioActual.setNomUsuario(usuarioActualizar.getNomUsuario());
		usuarioActual.setCorreo(usuarioActualizar.getCorreo());
		usuarioActual.setContrasena(usuarioActualizar.getContrasena());
		usuarioActual.setFecRegistro(usuarioActualizar.getFecRegistro());
		usuarioActual.setFecNacimiento(usuarioActualizar.getFecNacimiento());
		usuarioActual.setSexo(usuarioActualizar.getSexo());
		
		UsuarioModel usuarioActualizado = usuarioRepositorio.save(usuarioActual);
		return usuarioActualizado;
	}
	
	//Buscar
	public UsuarioModel buscarPorID(Integer id) {
		return usuarioRepositorio.findById(id).get();
	}
	
	//Eliminar
	public void borrarPorID(Integer id) {
		usuarioRepositorio.deleteById(id);
	}
}

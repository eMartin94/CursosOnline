package idat.edu.pe.daa2.jpa.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


import idat.edu.pe.daa2.AppDetails.AppUsuarioDetails;

import idat.edu.pe.daa2.jpa.modelo.UsuarioModel;
import idat.edu.pe.daa2.jpa.repositorios.UsuarioRepository;

public class AppUsuarioDetailsService implements UserDetailsService{

	@Autowired
	private UsuarioRepository usuarioRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		
		UsuarioModel user = usuarioRepo.findByCorreo(username);
		if(user == null) {
			throw new UsernameNotFoundException("User not found");
		}
		return new AppUsuarioDetails(user);
	}
}

package idat.edu.pe.daa2.AppDetails;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import idat.edu.pe.daa2.jpa.modelo.UsuarioModel;

public class AppUsuarioDetails implements UserDetails {

	private static final long serialVersionUID = 1L;
	private UsuarioModel user;
	
	public AppUsuarioDetails(UsuarioModel user) {
		this.user = user;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities(){
		return null;
	}
	
	@Override
	public String getPassword() {
		return user.getContrasena();
	}
	
	@Override
	public String getUsername() {
		return user.getCorreo();
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	
	@Override
	public boolean isEnabled() {
		return true;
	}
	
	public String getFullName() {
		return user.getNombre();
	}
	
}

package idat.edu.pe.daa2.control.configuraciones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class WebSecurityConf extends WebSecurityConfigurerAdapter{

	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
		.antMatchers("/css/**", "/imagenes/**", "/js/**", "/", "/principal", "/home", "/inicio", "/logeo", "/bienvenida", "/login","/rest/**")
		.permitAll()
		.antMatchers("/permisos/listarTodo").hasAnyRole("ADMIN","LECTOR","CREADOR","EDITOR","DEPURADOR")
		.antMatchers("/permisos/nuevo").hasAnyRole("ADMIN","CREADOR")
		.antMatchers("/permisos/guardar").hasAnyRole("ADMIN","CREADOR","EDITOR")
		.antMatchers("/permisos/actualizar/**").hasAnyRole("ADMIN","EDITOR")
		.antMatchers("/permisos/eliminar/**").hasAnyRole("ADMIN","DEPURADOR")
		
		.antMatchers("/cursos/listarCurso").hasAnyRole("ADMIN","LECTOR","CREADOR","EDITOR","DEPURADOR")
		.antMatchers("/cursos/nuevo").hasAnyRole("ADMIN","CREADOR")
		.antMatchers("/cursos/guardar").hasAnyRole("ADMIN","CREADOR","EDITOR")
		.antMatchers("/cursos/actualizar/**").hasAnyRole("ADMIN","EDITOR")
		.antMatchers("/cursos/eliminar/**").hasAnyRole("ADMIN","DEPURADOR")
		
		.antMatchers("/usuarios/listarUsuario").hasAnyRole("ADMIN","LECTOR","CREADOR","EDITOR","DEPURADOR")
		.antMatchers("/usuarios/nuevo").hasAnyRole("ADMIN","CREADOR")
		.antMatchers("/usuarios/guardar").hasAnyRole("ADMIN","CREADOR","EDITOR")
		.antMatchers("/usuarios/actualizar/**").hasAnyRole("ADMIN","EDITOR")
		.antMatchers("/usuarios/eliminar/**").hasAnyRole("ADMIN","DEPURADOR")
		
		.antMatchers("/categorias/listarCategoria").hasAnyRole("ADMIN","LECTOR","CREADOR","EDITOR","DEPURADOR")
		.antMatchers("/categorias/nuevo").hasAnyRole("ADMIN","CREADOR")
		.antMatchers("/categorias/guardar").hasAnyRole("ADMIN","CREADOR","EDITOR")
		.antMatchers("/categorias/actualizar/**").hasAnyRole("ADMIN","EDITOR")
		.antMatchers("/categorias/eliminar/**").hasAnyRole("ADMIN","DEPURADOR")
		
	
		.anyRequest().authenticated()
		.and().formLogin().loginPage("/login").defaultSuccessUrl("/bienvenida", true).permitAll()
		.and().logout()
		.permitAll();

	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		auth.inMemoryAuthentication().withUser("admin").password(encoder.encode("admin")).roles("ADMIN").and()
		.withUser("martin").password(encoder.encode("martin")).roles("LECTOR").and();

	}
}

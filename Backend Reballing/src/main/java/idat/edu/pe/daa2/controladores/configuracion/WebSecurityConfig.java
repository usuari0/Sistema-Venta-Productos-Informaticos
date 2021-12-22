package idat.edu.pe.daa2.controladores.configuracion;

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
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable();
		http.authorizeRequests()
		.antMatchers("/login","/**")
		.permitAll()
		.antMatchers("/categoria/listarTodo").hasAnyRole("ADMIN","CLIENTE")
		.antMatchers("/categoria/obtener").hasAnyRole("ADMIN")
		.antMatchers("/categoria/nuevo").hasAnyRole("ADMIN")
		.antMatchers("/categoria/actualizar").hasAnyRole("ADMIN")
		.antMatchers("/categoria/eliminar").hasAnyRole("ADMIN")
		.antMatchers("/tipo_usuario/listarTodo").hasAnyRole("ADMIN")
		.antMatchers("/tipo_usuario/obtener").hasAnyRole("ADMIN")
		.antMatchers("/tipo_usuario/nuevo").hasAnyRole("ADMIN")
		.antMatchers("/tipo_usuario/actualizar").hasAnyRole("ADMIN")
		.antMatchers("/tipo_usuario/eliminar").hasAnyRole("ADMIN")
		
		.anyRequest().authenticated()
		.and().formLogin().loginPage("/login").defaultSuccessUrl("/inicio", true).permitAll()
		.and().logout()
		.permitAll();

	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		auth.inMemoryAuthentication().withUser("admin").password(encoder.encode("admin")).roles("ADMIN").and()
		.withUser("cliente").password(encoder.encode("cliente")).roles("CLIENTE").and();
	}
}

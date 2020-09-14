package com.chachalopez.PryCertificacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.chachalopez.PryCertificacion.security.LoginSuccessHandler;
import com.chachalopez.PryCertificacion.services.UsuarioService;




@Configuration
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UsuarioService service;
	
	@Autowired
	private LoginSuccessHandler handler;
		
	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
		
	@Autowired //Authetication
	public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception
	{	
		build.userDetailsService(service).passwordEncoder(encoder());		
	}
	
	@Override //Autorization
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/","/css/**","/fonts/**","/images/**","/js/**","/php/**","/vendor/**").permitAll()
			.antMatchers("/cliente/**").hasAnyRole("USER")
			.antMatchers("/capital/**").hasAnyRole("ADMIN")
			.antMatchers("/usuario/**").anonymous()
			.antMatchers("/cuenta/**").hasAnyRole("USER")
			.antMatchers("/deposito/**").hasAnyRole("USER","ADMIN")
			.antMatchers("/deposito/rptDeposito").hasAnyRole("ADMIN")
			.antMatchers("/retiro/**").hasAnyRole("USER","ADMIN")
			.antMatchers("/retiro/rptRetiro").hasAnyRole("ADMIN")
			.antMatchers("/prestamo/**").hasAnyRole("USER")
			.antMatchers("/tipoprestamo/**").hasAnyRole("ADMIN")
			.antMatchers("/reportes/**").hasAnyRole("ADMIN")
			.antMatchers("/tipocuenta/**").hasAnyRole("ADMIN")
			.antMatchers("/photos/profesores/**").hasAnyRole("USER")
			.antMatchers("/h2-console/**").hasAnyRole("ADMIN")
			.anyRequest().authenticated()
			.and().formLogin().permitAll()	
			.and().formLogin().successHandler(handler).loginPage("/login").permitAll()			
			.and().logout().permitAll()			
			.and().exceptionHandling().accessDeniedPage("/error_403")
			.and()
				.csrf().ignoringAntMatchers("/h2-console/**")
			.and()
				.headers().frameOptions().sameOrigin();
	}

}



package com.io.badri.vehicles.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig 
extends WebSecurityConfigurerAdapter  {
	
	@Override
	protected void configure(HttpSecurity http) 
			throws Exception {
		http
		.csrf().disable()
		.authorizeRequests()
		.antMatchers(
				"/admin/login", 				
				"/resources/**", 
				"/static/**",
				"/templates/**",
				"/css/**", 
				"/fonts/**", 
				"/img/**").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/admin/login").permitAll()
		.defaultSuccessUrl("/admin")
		.and()
		.logout().invalidateHttpSession(true)
		.clearAuthentication(true)
		.logoutRequestMatcher(new AntPathRequestMatcher("/admin/logout"))
		.logoutSuccessUrl("/admin/login").permitAll();
	}
	
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return NoOpPasswordEncoder.getInstance();
//	}	
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	public UserDetailsService userDetailsService() {
	    return super.userDetailsService();
	}
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();		
		provider.setUserDetailsService(userDetailsService);	
        //provider.setPasswordEncoder(passwordEncoder());
		provider.setPasswordEncoder(bcryptPasswordEncoder());
		return provider;
	}
	
	 @Bean
     public BCryptPasswordEncoder bcryptPasswordEncoder() {
         return new BCryptPasswordEncoder();
     }
}
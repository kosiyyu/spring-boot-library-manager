package com.proj.library.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter{

	DataSource dataSource;
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public WebSecurityConfiguration(DataSource dataSource, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.dataSource = dataSource;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
		.usersByUsernameQuery("select username, password, enabled from user_ where username = ?")
		.authoritiesByUsernameQuery("select username, role from user_ where username = ?")
		.dataSource(dataSource)
		.passwordEncoder(bCryptPasswordEncoder);//decryption from db
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		
		.antMatchers("/books/info", "/books/info/**").permitAll()
		.antMatchers("/books", "/books/**").hasAnyAuthority("ADMIN", "USER")
		.antMatchers("/authors","/authors/**").hasAnyAuthority("ADMIN", "USER")
		//.antMatchers("/register","register/**").hasAnyAuthority("ADMIN")
		.and()
			.formLogin()
				.loginPage("/login")
		.and()
			.logout();
		
		
	}	
	
}

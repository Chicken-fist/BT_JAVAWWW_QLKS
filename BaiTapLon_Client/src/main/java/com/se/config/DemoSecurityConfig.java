package com.se.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter{
	
	
	@SuppressWarnings("deprecation")
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		UserBuilder users = User.withDefaultPasswordEncoder();
		auth.inMemoryAuthentication()
				.withUser(users.username("dang").password("test111").roles("EMPLOYEE"))
				.withUser(users.username("cuong").password("test222").roles("EMPLOYEE", "MANAGER"))
				.withUser(users.username("tri").password("test333").roles("MANAGER","ADMIN", "EMPLOYEE"));
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/resources/css/**").permitAll()
			.antMatchers("/resources/bootstrap/**").permitAll()
			.antMatchers("/resources/jquery/**").permitAll()
			.antMatchers("/resources/fonts/**").permitAll()
			.antMatchers("/").permitAll()
			.antMatchers("/reservation/**").permitAll()
			.antMatchers("/bill/**").permitAll()
			.antMatchers("/showNhanVien/**").hasRole("ADMIN")
			.antMatchers("/service/**").hasRole("MANAGER")
			.antMatchers("/category/**").hasRole("MANAGER")
			.antMatchers("/nhanvien/**").hasRole("EMPLOYEE")
			.anyRequest().authenticated()
			.and().formLogin()
				.loginPage("/showMyLoginPage")
				.loginProcessingUrl("/authenticateTheUser")
				.permitAll()
			.and().logout()
				.permitAll()
			.and()
				.exceptionHandling().accessDeniedPage("/access-denied");
	}

}

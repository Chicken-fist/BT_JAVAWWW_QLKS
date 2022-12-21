//package com.iuh.config;
//
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.provisioning.JdbcUserDetailsManager;
//import org.springframework.security.provisioning.UserDetailsManager;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    // add a reference to our security data source
//    @Autowired
//    private DataSource securityDataSource;
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//        // use jdbc authentication ... oh yeah!!!
//        auth.jdbcAuthentication().dataSource(securityDataSource);
//
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
////** matches zero or more 'directories' in a path
//        http
//        .authorizeRequests()
//                //* matches zero or more characters
//                .antMatchers("/resources/css/**").permitAll()
//                .antMatchers("/resources/bootstrap/**").permitAll()
//                .antMatchers("/resources/jquery/**").permitAll()
//                .antMatchers("/resources/fonts/**").permitAll()
//                .antMatchers("/hotel").permitAll()
////                .antMatchers("/hotel/employees").permitAll()
////                .antMatchers("/hotel/customers").permitAll()
////                .antMatchers("/hotel/services").permitAll()
//                .antMatchers("/hotel/rooms").hasRole("ADMIN")
//                
//                .antMatchers("/hotel/categories").permitAll()
////                .antMatchers("/hotel/reservations").permitAll()
////                .antMatchers("/hotel/bills").permitAll()
////                //** matches zero or more 'directories' in a path
////                .antMatchers("/person/**").hasRole("EMPLOYEE")
////                .antMatchers("/creditcard/**").hasRole("EMPLOYEE")
////                .antMatchers("/employees").permitAll()
////                .antMatchers("/rooms").permitAll()
////                .antMatchers("/services").permitAll()
////                .antMatchers("/categories").permitAll()
////                .antMatchers("/resources/**").permitAll()
////                .antMatchers("/").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginProcessingUrl("/authenticateTheUser").loginPage("/showMyLoginPage")
//                .permitAll()
//                .and()
////                .logout().permitAll()
////                .and()
//                .exceptionHandling().accessDeniedPage("/access-denied");
//
//    }
//
//    @Bean
//    public UserDetailsManager userDetailsManager() {
//
//        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager();
//
//        jdbcUserDetailsManager.setDataSource(securityDataSource);
//
//        return jdbcUserDetailsManager;
//    }
//
//}

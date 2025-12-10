package com.example.security.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	
	@Bean
	public UserDetailsManager userDetailsManager(DataSource dataSource) { 
	JdbcUserDetailsManager theUserDetailsManager = new JdbcUserDetailsManager(dataSource);
	
	theUserDetailsManager
	.setUsersByUsernameQuery("select user_id , password, active from members where user_id=?");
	
	theUserDetailsManager
	.setAuthoritiesByUsernameQuery("select user_id, role from roles where user_id=?");
	
	return theUserDetailsManager;
	}
	

//	@Bean
//	public UserDetailsManager userDetailsManager(DataSource dataSource) {
//		
//	return new JdbcUserDetailsManager(dataSource);
//	
//	}
	
	

//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager() {
//        UserDetails anmol = User.builder()
//                .username("anmol")
//                .password("{noop}anmol@123")
//                .roles("EMPLOYEE")
//                .build();
//
//        UserDetails satyajeet = User.builder()
//                .username("satyajeet")
//                .password("{noop}satyajeet@123")
//                .roles("EMPLOYEE", "MANAGER")
//                .build();
//
//        UserDetails satwik = User.builder()
//                .username("satwik")
//                .password("{noop}satwik@123")
//                .roles("EMPLOYEE", "MANAGER", "ADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(anmol, satyajeet, satwik);
//    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(config -> config
                .requestMatchers(HttpMethod.GET, "/api/emps").hasRole("EMPLOYEE")
                .requestMatchers(HttpMethod.GET, "/api/emps/**").hasRole("EMPLOYEE")
                .requestMatchers(HttpMethod.POST, "/api/emps").hasRole("MANAGER")
                .requestMatchers(HttpMethod.DELETE, "/api/emps/**").hasRole("ADMIN")
        );

        http.httpBasic(Customizer.withDefaults());
        
        http.csrf(csrf -> csrf.disable());
        
        return http.build();
    }
    
    
}



















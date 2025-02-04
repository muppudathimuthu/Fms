package com.login.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.fms.services.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
@Autowired
private UserService userService;

    @Bean
    BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}


    @Bean
    DaoAuthenticationProvider authenticationProvider()
    {
    	DaoAuthenticationProvider auth=new DaoAuthenticationProvider();
    	auth.setUserDetailsService( (UserDetailsService) userService);
    	auth.setPasswordEncoder(passwordEncoder());
		return auth;
    	
    }
    
    
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
    	auth.authenticationProvider(authenticationProvider());
    }
    
    
    
    
	
	@Override
	  protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Disable CSRF (you can keep it enabled for production)
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers("/login", "/registration").permitAll()  // Allow login/signup without authentication
                        .anyRequest().authenticated())
                .formLogin(login -> login
                        .loginPage("/login")  // Custom login page
                        .loginProcessingUrl("/registration")  // Custom login form submission URL
                        .permitAll())
                .logout(logout -> logout
                        .permitAll()); // Allow logout without authentication
    }
	
}
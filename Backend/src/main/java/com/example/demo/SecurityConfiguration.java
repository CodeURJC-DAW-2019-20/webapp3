package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

//import es.urjc.code.security.UserRepositoryAuthenticationProvider;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
    public UserRepositoryAuthenticationProvider authenticationProvider;
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        
    	
    	// Public pages
        http.authorizeRequests().antMatchers("/").permitAll();
        http.authorizeRequests().antMatchers("/index").permitAll();
        http.authorizeRequests().antMatchers("/infomail").permitAll();
        http.authorizeRequests().antMatchers("/log").permitAll();
        http.authorizeRequests().antMatchers("/product").permitAll();
        http.authorizeRequests().antMatchers("/store").permitAll();
        http.authorizeRequests().antMatchers("/error").permitAll();
        
        
        
        //Public Folders
        http.authorizeRequests().antMatchers("/css/*").permitAll();
        http.authorizeRequests().antMatchers("/fonts/*").permitAll();
        http.authorizeRequests().antMatchers("/img/*").permitAll();
        http.authorizeRequests().antMatchers("/js/*").permitAll();

        // Private pages 
        http.authorizeRequests().antMatchers("/profile").authenticated();
        http.authorizeRequests().antMatchers("/checkout").authenticated();
        http.authorizeRequests().antMatchers("/likeit").authenticated();
        

        // Login form
        http.formLogin().loginPage("/log");
        http.formLogin().usernameParameter("username");
        http.formLogin().passwordParameter("password"); //Verificar si funciona
        http.formLogin().defaultSuccessUrl("/profile");
        http.formLogin().failureUrl("/error");

        // Logout
       
        http.logout().logoutUrl("/logout"); 
        http.logout().logoutSuccessUrl("/").permitAll();
        
        // Disable CSRF at the moment
        http.csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth)throws Exception {    	
    	
        // Users
    	auth.authenticationProvider(authenticationProvider);
    }

}

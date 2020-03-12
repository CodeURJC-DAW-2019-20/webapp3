package com.swapitServer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.swapitServer.user.UserRepositoryAuthenticationProvider;

@Configuration
@Order(1)
public class RestSecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Autowired
    public UserRepositoryAuthenticationProvider authenticationProvider;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.antMatcher("/api/**");
		
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/logIn").authenticated();
		
		// UserREST URLs that need authentication to access to it
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/user/").hasRole("USER");
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/user/all").hasRole("ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/user/all/page").hasRole("ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.PUT, "/api/user/addLikeIt").hasRole("USER");
		http.authorizeRequests().antMatchers(HttpMethod.PUT, "/api/user/update").hasRole("USER");
		http.authorizeRequests().antMatchers(HttpMethod.DELETE, "/api/user/update").hasRole("ADMIN");		
		
		// ProductREST URLs that need authentication to access to it
		http.authorizeRequests().antMatchers(HttpMethod.PUT, "/api/product/validate").hasRole("ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.PUT, "/api/product/modify").hasRole("ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.DELETE, "/api/product/modify").hasRole("ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/product/prestock").hasRole("ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/product/prestock/page").hasRole("ADMIN");
		
		// SuggestionREST URLs that need authentication to access to it
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/suggestion/").hasRole("ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/suggestion/page").hasRole("ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.DELETE, "/api/suggestion/").hasRole("ADMIN");
		
		// TransactionREST URLs that need authentication to access to it
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/transaction/").hasRole("USER");
		
		// Other URLs can be accessed without authentication
		http.authorizeRequests().anyRequest().permitAll();

		// Disable CSRF protection (it is difficult to implement in REST APIs)
		http.csrf().disable();

		// Use Http Basic Authentication
		http.httpBasic();

		// Do not redirect when logout
		http.logout().logoutSuccessHandler((rq, rs, a) -> {	});
	}
	
    @Override
    protected void configure(AuthenticationManagerBuilder auth)throws Exception {    	
    	
        // Users
    	auth.authenticationProvider(authenticationProvider);
    }
}

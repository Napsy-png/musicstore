package harkkatyo.musicstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// set config to auth object
		auth.inMemoryAuthentication()
		.withUser("Admin")
		.password(passwordEncoder().encode("admin"))
		.roles("ADMIN")
		.and()
		.withUser("User")
		.password(passwordEncoder().encode("user"))
		.roles("USER");
		
	}
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
		
	}

	
	/* @Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
		.antMatchers("/").permitAll()
		.antMatchers("/edit/{id}", "/delete/{id}", "/addLP").hasRole("ADMIN")
		.and().formLogin();
	}
	
*/
}
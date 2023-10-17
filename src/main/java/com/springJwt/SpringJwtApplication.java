package com.springJwt;

import com.springJwt.service.UserDetailsServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SpringJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJwtApplication.class, args);

	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
		return builder.getAuthenticationManager();
	}
	@Bean
	public UserDetailsService getuserDetailsService() {
		return new UserDetailsServiceImpl();
	}


}

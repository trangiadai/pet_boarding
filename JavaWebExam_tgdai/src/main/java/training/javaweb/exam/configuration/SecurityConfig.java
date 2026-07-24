package training.javaweb.exam.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable())
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.authorizeHttpRequests(auth -> auth
						.requestMatchers(
								"/v3/api-docs/**", 
								"/swagger-ui/**", 
								"/swagger-ui.html"
								).permitAll()
						.requestMatchers("/owners/**").hasRole("ADMIN")
						.requestMatchers("/pets/my-pets").hasRole("CUSTOMER")
						.requestMatchers("/pets/**").hasRole("ADMIN")
						.requestMatchers("/boarding-records/my-active").hasRole("CUSTOMER")
						.requestMatchers("/boarding-records/my-history").hasRole("CUSTOMER")
						.requestMatchers("/boarding-records/**").hasRole("ADMIN")
						.requestMatchers(HttpMethod.POST, "/care-notes").hasRole("ADMIN")
						.requestMatchers(HttpMethod.GET, "/care-notes/record/**").hasAnyRole("ADMIN", "CUSTOMER")
						.requestMatchers("/dashboard/**").hasRole("ADMIN")
						.anyRequest().authenticated())
				.httpBasic(Customizer.withDefaults());

		return http.build();
	}
}
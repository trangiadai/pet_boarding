package training.javaweb.exam.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;

import jakarta.servlet.http.HttpServletResponse;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

	@Bean
	AuthenticationEntryPoint noPopupEntryPoint() {
		return (request, response, authException) -> {
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			response.setContentType("application/json");
			response.getWriter().write("{\"message\":\"Unauthorized\"}");
		};
	}

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable())
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.authorizeHttpRequests(auth -> auth
						.requestMatchers("/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html").permitAll()
						.requestMatchers("/", "/css/**", "/js/**").permitAll()

						.requestMatchers("/owners/**").hasRole("ADMIN")

						.requestMatchers(HttpMethod.GET, "/pets/my-pets").hasRole("CUSTOMER")
						.requestMatchers(HttpMethod.GET, "/pets/filter").hasRole("ADMIN")
						.requestMatchers(HttpMethod.GET, "/pets/search").hasRole("ADMIN")
						.requestMatchers(HttpMethod.GET, "/pets/{id}").hasAnyRole("ADMIN", "CUSTOMER")
						.requestMatchers("/pets/**").hasRole("ADMIN")

						.requestMatchers(HttpMethod.GET, "/boarding-records/my-active").hasRole("CUSTOMER")
						.requestMatchers(HttpMethod.GET, "/boarding-records/my-history").hasRole("CUSTOMER")
						.requestMatchers(HttpMethod.GET, "/boarding-records/active").hasRole("ADMIN")
						.requestMatchers(HttpMethod.GET, "/boarding-records/pet/**").hasRole("ADMIN")
						.requestMatchers(HttpMethod.GET, "/boarding-records/owner/**").hasRole("ADMIN")
						.requestMatchers(HttpMethod.POST, "/boarding-records/filter").hasRole("ADMIN")
						.requestMatchers(HttpMethod.POST, "/boarding-records/check-out").hasRole("ADMIN")
						.requestMatchers(HttpMethod.POST, "/boarding-records/search").hasRole("ADMIN")
						.requestMatchers(HttpMethod.GET, "/boarding-records/{id}").hasAnyRole("ADMIN", "CUSTOMER")
						.requestMatchers("/boarding-records/**").hasRole("ADMIN")

						.requestMatchers(HttpMethod.POST, "/care-notes").hasRole("ADMIN")
						.requestMatchers(HttpMethod.GET, "/care-notes/record/**").hasAnyRole("ADMIN", "CUSTOMER")

						.requestMatchers("/dashboard/**").hasRole("ADMIN").anyRequest().authenticated())
				.httpBasic(basic -> basic.authenticationEntryPoint(noPopupEntryPoint()));

		return http.build();
	}
}
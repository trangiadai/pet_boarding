package training.javaweb.exam.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Bean
	SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf(csrf -> csrf.disable()).authorizeHttpRequests(auth -> auth.anyRequest().permitAll())
				.formLogin(form -> form.disable()).httpBasic(basic -> basic.disable());

		return httpSecurity.build();
	}
}

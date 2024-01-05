package de.camovation.rauchboxapi.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Bean
  public PasswordEncoder encoder() {
    return new BCryptPasswordEncoder(11);
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.csrf(csrf -> csrf
        .disable())
        .cors(cors -> {
        })
        .authorizeHttpRequests(auth -> auth
            .requestMatchers("/v1/**") .permitAll())
            //.authenticated())
        .authorizeHttpRequests(auth1 -> auth1
            .anyRequest().permitAll())
        .httpBasic(httpBasic -> {
        })
        .sessionManagement(sessionManagement -> sessionManagement
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
       // .addFilterBefore(new AuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    ;
    return http.build();
  }

  @Bean
  public CorsConfigurationSource corsConfigurationSource() {
    CorsConfiguration configuration = new CorsConfiguration();

    // Erlauben Sie Anfragen von Ihrer Angular-Anwendung (http://localhost:4200)
    configuration.addAllowedOrigin("http://localhost:4200");
    configuration.addAllowedHeader("*"); // Erlauben Sie alle Header
    configuration.addAllowedMethod("OPTIONS"); // Erlauben Sie OPTIONS-Anfragen
    configuration.addAllowedMethod("GET");
    configuration.addAllowedMethod("POST");
    configuration.addAllowedMethod("PUT");
    configuration.addAllowedMethod("DELETE");

    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", configuration);

    return source;
  }
}

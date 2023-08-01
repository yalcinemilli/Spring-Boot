package de.camovation.rauchboxapi.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

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
          .authorizeHttpRequests( auth -> auth
          .requestMatchers("/v1/**").permitAll())
   //       .authenticated())
          .authorizeHttpRequests(auth1 -> auth1
          .anyRequest().permitAll())
          .httpBasic(httpBasic -> {})
          .sessionManagement(sessionManagement -> sessionManagement
          .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//          .addFilterBefore(new AuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
;
        return http.build();
    }
}

package aristosoft.api.config;

import org.springframework.context.annotation.*;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.*;

import aristosoft.api.auth.jwt.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

        private final JwtAuthenticationFilter jwtAuthenticationFilter;
        private final AuthenticationProvider authProvider;

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                http
                                .csrf(csrf -> csrf.disable())
                                .authorizeHttpRequests(authRequest -> authRequest
                                                .requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
                                                .antMatchers("/api/v1/auth/**").permitAll()
                                                .antMatchers("/api/v1/user/**").authenticated()
                                                .antMatchers("/api/v1/category/public/**").permitAll()
                                                .antMatchers("/api/v1/product/public/**").permitAll()
                                                .antMatchers("/api/v1/order/**").permitAll()
                                                .anyRequest().authenticated())

                                .headers(headers -> headers
                                                .frameOptions(frameOptions -> frameOptions.disable()))

                                .cors(cors -> {
                                        CorsConfigurationSource configurationSource = request -> {
                                                CorsConfiguration config = new CorsConfiguration();
                                                config.addAllowedOrigin("*");
                                                config.addAllowedHeader("*");
                                                config.addAllowedMethod("*");
                                                return config;
                                        };
                                        cors.configurationSource(configurationSource);
                                });

                http.sessionManagement(sessionManager -> sessionManager
                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                                .authenticationProvider(authProvider)
                                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

                return http.build();
        }
}

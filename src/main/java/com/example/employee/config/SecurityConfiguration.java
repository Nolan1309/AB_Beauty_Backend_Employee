package com.example.employee.config;

import com.example.employee.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    private JwtFilter jwtFilter;
    
    @Autowired
    private EmployeeServiceImpl userDetailsService;
    
    @Autowired
    private CorsFilter corsFilter;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }
    
    private static final String[] WHITE_LIST_URL = {
        "/swagger-ui/index.html", 
        "/swagger-ui/**", 
        "/webjars/**", 
        "/swagger-ui.html", 
        "/api/auth/**",
        "/api/test/**", 
        "/authenticate" 
    };
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // Thêm bộ lọc CORS trước bộ lọc JWT
            .addFilterBefore(corsFilter, UsernamePasswordAuthenticationFilter.class)
            .cors(Customizer.withDefaults())  // Bật rõ ràng cấu hình CORS
            .authorizeHttpRequests(
                config -> config
                    .requestMatchers(WHITE_LIST_URL).permitAll()
                    .requestMatchers(HttpMethod.GET, Endpoint.PUBLIC_GET_ENDPOINT).permitAll()
                    .requestMatchers(HttpMethod.POST, Endpoint.PUBLIC_POST_ENDPOINT).permitAll()
                    .requestMatchers(HttpMethod.PUT, Endpoint.PUBLIC_PUT_ENDPOINT).permitAll()
                    .requestMatchers(HttpMethod.DELETE, Endpoint.PUBLIC_DELETE_ENDPOINT).permitAll()

                    .requestMatchers(HttpMethod.GET, Endpoint.USER_GET_ENDPOINT).hasAnyAuthority("USER", "ADMIN")
                    .requestMatchers(HttpMethod.POST, Endpoint.USER_POST_ENDPOINT).hasAnyAuthority("USER", "ADMIN")
                    .requestMatchers(HttpMethod.PUT, Endpoint.USER_PUT_ENDPOINT).hasAnyAuthority("USER", "ADMIN")
                    .requestMatchers(HttpMethod.DELETE, Endpoint.USER_DELETE_ENDPOINT).hasAnyAuthority("USER", "ADMIN")

                    .requestMatchers(HttpMethod.GET, Endpoint.ADMIN_GET_ENDPOINT).hasAuthority("ADMIN")
                    .requestMatchers(HttpMethod.POST, Endpoint.ADMIN_POST_ENDPOINT).hasAuthority("ADMIN")
                    .requestMatchers(HttpMethod.DELETE, Endpoint.ADMIN_DELETE_ENDPOINT).hasAuthority("ADMIN")
                    .requestMatchers(HttpMethod.PUT, Endpoint.ADMIN_PUT_ENDPOINT).hasAuthority("ADMIN")
                    .anyRequest().authenticated()
            );
        
        // Thêm bộ lọc JWT sau bộ lọc CORS
        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
        http.sessionManagement((session) -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.csrf(csrf -> csrf.disable());
        http.httpBasic(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.authenticationProvider(authenticationProvider());
        return authenticationManagerBuilder.build();
    }
}
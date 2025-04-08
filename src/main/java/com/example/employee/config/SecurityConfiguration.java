package com.example.employee.config;

import com.example.employee.service.EmployeeServiceImpl;
import com.example.employee.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.DELETE;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.HttpMethod.PUT;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
public class SecurityConfiguration {

    @Autowired
    private JwtFilter jwtFilter;
    @Autowired
    private EmployeeServiceImpl userDetailsService;  // Inject vào UserDetailsService

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
    private static final String[] WHITE_LIST_URL = {"/swagger-ui/index.html",   "/swagger-ui/**", "/webjars/**", "/swagger-ui.html", "/api/auth/**",
            "/api/test/**", "/authenticate" };
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
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
        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class); // Đảm bảo JwtFilter hoạt động
        http.sessionManagement((session) -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));  // Không sử dụng session
        http.csrf(csrf -> csrf.disable()); // Tắt CSRF nếu sử dụng JWT
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
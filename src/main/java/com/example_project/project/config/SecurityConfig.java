package com.example_project.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.context.annotation.Configuration;

//para la configuración d elos user
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration

@EnableWebSecurity
public class SecurityConfig {

        // Método en carga
        @Bean
        public UserDetailsService userDetailsService() {

                PasswordEncoder passwordEncoder = bCryptPasswordEncoder();
                String encodedPassword1 = passwordEncoder.encode("user123");
                String encodedPassword2 = passwordEncoder.encode("admin123");
                InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();

                manager.createUser(User.withUsername("user")
                                .password(encodedPassword1)
                                .roles("USER")
                                .build());
                manager.createUser(User.withUsername("admin")
                                .password(encodedPassword2)
                                .roles("ADMIN")
                                .build());

                return manager;
        }

        @Bean
        public BCryptPasswordEncoder bCryptPasswordEncoder() {
                return new BCryptPasswordEncoder();
        }

        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

                http.httpBasic().and()
                                .authorizeHttpRequests()
                                // para el controlador de aplicacion
                                .requestMatchers(HttpMethod.GET, "/swagger-ui/index.html#/").hasAnyRole("USER", "ADMIN")
                                .requestMatchers(HttpMethod.GET, "/api/v1/application/**").hasRole("USER")
                                .requestMatchers(HttpMethod.PUT, "/api/v1/application/**").hasAnyRole("USER",
                                                "ADMIN")
                                .requestMatchers(HttpMethod.POST, "/api/v1/application/**").hasRole("ADMIN")
                                // para el controlador de servidores
                                .requestMatchers(HttpMethod.GET, "/api/v1/server/**").hasRole("USER")
                                .requestMatchers(HttpMethod.PUT, "/api/v1/server/**").hasAnyRole("USER",
                                                "ADMIN")
                                .requestMatchers(HttpMethod.POST, "/api/v1/server/**").hasRole("ADMIN")
                                .and()
                                .csrf().disable();
                return http.build();

        }

}
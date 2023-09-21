package com.example.Project3.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.persistence.Column;

/**
 * Configuration class for Spring Security.
 * This class defines the security configuration for your application, including authentication, authorization,
 * and security filter chains. It also specifies URL patterns, session management, and CSRF protection settings.
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration {

    /**
     * returns encripted password
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    private MyCustomerDetailsService myCustomerDetailsService;
    public void setMyCustomerDetailsService(MyCustomerDetailsService myCustomerDetailsService){
        this.myCustomerDetailsService=myCustomerDetailsService;
    }

    @Bean
    public JwtRequestFilter authJwtRequestFilter() {
        return new JwtRequestFilter();
    }


    /**
     * Configure security filter chain.
     * @param http The HttpSecurity object to configure.
     * @return A SecurityFilterChain configured for your application.
     * @throws Exception If configuration setup encounters an error.
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/auth/customers", "/auth/customers/login/", "/auth/customers/register/").permitAll()
                .antMatchers("/h2-console/**").permitAll()
                .antMatchers(HttpMethod.POST, "/api/products/").permitAll() // Allow POST requests to this endpoint
                .antMatchers(HttpMethod.GET, "/api/products/**").permitAll()// Require authentication for GET
                .antMatchers(HttpMethod.PUT, "/api/products/**").permitAll() // Require ADMIN role for PUT
                .antMatchers(HttpMethod.DELETE, "/api/products/**").hasRole("ADMIN") // Require ADMIN role for DELETE
                .anyRequest().authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .csrf().disable()
                .headers().frameOptions().disable();

        http.addFilterBefore(authJwtRequestFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
//           .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

    /**
     * Bean definition for the AuthenticationManager.
     * @param authConfig The AuthenticationConfiguration used to obtain the AuthenticationManager.
     * @return An AuthenticationManager bean for authentication purposes.
     * @throws Exception If obtaining the AuthenticationManager encounters an error.
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

}

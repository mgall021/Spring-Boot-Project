package com.example.Project3.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Column;

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


}

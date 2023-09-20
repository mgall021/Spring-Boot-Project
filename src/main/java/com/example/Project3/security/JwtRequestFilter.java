package com.example.Project3.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.util.logging.Logger;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {
    Logger logger = Logger.getLogger(JwtRequestFilter.class.getName());
    private JWTUtils jwtUtils;

    private MyCustomerDetailsService myCustomerDetailsService;
@Autowired
    public void setMyCustomerDetailsService(MyCustomerDetailsService myCustomerDetailsService){
        this.myCustomerDetailsService=myCustomerDetailsService;
    }
@Autowired
    public void setJwtUtils(JWTUtils jwtUtils) {
        this.jwtUtils = jwtUtils;
    }


}

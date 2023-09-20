package com.example.Project3.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * Filter for processing JWT authentication in incoming requests.
 * This class is responsible for intercepting incoming HTTP requests, extracting and validating JWT tokens,
 * and setting up the user's authentication context if the token is valid. It extends OncePerRequestFilter
 * to ensure that the filtering logic is executed once per incoming request.
 */
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
    /**
     * Parse a JWT token from the HTTP request's "Authorization" header.
     * This method extracts and returns a JWT token from the "Authorization" header of an HTTP request
     * if it exists and is in the expected "Bearer" format.
     * @param request The HttpServletRequest object representing the incoming HTTP request.
     * @return The JWT token extracted from the "Authorization" header, or null if not found or not in the expected format.
     */
    private String parseJwt(HttpServletRequest request) {
        String headerAuth = request.getHeader("Authorization");
        if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
            return headerAuth.substring(7, headerAuth.length());
        }
        return null;
    }
    /**
     * Perform JWT token authentication and set the user's authentication context.
     * This method intercepts incoming HTTP requests, extracts and validates a JWT token from the request's headers,
     * and sets the user's authentication context if the token is valid.
     * @param request The HttpServletRequest object representing the incoming HTTP request.
     * @param response The HttpServletResponse object representing the outgoing HTTP response.
     * @param filterChain The FilterChain for processing the request and response.
     * @throws ServletException If an error occurs during servlet processing.
     * @throws IOException If an I/O error occurs.
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            String jwt = parseJwt(request);
            if (jwt != null && jwtUtils.validateJwtToken(jwt)) {
                String customerName = jwtUtils.getCustomerNameFromJwtToken(jwt);
                UserDetails userDetails = this.myCustomerDetailsService.loadUserByUsername(customerName); // email address
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        } catch (Exception e) {
            logger.info("cannot set user authentication token");
        }
        filterChain.doFilter(request, response);
    }
}




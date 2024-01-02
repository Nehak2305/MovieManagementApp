package com.bej.authenticationservice.authenticationservice.Filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //casting servlet request and response to http servlet request and response as our request
        // and response is in http
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //whatever token is created is kept by authheader and prefixed by bearer
        String authHeader =request.getHeader("Authorization");
        if(authHeader == null ||!authHeader.startsWith("Bearer")){
            throw new ServletException("Invalid or Missing Token");
        }
        else{
            String token = authHeader.substring(7);//token will start from 7th position of authheader
            //because 1st 6 letter is bearer
            Claims claims = Jwts.parser().setSigningKey("neha").parseClaimsJws(token).getBody();//parsing into claims
            request.setAttribute("claims",claims);
            filterChain.doFilter(request,response);
        }
    }
}

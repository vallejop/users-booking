package com.example.usersbooking.security;

import com.example.usersbooking.model.Operator;
import com.example.usersbooking.service.auth.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/** Class to filter all request to validate the user is authenticated
 * @author Jaime Eduardo Falla
 * @author Nelson Vallejo
* */
@Component
public class JwtFilterRequest extends OncePerRequestFilter {
    @Autowired
    private JWTGenerate jwtGenerate;

    @Autowired
    private IAuthService service;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String authorizationHeader =request.getHeader("Authorization");
        if(authorizationHeader !=null && authorizationHeader.startsWith("Bearer")){
            String jwt = authorizationHeader.substring(7);
            String email = jwtGenerate.getEmail(jwt);
            if(email != null && SecurityContextHolder.getContext().getAuthentication()==null){
                Operator operator =service.findByEmail(email);
                if(jwtGenerate.validateToken(jwt,operator)){
                    SecurityContextHolder.getContext().setAuthentication(new TokenAuthentication(jwt,email,null));
                    request.setAttribute("claims",jwtGenerate.getClaim(jwt));
                    request.setAttribute("subject",jwtGenerate.getClaim(jwt));
                    request.setAttribute("roles",jwtGenerate.getClaim(jwt));
                }
            }
        }
        filterChain.doFilter(request,response);
    }
}

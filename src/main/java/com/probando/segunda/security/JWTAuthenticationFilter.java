
package com.probando.segunda.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, 
                                                                         HttpServletResponse response) throws AuthenticationException {
        AuthCredentials authCred = new AuthCredentials();
        try{
                    authCred = new ObjectMapper().readValue(request.getReader(), AuthCredentials.class);
        }catch (IOException e){}
        
        UsernamePasswordAuthenticationToken userPAT = new UsernamePasswordAuthenticationToken(
                authCred.getUser(), authCred.getPassword(), Collections.emptyList());
        
        return getAuthenticationManager().authenticate(userPAT);
    }
    
    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                       HttpServletResponse response,
                                       FilterChain chain,
                                       Authentication authResult) throws IOException, ServletException {
        UserDetailsImpl userDetails = (UserDetailsImpl) authResult.getPrincipal();
        String token = TokenUtils.createToken(userDetails.getUsername());

        Map<String, String> responseObject = new HashMap<>();
        responseObject.put("token", token);

        response.setStatus(HttpStatus.OK.value());
        response.getWriter().write(new ObjectMapper().writeValueAsString(responseObject));
        response.getWriter().flush();
        response.getWriter().close();

        super.successfulAuthentication(request, response, chain, authResult);
}

    /*@Override
    protected void successfulAuthentication(HttpServletRequest request, 
                                                                    HttpServletResponse response, 
                                                                    FilterChain chain, 
                                                                    Authentication authResult) throws IOException, ServletException {
        UserDetailsImpl userDetails = (UserDetailsImpl) authResult.getPrincipal();
        String token = TokenUtils.createToken(userDetails.getUsername());
        
        response.getWriter().write("lalalalala");
        response.addHeader("Authorization","Bearer " + token);
        response.getWriter().flush();
        
        super.successfulAuthentication(request, response, chain, authResult);
    }*/
}

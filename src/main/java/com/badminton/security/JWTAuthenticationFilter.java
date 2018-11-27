package com.badminton.security;

import com.badminton.entity.UserEntity;
import lombok.extern.slf4j.Slf4j;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@Slf4j
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter{

    //    public interface AuthenticationManager Processes an Authentication request.
    private AuthenticationManager authManager;


    JWTAuthenticationFilter(AuthenticationManager authManager) {
        this.authManager = authManager;
    }

    /*attemptAuthentication: where we parse the user's credentials and issue them to the AuthenticationManager.*/

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {
        try{
            UserEntity creds = new ObjectMapper()
                    .readValue(request.getInputStream(), UserEntity.class);
            return authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            creds.getUsername(),
                            creds.getPassword(),
                            new ArrayList<>())
            );
        }  catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /*successfulAuthentication: which is the method called when a user successfully logs in.*/
    /*We use this method to generate a JWT for this user.*/

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {
        String token = Jwts.builder()
                .setSubject(((UserEntity) authResult.getPrincipal()).getUsername())
                .setExpiration(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME))
                .setHeaderParam("principal", authResult.getPrincipal())
                .signWith(SignatureAlgorithm.HS512, SecurityConstants.SECRET.getBytes())
                .compact();

        response.addHeader(SecurityConstants.HEADER, SecurityConstants.TOKEN_PREFIX + token);

        response.getWriter().write(token);

        //  response.addHeader(HEADER_STRING, TOKEN_PREFIX + " " + SecurityConstants.generateToken(((User)authResult.getPrincipal()).getUsername()));

    }
}


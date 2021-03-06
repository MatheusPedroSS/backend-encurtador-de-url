package com.pedro.backendencurtadordeurl.security;

import java.util.Collections;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class TokenAuthenticationService {
    
    static final long EXPIRATION_TIME = 86000000;
    static final String SECRET = "ajdajajjfeu@fjrn#423";
    static final String TOKEN_PREFIX = "Bearer";
    static final String HEADER_STRING = "Authorization";

    static void addAuthentication(HttpServletResponse res, String username) {
        String JWT = Jwts.builder()
                        .setSubject(username)
                        .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                        .signWith(SignatureAlgorithm.HS512, SECRET)
                        .compact();
        res.addHeader(HEADER_STRING, TOKEN_PREFIX + " " + JWT);
    }

    static Authentication getAuthentication(HttpServletRequest req) {
        String token = req.getHeader(HEADER_STRING);

        if(token != null) {
            String user = Jwts.parser()
                            .setSigningKey(SECRET)
                            .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                            .getBody()
                            .getSubject();
            
            if (user != null) {
                return new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList());
            }
        }
        
        return null;
    }
}

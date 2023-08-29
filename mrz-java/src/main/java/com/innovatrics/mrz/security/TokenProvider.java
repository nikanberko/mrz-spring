package com.innovatrics.mrz.security;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;
import java.io.Serializable;
import java.util.function.Function;

@Component
public class TokenProvider implements Serializable {
    public String getUsernameFromToken(final String token) {
        System.out.println("entered get username");
        return getClaimFromToken(token, Claims::getSubject);
    }


    public <T> T getClaimFromToken(final String token, final Function<Claims, T> claimsResolver) {
        System.out.println("entered get claim");
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    public Claims getAllClaimsFromToken(final String token) {
        System.out.println(token);
        return Jwts.parser()
                .setSigningKey("secret-key".getBytes())
                .parseClaimsJws(token)
                .getBody();
    }
}


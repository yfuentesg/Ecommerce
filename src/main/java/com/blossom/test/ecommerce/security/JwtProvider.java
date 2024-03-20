package com.blossom.test.ecommerce.security;

import com.blossom.test.ecommerce.database.model.User;
import com.blossom.test.ecommerce.dto.TokenDTO;
import io.jsonwebtoken.Claims;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtProvider {

    @Value("${jwt.secret}")
    private String secret;

    @PostConstruct
    protected void init(){
        secret = Base64.getEncoder().encodeToString(secret.getBytes());
    }

    public TokenDTO createToken(User user) {
        Map<String, Object> claims = new HashMap<>();
        claims = Jwts.claims().setSubject(user.getName());
        claims.put("id", user.getId());
        claims.put("email", user.getEmail());
        //claims.put("role","ADMINROLE");
        Date now = new Date();
        Date exp = new Date(now.getTime() + 60000); /*60 sg*/
        return TokenDTO.builder().token(Jwts.builder()
                                        .setClaims(claims)
                                        .setIssuedAt(now)
                                        .setExpiration(exp)
                                        .signWith(SignatureAlgorithm.HS256,secret)
                                        .compact())
                .build();
    }

    public boolean validateToken(String token, UserDetails user){
        try{
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
        } catch (Exception e){
            return false;
        }

        return getUserNameFromToken(token).equals(user.getUsername());
    }

    public String getUserNameFromToken(String token){
        try{
            return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
        }catch (Exception exception){
            return "Bad token";
        }
    }

    public String extractUsername(String token){
        return extractClaims(token, Claims::getSubject);
    }

    public <T> T extractClaims(String token, Function<Claims,T> claimsResolver){
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public Claims extractAllClaims(String token){
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

}

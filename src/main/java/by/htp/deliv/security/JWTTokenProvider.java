package by.htp.deliv.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;

import java.security.Key;
import java.util.Date;
import java.util.UUID;

import io.jsonwebtoken.SignatureAlgorithm;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class JWTTokenProvider {

    String secret = "asdfSFS34wfsdfsdfSDSD32dfsddDDerQSNCK34SOWEK5354fdgdf4";           //genkey

    Key hmacKey = new SecretKeySpec(Base64.getDecoder().decode(secret),             
                            SignatureAlgorithm.HS256.getJcaName());                     //codek


    public JWTTokenProvider(){}

    public String generateJWT(String login){

        Date now = new Date(System.currentTimeMillis());        //time now
        Date expiryDate = new Date(now.getTime() + 600000);     //life cicle of token
        
        String jwtToken = Jwts.builder()
        .claim("login", login)                             
        .setSubject(login.toLowerCase())                 //тема токена                    
        .setId(UUID.randomUUID().toString())
        .setIssuedAt(now)
        .setExpiration(expiryDate).signWith(hmacKey)
        .compact();
        return jwtToken;
    }

    public boolean validateJWT(){
        return true;
    }

    public String parseJWToken(String token){
        Jws<Claims> jwt = Jwts.parserBuilder()
        .setSigningKey(hmacKey)
        .build()
        .parseClaimsJws(token);

        return jwt.getBody().get("login").toString();
    }
}

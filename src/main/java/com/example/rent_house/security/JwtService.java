package com.example.rent_house.security;


import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class JwtService {
    private static final String SECRET_KEY = "123456789";
    private static final long EXPIRE_TIME = 86400000000L;
    private static final Logger logger = LoggerFactory.getLogger(JwtService.class.getName());

    public String generateTokenLogin(Authentication authentication) {
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();

        return Jwts.builder()
                .setSubject((userPrincipal.getUsername()))
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + EXPIRE_TIME * 1000))
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e) {
            logger.error("Invalid JWT signature -> Message: {} ", e);
        } catch (MalformedJwtException e) {
            logger.error("Invalid JWT token -> Message: {}", e);
        } catch (ExpiredJwtException e) {
            logger.error("Expired JWT token -> Message: {}", e);
        } catch (UnsupportedJwtException e) {
            logger.error("Unsupported JWT token -> Message: {}", e);
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty -> Message: {}", e);
        }
        return false;
    }

    public String getUserNameFormJwtToken(String token) {
        String userName = Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody().getSubject();
        return userName;
    }
}
    //1. Key ????? m?? ho?? token

    //2. Time s???ng c???a token

    //3. Logger cho dev fix l???i(n???u c??)

    //4. Method t???o ra toke

//4.1 Ph???i l???y ra User ??ang ????ng

//4.2 Build cho ta 1 c??i token

//5 Validation

//6 L???y username t??? token
package ir.setad.banking.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Date;


public class AuthenticationService {

    private static final long EXPIRATIONTIME =844_000_000 ;
    private static final String SIGNKEY = "465bhjbj##@";
    private static final String PREFIX = "bearer";

    static public void  addToken(HttpServletResponse res, String username){


        String JwtToken= Jwts.builder().setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis()+EXPIRATIONTIME))
                .signWith(SignatureAlgorithm.HS512,SIGNKEY)
                .compact();

        res.addHeader("Authorization",PREFIX+" "+JwtToken);
        res.addHeader("Access-Control-Expose-Headers","Authorization");


    }
}

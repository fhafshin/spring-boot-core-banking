package ir.setad.banking.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Date;


public class AuthenticationService {

    private static final long EXPIRATIONTIME =844_000_000 ;
    private static final String SIGNKEY = "119df078a51a3fe820214139acb1bc9e5bb1235cf80ae9817bc9fc391f0b4b867aacb1ce69884147e1abc75d13a90d8fecff730368daaeb9c01d40fc918b9b1c525e055d0fc2de9b5bd80484d1a8df737b6c2534592d7f80d22b54d10f6bd08ed9891c9c2e77ab810d8508084dee17fbdd01bc881f08f5835e56897fedc17366413e47c4427c1979952933b1de8974491d894fa16d8d88acb72a1ac3751c3a57e8495d917712232f9118fabdb4e8e4d560fbe26660282c77cf032644bee52b2dc61837dbef02e75a0d2620b06438b9ec521f6bd6b20fff10b9f3d2f0f970d4a532f05aba57e146c835a5c431eaa38dc6a199335804f891b1e8a6d1b3e5a16a82cae3b8fbaf35485e13ce77edef84a87d06504e7bc5bfa8666e31fc7c26ba651c17eaeb05f26e933936674f9726019b315067df5d69434bd2cb2c5a8fe4bf8714c04bce01e294078cf3f9aa438158c2adf0083113a994a2894f4f76f472dc603bad0e74245f39de4c015933c7c1e7e34b3c6fc71d8485b8d4389c54620213f60a09925ccfc0b650d88ffc6827c1e016fb063fb11c30fa83ee6567871c5b1acf49b76c624617eca84a70b01b7db3f5222c471902575700fa0afb97e2f8b1d0d3e476fb473465cc492a20117c606b69e6023b7c6a0224fb207785d2ea2d05f75fcbe947de71e411ff999a4ae5111f474bd975ff0e1bd926afe3b2a9d09d63167b0b";
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

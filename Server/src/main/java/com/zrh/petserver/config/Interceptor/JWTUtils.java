package com.zrh.petserver.config.Interceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.apache.catalina.User;
import org.json.JSONObject;

import java.util.Date;

public class JWTUtils {

    public static final long EXPIRE_TIME = 60L* 60 * 1000*25*365;

    public static final String SECRET = "SECRET";

    //签发token
    public static String createToken(JSONObject jsonObject){
        Date expireDate = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        return JWT.create()
                .withKeyId(jsonObject.getString("keyID"))
                .withAudience(jsonObject.getString("audience"))
                .withClaim("code",jsonObject.getString("code"))
                .withExpiresAt(expireDate)
                .sign(Algorithm.HMAC256(SECRET));
    }

    public static String createToken(){
        Date expireDate = new Date(System.currentTimeMillis() + EXPIRE_TIME);


        return JWT.create()
                .withKeyId(jsonObject.getString("keyID"))
                .withAudience(jsonObject.getString("audience"))
                .withExpiresAt(expireDate)
                .sign(Algorithm.HMAC256(SECRET));
    }

    //校验token
    public static boolean verify(String token){
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
            DecodedJWT decodedJWT  = verifier.verify(token);
            Date expiresAt = decodedJWT.getExpiresAt();
            String audience = decodedJWT.getAudience().get(0);

            return true;
        }catch (Exception e){
            return false;
        }
    }

}

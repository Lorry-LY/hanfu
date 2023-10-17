package com.zrh.petserver.config.Interceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.zrh.petserver.dao.UserMapper;
import jakarta.annotation.Resource;
import org.json.JSONObject;

import java.util.Date;

public class JWTUtils {

    @Resource
    private static UserMapper userMapper;

    private static final long EXPIRE_TIME = 60L*60*1000 * 25;


    //签发token
    public static String createToken(String userID,String password){
        Date expireDate = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        return JWT.create()
                .withAudience(userID)
                .withExpiresAt(expireDate)
                .sign(Algorithm.HMAC256(password));
    }

    //校验token
    public static boolean verify(String token) {
        // 获取 token 中的 user id
        String userID = JWT.decode(token).getAudience().get(0);
        JSONObject user = userMapper.findUserByUserID(userID);
        if (user == null) {
            throw new RuntimeException("用户不存在，请重新登录");
        }
        // 验证 token
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getString("password"))).build();
        jwtVerifier.verify(token);
        return true;
    }

    public static boolean isOverTime(String token) {
        long expriresAt = JWT.decode(token).getExpiresAt().getTime();
        long currentAt = new Date().getTime();
        return currentAt - expriresAt > EXPIRE_TIME;
    }

    public static String updateToken(String token) {
        // 获取 token 中的 user id
        String userID = JWT.decode(token).getAudience().get(0);
        JSONObject user = userMapper.findUserByUserID(userID);
        if (user == null)return token;
        return createToken(user.getString("userID"), user.getString("password"));
    }
}


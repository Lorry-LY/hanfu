package com.zrh.petserver.config.Interceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.zrh.petserver.dao.UserMapper;
import com.zrh.petserver.utils.annotation.PassToken;
import com.zrh.petserver.utils.annotation.UserLoginToken;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.lang.reflect.Method;

public class AuthorizeInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws Exception {
        HandlerInterceptor.super.preHandle(httpServletRequest, httpServletResponse, object);
        // 从 http 请求头中取出 token
        String token = httpServletRequest.getHeader("token");
        // 如果不是映射到方法直接通过
        if(!(object instanceof HandlerMethod)){
            return true;
        }
        HandlerMethod handlerMethod=(HandlerMethod)object;
        Method method=handlerMethod.getMethod();
        //检查是否有PassToken注释，有则跳过认证
        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                return true;
            }
        }
        //检查有没有需要用户权限的注解
        if (method.isAnnotationPresent(UserLoginToken.class)) {
            UserLoginToken userLoginToken = method.getAnnotation(UserLoginToken.class);
            if (userLoginToken.required()) {
                // 执行认证
                if (token == null) return false;
                if(!JWTUtils.verify(token))return false;
                if(JWTUtils.isOverTime(token)){
                    String new_token = JWTUtils.updateToken(token);
                    httpServletResponse.addHeader("token",new_token);
                }
            }
        }
        return true;
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse,
                                Object object, Exception exception) throws Exception {
        HandlerInterceptor.super.afterCompletion(httpServletRequest,httpServletResponse,object,exception);
    }

}

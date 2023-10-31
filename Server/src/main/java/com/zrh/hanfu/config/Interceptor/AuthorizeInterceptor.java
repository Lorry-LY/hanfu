package com.zrh.hanfu.config.Interceptor;

import com.zrh.hanfu.utils.annotation.PassToken;
import com.zrh.hanfu.utils.annotation.UserLoginToken;
import com.zrh.hanfu.utils.message.ErrorMessage;
import com.zrh.hanfu.utils.message.ResponseMessage;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.io.PrintWriter;
import java.lang.reflect.Method;

public class AuthorizeInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
        HandlerInterceptor.super.preHandle(request, response, object);

        try {

            response.setCharacterEncoding("UTF-8");

            // 从 http 请求头中取出 token
            String token = request.getHeader("token");
            // 如果不是映射到方法直接通过
            if (!(object instanceof HandlerMethod handlerMethod)) return true;

            Method method = handlerMethod.getMethod();
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
                    if (token == null || token.equals("null")) return returnError(response, new ErrorMessage("no token!!"));
                    if (!JWTUtils.verify(token)) return returnError(response, new ErrorMessage("token wrong!!"));
                    if (JWTUtils.isOverTime(token)) return returnError(response,new ErrorMessage("token overtime!!"));
                }
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return returnError(response, new ErrorMessage("token verify wrong!!"));
        }
    }


    private boolean returnError(HttpServletResponse response, ResponseMessage message) throws Exception{
        PrintWriter writer = response.getWriter();
        response.setContentType("application/json");
        writer.print(message.getMessage());
        writer.close();
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, object, modelAndView);

//        // 添加Token
//        if(!(object instanceof HandlerMethod handlerMethod))return;
//        Method method=handlerMethod.getMethod();
//        //检查是否有PassToken注释，有则跳过认证
//        if (method.isAnnotationPresent(AddToken.class)) {
//            AddToken addToken = method.getAnnotation(AddToken.class);
//            if (addToken.required()) {
//
//            }
//        }
//        // 删除Token
//        if (method.isAnnotationPresent(DeleteToken.class)) {
//            DeleteToken deleteToken = method.getAnnotation(DeleteToken.class);
//            if (deleteToken.required()) {
//
//            }
//        }


    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse,
                                Object object, Exception exception) throws Exception {
        HandlerInterceptor.super.afterCompletion(httpServletRequest,httpServletResponse,object,exception);

    }

}

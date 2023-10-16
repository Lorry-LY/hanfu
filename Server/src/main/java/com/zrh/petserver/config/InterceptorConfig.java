package com.zrh.petserver.config;

import com.zrh.petserver.config.Interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册TestInterceptor拦截器
        registry.addInterceptor(new LoginInterceptor())
                .excludePathPatterns("/api/login")				//添加不拦截的请求路径
                .excludePathPatterns("/api/loginBackend")
                .addPathPatterns("/**");						//添加需要拦截的路径
    }

}


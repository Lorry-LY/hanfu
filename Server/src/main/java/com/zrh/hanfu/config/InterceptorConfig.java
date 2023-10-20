package com.zrh.hanfu.config;

import com.zrh.hanfu.config.Interceptor.AuthorizeInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册TestInterceptor拦截器
        registry.addInterceptor(new AuthorizeInterceptor())
                //.excludePathPatterns("/api/login")				//添加不拦截的请求路径
                //.excludePathPatterns("/api/loginBackend")
                .addPathPatterns("/**");						//添加需要拦截的路径
    }

}


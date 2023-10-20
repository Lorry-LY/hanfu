package com.zrh.hanfu.utils.annotation;

import java.lang.annotation.*;


//这个注解的作用是标记类或者方法绕过token校验
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface PassToken {

    boolean required() default true;
}

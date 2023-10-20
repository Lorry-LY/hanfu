package com.zrh.hanfu.utils.annotation;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface DeleteToken {

    boolean required() default true;
}

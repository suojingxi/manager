package com.sonymm.manager.web.aop.annotaion;

import java.lang.annotation.*;

/**
 * @Author suojx(1466200463@qq.com)
 * @Date 2016/12/17 15:48
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface WebLogger {
    String value() default "";
}

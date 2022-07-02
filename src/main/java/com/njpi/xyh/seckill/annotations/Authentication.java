package com.njpi.xyh.seckill.annotations;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @author: xyh
 * @create: 2022/6/30 22:04
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface Authentication {

        String value() default "";
}

package com.njpi.xyh.seckill;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author: xyh
 * @create: 2022/6/30 16:24
 */
@SpringBootApplication
@MapperScan("com.njpi.xyh.seckill.dao")
@EnableAspectJAutoProxy // 开启aop
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }

}

package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {
        DataSourceAutoConfiguration.class,//无数据源情况下需要设置（使springboot不进行JPA配置对象实例化）
        JpaRepositoriesAutoConfiguration.class,//无数据源情况下需要设置（使springboot不进行JPA配置对象实例化）
        HibernateJpaAutoConfiguration.class//无数据源情况下需要设置（使springboot不进行hibernate配置对象实例化）
})
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}

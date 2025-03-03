package com.lqt.mvcspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude = {HibernateJpaAutoConfiguration.class})
public class MvcSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(MvcSpringApplication.class, args);
    }

}

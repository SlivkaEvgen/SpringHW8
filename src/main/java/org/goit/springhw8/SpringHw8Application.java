package org.goit.springhw8;

import org.jetbrains.annotations.NotNull;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringHw8Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(SpringHw8Application.class, args);
//        System.out.println(" \n START LOGIN = ADMIN ; PASSWORD = 123
//        \n запретить удаление / редактирование админа \n");
    }

    @Override
    protected SpringApplicationBuilder configure(@NotNull SpringApplicationBuilder application) {
        return application.sources(SpringHw8Application.class);
    }
}

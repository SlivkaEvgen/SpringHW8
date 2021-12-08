package org.goit.springhw8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SpringHw8Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(SpringHw8Application.class, args);
//        System.out.println(" \n START LOGIN = ADMIN ; PASSWORD = 123 \n запретить удаление / редактирование админа \n");
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder);
        String[] password = {"123", "Password2", "Password3"};
        for (String s : password) {
            System.out.println("Some Password  encoder = " + passwordEncoder.encode(s) + "\n");
        }
    }

    @Override
    protected SpringApplicationBuilder configure( SpringApplicationBuilder application) {
        return application.sources(SpringHw8Application.class);
    }
}

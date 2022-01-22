package org.goit.springhw8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * The type Spring hw 8 application.
 */
@SpringBootApplication
public class SpringHw8Application extends SpringBootServletInitializer {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(SpringHw8Application.class, args);
//        System.out.println(new BCryptPasswordEncoder().encode("123"));
//        System.out.println(new BCryptPasswordEncoder().encode("123"));
//        System.out.println(new BCryptPasswordEncoder().encode("123"));
        System.out.println("DEFAULT Login/Password:\n->      ADMIN/123\n->      USER/123");
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringHw8Application.class);
    }
}

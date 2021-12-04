package org.goit.springhw8.config;

import org.goit.springhw8.service.UserDtoUserDetails;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDtoUserDetails userDtoUserDetails;

    public WebSecurityConfig(UserDtoUserDetails userDtoUserDetails) {
        System.out.println("WebSecurityConfig ");
        this.userDtoUserDetails = userDtoUserDetails;
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        System.out.println("BCryptPasswordEncoder ");
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(@NotNull HttpSecurity httpSecurity) throws Exception {
        System.out.println("configure ");

        httpSecurity
                .authorizeRequests()
//                .disable()
//                .authorizeRequests()
                //Доступ только для не зарегистрированных пользователей
                .antMatchers("/registration/**").not().fullyAuthenticated()
//                .antMatchers("/login/**").not().fullyAuthenticated()
                //Доступ только для пользователей с ролью Администратор
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/add/**").hasRole("ADMIN")
                .antMatchers("/update/**").hasRole("ADMIN")
                .antMatchers("/delete/**").hasRole("ADMIN")
                .antMatchers("/new/**").hasRole("ADMIN")
                .antMatchers("/news").hasRole("USER")
                .antMatchers("/user").hasRole("USER")
                .antMatchers("/product").hasRole("USER")
                .antMatchers("/manufacturer").hasRole("USER")
                .antMatchers("/home").hasRole("USER")
                .antMatchers("/login/**").hasRole("USER")
                .antMatchers("/registration/**").hasRole("USER")
                //Доступ разрешен всем пользователей
                .antMatchers("/", "/user/*").permitAll()
                .antMatchers("/", "/role/*").permitAll()
                .antMatchers("/", "/product/*").permitAll()
                .antMatchers("/", "/manufacturer/*").permitAll()
                .antMatchers("/", "/login/**").permitAll()
                .antMatchers("/", "/registration/**").permitAll()
                .antMatchers("/home", "homeView").permitAll()
                //Все остальные страницы требуют аутентификации
                .anyRequest().authenticated()
                .and()
                //Настройка для входа в систему
                .formLogin()
                .loginPage("/login")
                //Перенарпавление на главную страницу после успешного входа
                .defaultSuccessUrl("/home")
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/home")
                .permitAll()
                .logoutSuccessUrl("/home");
    }

    @Autowired
    protected void configureGlobal(@NotNull AuthenticationManagerBuilder auth) throws Exception {
        System.out.println("configureGlobal ");

        auth.userDetailsService(userDtoUserDetails).passwordEncoder(bCryptPasswordEncoder());
    }

}
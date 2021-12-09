package org.goit.springhw8.config;

import lombok.SneakyThrows;
import org.goit.springhw8.service.MyUserDetailsService;
import org.goit.springhw8.service.UserService;
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
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    private final MyUserDetailsService userDetailsService;

    public SecurityConfig(MyUserDetailsService userDetailsService){
        this.userDetailsService=userDetailsService;
    }

    @Bean
    public BCryptPasswordEncoder getbCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @SneakyThrows
    @Override
    public void configure(@NotNull AuthenticationManagerBuilder auth) {
        auth.userDetailsService(userDetailsService).and()
                .inMemoryAuthentication()
                .withUser("USER")
                .password("$2a$10$5f2eKX7uI9sDDQrcP6zr4O9wvFbdHx6toINMlJlVxOtRThOZgih7u")
                .password("123")
                .authorities("USER")
                .roles("USER")
                .and()
                .withUser("ADMIN")
                .password(userService.getByName("ADMIN").get(0).getPassword())
                .password("$2a$10$2Sy0K/rQTxX1flzOt0Z62.Z8JLal6NPCDI09ELDViGYuDCD4ceoGG")
                .authorities("ADMIN")
                .roles("ADMIN")
                .authorities(userService.getByName("admin".toUpperCase()).get(0).getRoles().toString());
    }

    @SneakyThrows
    @Override
    protected void configure(@NotNull HttpSecurity http) {
        http
                .csrf()
                .disable()
                .authorizeRequests()
                //Доступ только для не зарегистрированных пользователей
                .antMatchers("/registration").not().fullyAuthenticated()
                //Доступ только для пользователей с ролью Администратор
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/news").hasRole("USER")
                //Доступ разрешен всем пользователей
                .antMatchers("/", "/resources/**").permitAll()
                //Все остальные страницы требуют аутентификации
                .anyRequest().authenticated()
                .and()
                //Настройка для входа в систему
                .formLogin()
                .loginPage("/login")
                //Перенарпавление на главную страницу после успешного входа
                .defaultSuccessUrl("/")
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .logoutSuccessUrl("/");

    }
}

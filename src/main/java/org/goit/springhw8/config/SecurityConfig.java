package org.goit.springhw8.config;

import lombok.SneakyThrows;
import org.goit.springhw8.service.MyUserDetailsService;
import org.jetbrains.annotations.NotNull;
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
                .inMemoryAuthentication();
//                .withUser("USER")
//                .password("$2a$10$5f2eKX7uI9sDDQrcP6zr4O9wvFbdHx6toINMlJlVxOtRThOZgih7u")
////              .password("123")
//                .authorities("ROLE_USER")
//                .roles("USER")
//                .and()
//                .withUser("ADMIN")
////               .password("123")
//                .password("$2a$10$2Sy0K/rQTxX1flzOt0Z62.Z8JLal6NPCDI09ELDViGYuDCD4ceoGG")
//                .authorities("ROLE_ADMIN")
//                .roles("ADMIN");
    }

    @SneakyThrows
    @Override
    protected void configure(@NotNull HttpSecurity http) {
        http
                .csrf()
                .disable().rememberMe().and()
                .authorizeRequests()
                //Доступ только для не зарегистрированных пользователей
                .antMatchers("/registration").not().fullyAuthenticated()

                //Доступ только для пользователей с ролью Администратор
//                .antMatchers("/role/new/*").hasRole("ADMIN")
//                .antMatchers("/user/new/*").hasRole("ADMIN")
//                .antMatchers("/product/new/*").hasRole("ADMIN")
//                .antMatchers("/manufacturer/new/*").hasRole("ADMIN")
                //Доступ разрешен всем пользователей

                .antMatchers("/", "/resources/**").permitAll()
                //Все остальные страницы требуют аутентификации
                .anyRequest().authenticated()
                .and().rememberMe().and()
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

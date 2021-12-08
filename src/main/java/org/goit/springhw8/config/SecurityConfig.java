package org.goit.springhw8.config;

import lombok.SneakyThrows;
import org.goit.springhw8.service.UserService;
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

    @Bean
    public BCryptPasswordEncoder getbCryptPasswordEncoder() {
        System.out.println("configure");
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
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
//                .regexMatcher("/registration").authorizeRequests().anyRequest().permitAll().and()
//                .formLogin().loginPage("/login/**").permitAll()
//                .and()
//                .authorizeRequests()
//                .antMatchers("/admin/**").hasRole( "ADMIN")
////                .antMatchers("/new/**").hasRole( "ADMIN")
////                .antMatchers("/update/**").hasRole( "ADMIN")
////                .antMatchers("/delete/**").hasRole( "ADMIN")
//                .antMatchers("/user/**").hasAnyRole("USER", "ADMIN")
//                .antMatchers("/home/**").hasAnyRole("USER", "ADMIN")
//
////                .antMatchers("/user/delete/**").denyAll().and().formLogin().and().authorizeRequests().anyRequest().hasRole("ADMIN")
////                .anyRequest().hasAuthority("ROLE_ADMIN")
//                .antMatchers("/user/update/**").hasRole("ADMIN")
//                .antMatchers("/user/new/**").hasRole("ADMIN")
//                .antMatchers("/user/delete/**").hasRole("ADMIN")
//////
//                .antMatchers("/role/delete/**").hasRole("ADMIN")
//                .antMatchers("/role/update/**").hasRole("ADMIN")
//                .antMatchers("/role/new/**").hasRole("ADMIN")
//////
//                .antMatchers("/product/delete/**").hasRole("ADMIN")
//                .antMatchers("/product/update/**").hasRole("ADMIN")
//                .antMatchers("/product/new/**").hasRole("ADMIN")
//////
//                .antMatchers("/manufacturer/delete/**").hasRole("ADMIN")
//                .antMatchers("/manufacturer/update/**").hasRole("ADMIN")
//                .antMatchers("/manufacturer/new/**").hasRole("ADMIN")
//
//                .antMatchers("/**").permitAll()
//                .antMatchers("/home/**").permitAll()
//                .antMatchers("/login/**").permitAll()
//                .antMatchers("/registration/**").permitAll()
//                .and()
//                .formLogin()
//                .and()
//                .logout().permitAll();
    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        System.out.println("configure");
//
//        http.csrf().disable();
//        http.authorizeRequests()
//                .antMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
//
//                .antMatchers("/product/new/**").hasAuthority("ROLE_ADMIN")
//                .antMatchers("/product/update/**").hasAuthority("ROLE_ADMIN")
//                .antMatchers("/product/delete/**").hasAuthority("ROLE_ADMIN")
//
//                .antMatchers("/role/new/**").hasAuthority("ROLE_ADMIN")
//                .antMatchers("/role/update/**").hasAuthority("ROLE_ADMIN")
//                .antMatchers("/role/delete/**").hasAuthority("ROLE_ADMIN")
//
//                .antMatchers("/manufacturer/new/**").hasAuthority("ROLE_ADMIN")
//                .antMatchers("/manufacturer/update/**").hasAuthority("ROLE_ADMIN")
//                .antMatchers("/manufacturer/delete/**").hasAuthority("ROLE_ADMIN")
//
//                .antMatchers("/user/delete/**").hasAuthority("ROLE_ADMIN")
//                .antMatchers("/user/update/**").hasAuthority("ROLE_ADMIN")
//                .antMatchers("/user/new/**").hasAuthority("ROLE_ADMIN")
//
//                .antMatchers("/home/**").hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")
//                .antMatchers("/**").permitAll()
//                .and().formLogin();
//
//    }

    @SneakyThrows
    @Override
    public void configure(AuthenticationManagerBuilder auth) {
        System.out.println("configure");
        auth.inMemoryAuthentication()
                .withUser("USER")
                .password("$2a$10$5f2eKX7uI9sDDQrcP6zr4O9wvFbdHx6toINMlJlVxOtRThOZgih7u")
//                .password("123")
                .authorities("USER")
                .roles("USER")
                .and()
                .withUser("ADMIN")
                .password(userService.getByName("ADMIN").get(0).getPassword())
//                .password("$2a$10$2Sy0K/rQTxX1flzOt0Z62.Z8JLal6NPCDI09ELDViGYuDCD4ceoGG")
//                .authorities("ADMIN");
                .roles("ADMIN")

                .authorities(userService.getByName("admin".toUpperCase()).get(0).getRoles().toString());
    }

//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .logout()                                                                1
//                .logoutUrl("/my/logout")                                                 2
//                .logoutSuccessUrl("/my/index")                                           3
//                .logoutSuccessHandler(logoutSuccessHandler)                              4
//                .invalidateHttpSession(true)                                             5
//                .addLogoutHandler(logoutHandler)                                         6
//                .deleteCookies(cookieNamesToClear)                                       7
//                .and()
//		...
//    }
}

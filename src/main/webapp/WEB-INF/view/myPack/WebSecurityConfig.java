//package org.goit.springhw8.config;
//
//import lombok.SneakyThrows;
//import org.goit.springhw8.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    private UserService userService;
//
//    @Bean
//    public BCryptPasswordEncoder bCryptPasswordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @SneakyThrows
//    @Override
//    protected void configure(HttpSecurity httpSecurity) {
//        System.out.println("configure httpSecurity = "+httpSecurity);
//
//        httpSecurity
//                .csrf()
//                .disable()
////                .and()
//                .authorizeRequests()
//
//                //     Доступ только для не зарегистрированных пользователей
//                .antMatchers("/registration").not().fullyAuthenticated()
//
//                //     Доступ только для пользователей с ролью Администратор
////                .antMatchers("/admin/**").hasRole("ADMIN")
////                .antMatchers("/user/list").hasRole("USER")
////                .antMatchers("/user/id").hasRole("USER")
////                .antMatchers("/user/name").hasRole("USER")
////                .antMatchers("/home").hasRole("USER")
//                //   ==============  USER ===================================
////                .antMatchers("/user/new/").hasRole("ADMIN")
////                .antMatchers("/user/update/").hasRole("ADMIN")
////                .antMatchers("*/user/delete/**").hasRole("ADMIN")
//                //   ==============  ROLE ===================================
////                .antMatchers("/role/new/").hasRole("ADMIN")
////                .antMatchers("/role/update/").hasRole("ADMIN")
////                .antMatchers("*/role/delete/**").hasRole("ADMIN")
//                //   ==============  PRODUCT ===================================
////                .antMatchers("/product/new/**").hasRole("ADMIN")
////                .antMatchers("/product/update/**").hasRole("ADMIN")
////                .antMatchers("*/product/delete/**").hasRole("ADMIN")
//                //   ==============  MANUFACTURER ===================================
////                .antMatchers("/manufacturer/new/**").hasRole("ADMIN")
////                .antMatchers("/manufacturer/update/**").hasRole("ADMIN")
////                .antMatchers("*/manufacturer/delete/**").hasRole("ADMIN")
//
//                //     Доступ разрешен всем пользователей
////                .antMatchers("/", "/resources/**").permitAll()
//
//                //     Все остальные страницы требуют аутентификации
//                .anyRequest().authenticated()
//                .and()
//
//                //     Настройка для входа в систему
//                .formLogin()
//                .loginPage("/login")
//
//                //     Перенаправление на главную страницу после успешного входа
//                .defaultSuccessUrl("/")
//                .permitAll()
//                .and()
//                .logout()
//                .permitAll()
//                .logoutSuccessUrl("/home");
//    }
//
//    @SneakyThrows
//    @Autowired
//    protected void configureGlobal( AuthenticationManagerBuilder auth) {
//        System.out.println("configureGlobal auth = "+auth);
//        auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder());
//    }
//
//}
//
//

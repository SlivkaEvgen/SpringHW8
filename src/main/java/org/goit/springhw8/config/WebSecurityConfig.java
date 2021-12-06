package org.goit.springhw8.config;

import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

//    private final UserDtoUserDetails userDtoUserDetails;
//
//    public WebSecurityConfig(UserDtoUserDetails userDtoUserDetails) {
//        System.out.println("WebSecurityConfig ");
//        this.userDtoUserDetails = userDtoUserDetails;
//    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        System.out.println("BCryptPasswordEncoder ");
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public UserDetailsService userDetailsService() {
//        System.out.println("WebSecurityConfig ");
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(User.withDefaultPasswordEncoder()
//                .username("irfan").password("khan").roles("ADMIN").build());
//        return manager;
//    }

//    @SneakyThrows
//    @Autowired
//    protected void configureGlobal(@NotNull AuthenticationManagerBuilder auth) {
//        System.out.println("configureGlobal ");
//        auth.userDetailsService(userDtoUserDetails).passwordEncoder(bCryptPasswordEncoder());
//    }

    @SneakyThrows
    @Override
    protected void configure(@NotNull HttpSecurity http) {
        System.out.println("WebSecurityConfig configure");

        // включаем защиту от CSRF атак
        http.csrf()
                .disable()
                // указываем правила запросов
                // по которым будет определятся доступ к ресурсам и остальным данным
                .authorizeRequests()
                .antMatchers("/resources/**", "/**").permitAll()
                .anyRequest().permitAll()
                .and();

        http.formLogin()
                // указываем страницу с формой логина
                .loginPage("/login")
                // указываем action с формы логина
                .loginProcessingUrl("/j_spring_security_check")
                // указываем URL при неудачном логине
                .failureUrl("/login?error")
                // Указываем параметры логина и пароля с формы логина
                .usernameParameter("j_username")
                .passwordParameter("j_password")
                // даем доступ к форме логина всем
                .permitAll();

        http.logout()
                // разрешаем делать логаут всем
                .permitAll()
                // указываем URL логаута
                .logoutUrl("/j_spring_security_logout")
                // указываем URL при удачном логауте
                .logoutSuccessUrl("/login?logout")
                // делаем не валидной текущую сессию
                .invalidateHttpSession(true);

    }

    @Configuration
    protected static class AuthenticationConfiguration extends GlobalAuthenticationConfigurerAdapter {

        @Override
        public void init(@NotNull AuthenticationManagerBuilder auth) throws Exception {
            System.out.println("WebSecurityConfig init");

            auth
                    .inMemoryAuthentication()
                    .withUser("ADMIN").password("123").roles("ADMIN");
        }

    }
}


//    @Override
//    protected void configure(HttpSecurity httpSecurity) throws Exception {
//        System.out.println("configure ");
//
//        httpSecurity
////                .authorizeRequests()
//                .csrf()
//                .disable()
//                .authorizeRequests()
//                //Доступ только для не зарегистрированных пользователей
//                .antMatchers("/registration/**").not().fullyAuthenticated()
//                .antMatchers("/login/**").not().fullyAuthenticated()
//                //Доступ только для пользователей с ролью Администратор
////                .antMatchers("/admin/**").hasRole("ADMIN")
////                .antMatchers("/add/**").hasRole("ADMIN")
////                .antMatchers("/update/**").hasRole("ADMIN")
////                .antMatchers("/delete/**").hasRole("ADMIN")
////                .antMatchers("/new/**").hasRole("ADMIN")
////                .antMatchers("/news").hasRole("USER")
////                .antMatchers("/user").hasRole("USER")
////                .antMatchers("/product").hasRole("USER")
////                .antMatchers("/manufacturer").hasRole("USER")
////                .antMatchers("/home").hasRole("USER")
////                .antMatchers("/login/**").hasRole("USER")
////                .antMatchers("/registration/**").hasRole("USER")
//                //Доступ разрешен всем пользователей
//                .antMatchers("/", "/user/**").permitAll()
//                .antMatchers("/", "/role/**").permitAll()
//                .antMatchers("/", "/product/**").permitAll()
//                .antMatchers("/", "/manufacturer/**").permitAll()
//                .antMatchers("/", "/login/**").permitAll()
//                .antMatchers("/", "/registration/**").permitAll()
//                .antMatchers("/home", "homeView").permitAll()
//                //Все остальные страницы требуют аутентификации
//                .anyRequest().authenticated()
//                .and()
//                //Настройка для входа в систему
//                .formLogin()
//                .loginPage("/login")
//                //Перенарпавление на главную страницу после успешного входа
//                .defaultSuccessUrl("/home")
//                .permitAll()
//                .and()
//                .logout()
//                .permitAll()
//                .logoutSuccessUrl("/home");
//    }
//    @Override
//    protected void configure(HttpSecurity httpSecurity) throws Exception {
//        System.out.println("configure ");
//
//        httpSecurity
////                .authorizeRequests()
//                .csrf()
//                .disable()
//                .authorizeRequests()
//                //Доступ только для не зарегистрированных пользователей
//                .antMatchers("/registration/**").not().fullyAuthenticated()
//                .antMatchers("/login/**").not().fullyAuthenticated()
//                //Доступ только для пользователей с ролью Администратор
////                .antMatchers("/admin/**").hasRole("ADMIN")
////                .antMatchers("/add/**").hasRole("ADMIN")
////                .antMatchers("/update/**").hasRole("ADMIN")
////                .antMatchers("/delete/**").hasRole("ADMIN")
////                .antMatchers("/new/**").hasRole("ADMIN")
////                .antMatchers("/news").hasRole("USER")
////                .antMatchers("/user").hasRole("USER")
////                .antMatchers("/product").hasRole("USER")
////                .antMatchers("/manufacturer").hasRole("USER")
////                .antMatchers("/home").hasRole("USER")
////                .antMatchers("/login/**").hasRole("USER")
////                .antMatchers("/registration/**").hasRole("USER")
//                //Доступ разрешен всем пользователей
//                .antMatchers("/", "/user/**").permitAll()
//                .antMatchers("/", "/role/**").permitAll()
//                .antMatchers("/", "/product/**").permitAll()
//                .antMatchers("/", "/manufacturer/**").permitAll()
//                .antMatchers("/", "/login/**").permitAll()
//                .antMatchers("/", "/registration/**").permitAll()
//                .antMatchers("/home", "homeView").permitAll()
//                //Все остальные страницы требуют аутентификации
//                .anyRequest().authenticated()
//                .and()
//                //Настройка для входа в систему
//                .formLogin()
//                .loginPage("/login")
//                //Перенарпавление на главную страницу после успешного входа
//                .defaultSuccessUrl("/home")
//                .permitAll()
//                .and()
//                .logout()
//                .permitAll()
//                .logoutSuccessUrl("/home");
//    }

// Указываем Spring контейнеру, что надо инициализировать ShaPasswordEncoder
// Это можно вынести в WebAppConfig, но для понимаемости оставил тут
//    @Bean
//    public ShaPasswordEncoder getShaPasswordEncoder(){
//        return new ShaPasswordEncoder();
//    }


//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers("/", "/home").permitAll()
//                .anyRequest().authenticated();
//        http
//                .formLogin()
//                .loginPage("/login")
//                .permitAll()
//                .and()
//                .logout()
//                .permitAll();
//    }
//



package org.goit.springhw8.config;

import lombok.SneakyThrows;
import lombok.extern.java.Log;
import org.goit.springhw8.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Log
//@EnableGlobalMethodSecurity(prePostEnabled = true)
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
        http.authorizeRequests()
                .antMatchers("/admin/**").hasRole( "ADMIN")
                .antMatchers("/user/**").hasAnyRole("USER", "ADMIN")
                .antMatchers("/**").permitAll()
                .and().formLogin();
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
                .withUser("user")
                .password("$2a$10$5f2eKX7uI9sDDQrcP6zr4O9wvFbdHx6toINMlJlVxOtRThOZgih7u")
//                .password("123")
                .authorities("USER")
                .and()
                .withUser("admin")
                .password(userService.getByName("admin".toUpperCase()).get(0).getPassword())
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

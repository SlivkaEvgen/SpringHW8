package org.goit.springhw8.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * The type Mvc config.
 */
@ComponentScan("org.goit.springhw8")
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("admin/**").setViewName("admin");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/registration/**").setViewName("registration");
        registry.addViewController("/home").setViewName("index");
        registry.addViewController("/english/**").setViewName("translate/byEnglishName");
        //////////////////////////////////////////___USER____/////////////////////////////////
        registry.addViewController("/user").setViewName("user/user");
        registry.addViewController("/user/id").setViewName("user/userById");
        registry.addViewController("/user/name/**").setViewName("user/userByName");
        registry.addViewController("/user/email/**").setViewName("user/userByEmail");
        registry.addViewController("/user/list/**").setViewName("user/list");
        registry.addViewController("/user/delete").setViewName("user/deleteUser");
        registry.addViewController("/user/update/**").setViewName("user/updateUser");
        registry.addViewController("/user/new/**").setViewName("user/newUser");
        //////////////////////////////////////////___ROLE____///////////////////////////////
        registry.addViewController("/role").setViewName("role/role");
        registry.addViewController("/role/id/**").setViewName("role/roleById");
        registry.addViewController("/role/name/**").setViewName("role/roleByName");
        registry.addViewController("/role/list/**").setViewName("role/list");
        registry.addViewController("/role/delete").setViewName("role/deleteRole");
        registry.addViewController("/role/update/**").setViewName("role/updateRole");
        registry.addViewController("/role/new/**").setViewName("role/newRole");
        //////////////////////////////////////////___PRODUCT____//////////////////////////////
        registry.addViewController("/product").setViewName("product/product");
        registry.addViewController("/product/id/**").setViewName("product/productById");
        registry.addViewController("/product/name/**").setViewName("product/productByName");
        registry.addViewController("/product/list/**").setViewName("product/list");
        registry.addViewController("/product/delete").setViewName("product/deleteProduct");
        registry.addViewController("/product/update/**").setViewName("product/updateProduct");
        registry.addViewController("/product/new/**").setViewName("product/newProduct");
        registry.addViewController("/product/manufacturerId/**").setViewName("product/productByManufactureId");
        /////////////////////////////////////////____MANUFACTURER____/////////////////////////////////
        registry.addViewController("/manufacturer").setViewName("manufacturer/manufacturer");
        registry.addViewController("/manufacturer/id/**").setViewName("manufacturer/manufacturerById");
        registry.addViewController("/manufacturer/name/**").setViewName("manufacturer/manufacturerByName");
        registry.addViewController("/manufacturer/list/**").setViewName("manufacturer/list");
        registry.addViewController("/manufacturer/delete").setViewName("manufacturer/deleteManufacturer");
        registry.addViewController("/manufacturer/update/**").setViewName("manufacturer/updateManufacturer");
        registry.addViewController("/manufacturer/new/**").setViewName("manufacturer/newManufacturer");
        /////////////////////////////////////////____NOTE____/////////////////////////////////
        registry.addViewController("/notes/list/**").setViewName("note/noteList");
        registry.addViewController("/notes/id/**").setViewName("note/noteByID");
        registry.addViewController("/notes/new/**").setViewName("note/newNote");
        registry.addViewController("/notes/delete").setViewName("note/deleteNote");
        registry.addViewController("/notes/update/**").setViewName("note/updateNote");
        //        registry.addViewController("/notes/**").setViewName("note/note");
        // REDIRECT
        registry.addRedirectViewController("/weather/**","/admin");
        registry.addRedirectViewController("/api/**","/swagger-ui/index.html#/");

    }
}

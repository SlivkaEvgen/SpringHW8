package org.goit.springhw8.controller;

import org.goit.springhw8.model.Manufacturer;
import org.goit.springhw8.model.Product;
import org.goit.springhw8.service.ProductService;
import org.goit.springhw8.util.Validator;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
@RequestMapping("product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService=productService;
    }

    @GetMapping("product")
    public ModelAndView entity(ModelMap model) {
        return new ModelAndView("product/product", model);
    }

    @GetMapping("list")
    public ModelAndView getAllProducts(ModelMap model) {
        return new ModelAndView("product/list", model.addAttribute("list", productService.getAllProducts()));
    }

    @GetMapping("id")
    public ModelAndView findById(ModelMap model, String id) {
        if (id == null) {
            return new ModelAndView("product/productById", model);
        }
        Optional<Product> productById = productService.findProductById(id);
        if (!productById.isPresent()) {
            return new ModelAndView("product/productById", model);
        }
        model.addAttribute("product", productById.get());
        return new ModelAndView("product/productById", model);
    }

    @GetMapping("name")
    public ModelAndView findByName(ModelMap model, String name) {
        if (name == null) {
            return new ModelAndView("product/productByName", model);
        }
        model.addAttribute("list", productService.findProductByName(name));
        return new ModelAndView("product/productByName", model);
    }

    @GetMapping("delete")
    public ModelAndView delete(ModelMap model, String id) {
        if (id == null) {
            return new ModelAndView("product/deleteProduct", model);
        }
        productService.deleteProduct(id);
        return new ModelAndView("product/product", model);
    }

    @GetMapping("new/**")
    public ModelAndView addNew(ModelMap model) {
        return new ModelAndView("product/newProduct", model);
    }

    @RequestMapping(value = "new", method = RequestMethod.POST)
    public ModelAndView addNewPost(ModelMap model, String id, String name, String price, Manufacturer manufacturer) {
        if (id == null) {
            return new ModelAndView("product/newProduct", model);
        }
        if (name == null) {
            return new ModelAndView("product/newProduct", model);
        }
        if (price == null) {
            return new ModelAndView("product/newProduct", model);
        }
        if (manufacturer == null) {
            return new ModelAndView("product/newProduct", model);
        }
        productService.saveProduct(new Product(Long.parseLong(id),name,Double.parseDouble(price),manufacturer));
        return new ModelAndView("product/product", model);
    }

    @GetMapping("update/**")
    public ModelAndView update(ModelMap model, Product product) {
        model.addAttribute("product",product);
        return new ModelAndView("product/updateProduct", model);
    }

    @RequestMapping(value = "update/**", method = RequestMethod.POST)
    public ModelAndView updatePost(String id, String name,String price,Manufacturer manufacturer, ModelMap model) {
        if (id==null){
            return new ModelAndView("product/updateProduct", model);
        }
        if (name==null){
            return new ModelAndView("product/updateProduct", model);
        }
        if (price==null){
            return new ModelAndView("product/updateProduct", model);
        }
        if (manufacturer==null){
            return new ModelAndView("product/updateProduct", model);
        }
        if (!Validator.validId(id)) {
            model.addAttribute("error2", "Try Again");
            model.addAttribute("error", "Wrong ID");
            return new ModelAndView("product/updateProduct", model);
        }
        Product product = new Product(Long.parseLong(id), name, Double.parseDouble(price), manufacturer);
        productService.saveProduct(product);
        model.addAttribute("product",product);
        return new ModelAndView("product/product", model);
    }

}
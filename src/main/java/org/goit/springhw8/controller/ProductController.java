package org.goit.springhw8.controller;

import lombok.NonNull;
import org.goit.springhw8.model.Product;
import org.goit.springhw8.service.ProductService;
import org.goit.springhw8.util.Validator;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private ProductService productService;

    // DONE
    @GetMapping("product")
    public ModelAndView entity(ModelMap model) {
        return new ModelAndView("product/product", model);
    }

    // DONE
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
//        if (!productService.existsById(Long.parseLong(id))){
//            this.message = "Product By ID "+ id+ " not exists" ;
//            return new ModelAndView("product/deleteProduct", model);
//        }
//        this.message = "";
        productService.deleteProduct(Long.parseLong(id));
        return new ModelAndView("product/product", model);
    }

    @GetMapping("new/**")
    public ModelAndView addNew(ModelMap model) {

        if (model.isEmpty()) {
            return new ModelAndView("product/newProduct", model);
        }
//        productService.saveProduct(new Product(product.getId(), product.getName(),product.getPrice(),product.getManufacturer()));
        return new ModelAndView("product/newProduct", model);
    }

    @RequestMapping(value = "new", method = RequestMethod.POST)
    public ModelAndView addNewPost(ModelMap model,Product product) {
        if (product.getId() == null) {
            return new ModelAndView("product/newProduct", model);
        }
        model.addAttribute("product", product);
        productService.saveProduct(product);
        return new ModelAndView("product/product", model);
    }

//    @GetMapping("update/**")
//    public ModelAndView update(ModelMap model, Product product) {
////        System.out.println("update  "+product);
////        if (product.getId()==null){
////            return new ModelAndView("product/updateProduct", model);
////        }
//////        productService.saveProduct(product);
//        return new ModelAndView("product/updateProduct", model);
//    }
//
//    @RequestMapping(value = "update/**", method = RequestMethod.POST)
//    public ModelAndView updatePost(ModelMap model, Product product) {
////        System.out.println("updatePost "+product);
//        if (product.getId() == null) {
//            return new ModelAndView("product/updateProduct", model);
//        }
//        model.addAttribute("product", product);
//        productService.saveProduct(product);
//        return new ModelAndView("product/updateProduct", model);
//    }

    @GetMapping("update/**")
    public ModelAndView update(@NonNull ModelMap model, Product product) {
//        model.addAttribute("error", message);
        return new ModelAndView("product/updateProduct", model);
    }

    @RequestMapping(value = "update/**", method = RequestMethod.POST)
    public ModelAndView updatePost(@NonNull Product product, ModelMap model) {
        if (!Validator.validId(product.getId().toString())) {
            model.addAttribute("error2", "Try Again");
            model.addAttribute("error", "Wrong ID");
            return new ModelAndView("product/product", model);
        }
       productService.saveProduct(product);
//        if (role1.getId()!=null) {
////            this.message = "User With ID = " + role.getId() + " Updated";
////            model.addAttribute("error2", this.message);
//        }
        return new ModelAndView("product/product", model);
    }

}

//    @GetMapping("manufacturerId")
//    public ModelAndView productsByManufacturer(ModelMap model, String id, String message){
//        if (id==null){
//            return new ModelAndView("product/productByManufactureId",model);
//        }
//        List<Product> products = productService.byManufacturerId(id);
//        System.out.println("products GET"+products);
//        model.addAttribute("list", products);
//        return new ModelAndView("product/productByManufactureId",model);
//    }

//    @RequestMapping(value = "manufacturerId", method = RequestMethod.POST)
//    public ModelAndView productsByManufacturerPost(ModelMap model, String id, String message){
//        if (id==null){
//            return new ModelAndView("product/productByManufactureId",model);
//        }
////        List<Product> products = productService.byManufacturerId(id);
////        System.out.println("products "+products);
//        model.addAttribute("list",productService.byManufacturerId(id));
//        return new ModelAndView("product/productByManufactureId",model);
//    }
//    @GetMapping("new")
//    public ModelAndView addNew(ModelMap model, String id, String name, String price, Manufacturer manufacturer,String message) {
//        if (id == null) {
//            return new ModelAndView("product/newProduct", model);
//        }
//        productService.saveProduct(new Product(Long.parseLong(id), name,Double.parseDouble(price),manufacturer));
//        return new ModelAndView("product/newProduct", model);
//    }

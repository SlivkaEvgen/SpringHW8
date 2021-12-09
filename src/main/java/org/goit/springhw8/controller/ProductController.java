package org.goit.springhw8.controller;

import org.goit.springhw8.model.Product;
import org.goit.springhw8.service.ProductService;
import org.goit.springhw8.util.Validator;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("product")
    public ModelAndView entity(ModelMap model) {
        return new ModelAndView("product/product", model);
    }

    @GetMapping("list")
    public ModelAndView getAllProducts(@NotNull ModelMap model) {
        return new ModelAndView("product/list", model.addAttribute("list", productService.getList()));
    }

    @GetMapping("id")
    public ModelAndView findById(String id, ModelMap model) {
        if (id == null) {
            return new ModelAndView("product/productById", model);
        }
        if (id.isEmpty()) {
            return new ModelAndView("product/productById", model.addAttribute("id", id).addAttribute("error", "Product ID Is Empty").addAttribute("error2", "Please, Try Again"));
        }
        if (!Validator.validId(id)) {
            return new ModelAndView("product/productById", model.addAttribute("id", id).addAttribute("error", "Wrong Product ID ").addAttribute("error2", "Please, Try Again"));
        }
        if (!productService.getById(id).isPresent()) {
            return new ModelAndView("product/productById", model.addAttribute("id", id).addAttribute("error", "Could Not Find Product With ID " + id).addAttribute("error2", "Please, Try Again"));
        }
        return new ModelAndView("product/productById", model.addAttribute("list", productService.findListById(id)).addAttribute("error2", "SUCCESSFULLY"));
    }

    @GetMapping("name")
    public ModelAndView findByName(String name, ModelMap model) {
        if (name == null) {
            return new ModelAndView("product/productByName", model);
        }
        if (name.isEmpty()) {
            return new ModelAndView("product/productByName", model.addAttribute("name", name).addAttribute("error", "Product Name Is Empty").addAttribute("error2", "Please, Try Again"));
        }
        if (!Validator.validName(name)) {
            return new ModelAndView("product/productByName", model.addAttribute("name", name).addAttribute("error", "Wrong Product Name ").addAttribute("error2", "Please, Try Again"));
        }
        if (productService.getByName(name).isEmpty()) {
            return new ModelAndView("product/productByName", model.addAttribute("name", name).addAttribute("error", "Could Not Find Product With Name " + name).addAttribute("error2", "Please, Try Again"));
        }
        return new ModelAndView("product/productByName", model.addAttribute("list", productService.getByName(name)).addAttribute("error2", "SUCCESSFULLY"));
    }

    //    @Secured(value = {"ROLE_ADMIN"})
    @GetMapping("delete")
    public ModelAndView delete(String id, ModelMap model) {
        if (id == null) {
            return new ModelAndView("product/deleteProduct", model);
        }
        if (id.isEmpty()) {
            return new ModelAndView("product/deleteProduct", model.addAttribute("id", id).addAttribute("error", "Product ID Is Empty").addAttribute("error2", "Please, Try Again"));
        }
        if (!Validator.validId(id)) {
            return new ModelAndView("product/deleteProduct", model.addAttribute("id", id).addAttribute("error", "Wrong Product ID ").addAttribute("error2", "Please, Try Again"));
        }
        if (!productService.getById(id).isPresent()) {
            return new ModelAndView("product/deleteProduct", model.addAttribute("id", id).addAttribute("error", "Could Not Find Product With ID " + id).addAttribute("error2", "Please, Try Again"));
        }
        productService.deleteById(id);
        return new ModelAndView("product/product", model.addAttribute("id", id).addAttribute("error", " Product Deleted").addAttribute("error2", "SUCCESSFULLY"));
    }

    @GetMapping("new/**")
    public ModelAndView addNew(Product product, @NotNull ModelMap model) {
        return new ModelAndView("product/newProduct", model.addAttribute("product", product));
    }

    @RequestMapping(value = "new", method = RequestMethod.POST)
    public ModelAndView addNewPost(Product product, ModelMap model) {
        if (product == null) {
            return new ModelAndView("product/newProduct", model.addAttribute("error", "Product Is Null").addAttribute("error2", "Please, Try Again"));
        }
        if (product.getId() == null) {
            return new ModelAndView("product/newProduct", model.addAttribute("product", product).addAttribute("error", "Product ID Is Null").addAttribute("error2", "Please, Try Again"));
        }
        if (product.getId().isEmpty()) {
            return new ModelAndView("product/newProduct", model.addAttribute("product", product).addAttribute("error", "Product ID Is Empty").addAttribute("error2", "Please, Try Again"));
        }
        if (!Validator.validId(product.getId())) {
            return new ModelAndView("product/newProduct", model.addAttribute("product", product).addAttribute("error", "Wrong Product ID").addAttribute("error2", "Please, Try Again"));
        }
        if (product.getName() == null) {
            return new ModelAndView("product/newProduct", model.addAttribute("product", product).addAttribute("error", "Product Name Is Null").addAttribute("error2", "Please, Try Again"));
        }
        if (product.getName().isEmpty()) {
            return new ModelAndView("product/newProduct", model.addAttribute("product", product).addAttribute("error", "Product Name Is Empty").addAttribute("error2", "Please, Try Again"));
        }
        if (!Validator.validName(product.getName())) {
            return new ModelAndView("product/newProduct", model.addAttribute("product", product).addAttribute("error", "Wrong Product Name").addAttribute("error2", "Please, Try Again"));
        }
        if (product.getPrice() == null) {
            return new ModelAndView("product/newProduct", model.addAttribute("product", product).addAttribute("error", "Product Price Is Null").addAttribute("error2", "Please, Try Again"));
        }
        if (product.getManufacturer().getId() == null) {
            return new ModelAndView("product/newProduct", model.addAttribute("product", product).addAttribute("error", " Product`s Manufacture Is Null").addAttribute("error2", "Please, Try Again"));
        }
        if (product.getManufacturer().getName() == null) {
            return new ModelAndView("product/newProduct", model.addAttribute("product", product).addAttribute("error", " Product`s Manufacture Is Null").addAttribute("error2", "Please, Try Again"));
        }
        if (productService.getById(product.getId()).isPresent()) {
            return new ModelAndView("product/newProduct", model.addAttribute("product", product).addAttribute("error", " Product With ID " + product.getId() + " Is Used").addAttribute("error2", "Please, Try Again"));
        }
        product.setName(product.getName().toUpperCase());
        productService.saveEntity(product);
        return new ModelAndView("product/product", model.addAttribute("error", "New Product Added").addAttribute("error2", "SUCCESSFULLY"));
    }

    @GetMapping("update/**")
    public ModelAndView update(Product product, @NotNull ModelMap model) {
        return new ModelAndView("product/updateProduct", model.addAttribute("product", product));
    }

    @RequestMapping(value = "update/**", method = RequestMethod.POST)
    public ModelAndView updatePost(@NotNull Product product, ModelMap model) {
        if (product.getId() == null) {
            return new ModelAndView("product/updateProduct", model.addAttribute("manufacturer", product.getManufacturer()).addAttribute("error", "Product ID Is Null").addAttribute("error2", "Please, Try Again"));
        }
        if (product.getName() == null) {
            return new ModelAndView("product/updateProduct", model.addAttribute("manufacturer", product.getManufacturer()).addAttribute("error", "Product Name Is Null").addAttribute("error2", "Please, Try Again"));
        }
        if (product.getPrice() == null) {
            return new ModelAndView("product/updateProduct", model.addAttribute("manufacturer", product.getManufacturer()).addAttribute("error", "Product Price Is Null").addAttribute("error2", "Please, Try Again"));
        }
        if (product.getManufacturer() == null) {
            return new ModelAndView("product/updateProduct", model.addAttribute("error", "Product`s Manufacturer Is Null").addAttribute("error2", "Please, Try Again"));
        }
        if (product.getId().isEmpty()) {
            return new ModelAndView("product/updateProduct", model.addAttribute("manufacturer", product.getManufacturer()).addAttribute("error", "Product ID Is Empty").addAttribute("error2", "Please, Try Again"));
        }
        if (product.getName().isEmpty()) {
            return new ModelAndView("product/updateProduct", model.addAttribute("manufacturer", product.getManufacturer()).addAttribute("error", "Product Name Is Empty").addAttribute("error2", "Please, Try Again"));
        }
        if (product.getPrice().isNaN()) {
            return new ModelAndView("product/updateProduct", model.addAttribute("manufacturer", product.getManufacturer()).addAttribute("error", "Product Price Is Empty").addAttribute("error2", "Please, Try Again"));
        }
        if (product.getPrice().isInfinite()) {
            return new ModelAndView("product/updateProduct", model.addAttribute("manufacturer", product.getManufacturer()).addAttribute("error", "Product Price Is Empty").addAttribute("error2", "Please, Try Again"));
        }
        if (!Validator.validId(product.getId())) {
            return new ModelAndView("product/updateProduct", model.addAttribute("manufacturer", product.getManufacturer()).addAttribute("error", "Wrong Product ID").addAttribute("error2", "Please, Try Again"));
        }
        if (!Validator.validName(product.getName())) {
            return new ModelAndView("product/updateProduct", model.addAttribute("manufacturer", product.getManufacturer()).addAttribute("error", "Wrong Product Name").addAttribute("error2", "Please, Try Again"));
        }
        if (!Validator.validString(product.getPrice().toString())) {
            return new ModelAndView("product/updateProduct", model.addAttribute("manufacturer", product.getManufacturer()).addAttribute("error", "Product Price Wrong").addAttribute("error2", "Please, Try Again"));
        }
        productService.saveEntity(new Product(product.getId(), product.getName().toUpperCase(), product.getPrice(), product.getManufacturer()));
        return new ModelAndView("product/product", model.addAttribute("manufacturer", product.getManufacturer()).addAttribute("error", " Product Updated").addAttribute("error2", "SUCCESSFULLY"));
    }
}
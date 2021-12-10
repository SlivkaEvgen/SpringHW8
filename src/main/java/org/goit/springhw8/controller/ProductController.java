package org.goit.springhw8.controller;

import jakarta.validation.Valid;
import org.goit.springhw8.model.Product;
import org.goit.springhw8.service.ProductService;
import org.goit.springhw8.util.Validator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * The type Product controller.
 */
@Controller
@Validated
@RequestMapping("product")
public class ProductController {

    private final ProductService productService;

    /**
     * Instantiates a new Product controller.
     *
     * @param productService the product service
     */
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * Entity product model and view.
     *
     * @param model the model
     * @return the model and view
     */
    @GetMapping("product")
    public ModelAndView entityProduct(ModelMap model) {
        return new ModelAndView("product/product", model);
    }

    /**
     * Gets all products.
     *
     * @param model the model
     * @return the all products
     */
    @GetMapping("list")
    public ModelAndView getAllProducts(ModelMap model) {
        if (model==null){
            return new ModelAndView("product/list");
        }
        return new ModelAndView("product/list", model.addAttribute("list", productService.getAll()));
    }

    /**
     * Gets product by id.
     *
     * @param id    the id
     * @param model the model
     * @return the product by id
     */
    @GetMapping("id")
    public ModelAndView getProductById(String id, ModelMap model) {
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
        return new ModelAndView("product/productById", model.addAttribute("list", productService.findListByEntityId(id)).addAttribute("error2", "SUCCESSFULLY"));
    }

    /**
     * Gets product by name.
     *
     * @param name  the name
     * @param model the model
     * @return the product by name
     */
    @GetMapping("name")
    public ModelAndView getProductByName(String name, ModelMap model) {
        if (name == null) {
            return new ModelAndView("product/productByName", model);
        }
        if (name.isEmpty()) {
            return new ModelAndView("product/productByName", model.addAttribute("name", name.toUpperCase()).addAttribute("error", "Product Name Is Empty").addAttribute("error2", "Please, Try Again"));
        }
        if (!Validator.validName(name)) {
            return new ModelAndView("product/productByName", model.addAttribute("name", name).addAttribute("error", "Wrong Product Name ").addAttribute("error2", "Please, Try Again"));
        }
        if (productService.findByName(name.toUpperCase()).isEmpty()) {
            return new ModelAndView("product/productByName",model.addAttribute("error","Error").addAttribute("error2","ERROR2"));
        }
        return new ModelAndView("product/productByName", model.addAttribute("error","error").addAttribute("list", productService.findByName(name.toUpperCase())).addAttribute("error2", "SUCCESSFULLY").addAttribute("model", model).addAttribute("name", name.toUpperCase()));

    }

    /**
     * Delete product by id model and view.
     *
     * @param id    the id
     * @param model the model
     * @return the model and view
     */
    @GetMapping(value = "delete")
    public ModelAndView deleteProductById(String id, ModelMap model) {
        if (model==null){
            return new ModelAndView("product/deleteProduct");
        }
        if (id == null) {
            return new ModelAndView("product/deleteProduct", model);
        }
        model.addAttribute("error2", "Please, Try Again");
        if (id.isEmpty()) {
            return new ModelAndView("product/deleteProduct", model.addAttribute("id", id).addAttribute("error", "Product ID Is Empty"));
        }
        if (!Validator.validId(id)) {
            model.addAttribute("error2", "Please, Try Again");
            return new ModelAndView("product/deleteProduct", model.addAttribute("id", id).addAttribute("error", "Wrong Product ID "));
        }
        if (!productService.getById(id).isPresent()) {
            return new ModelAndView("product/deleteProduct", model.addAttribute("id", id).addAttribute("error", "Could Not Find Product With ID " + id));
        }
        productService.deleteById(id);
        return new ModelAndView("product/product", model.addAttribute("id", id).addAttribute("error", " Product Deleted").addAttribute("error2", "SUCCESSFULLY"));
    }

    /**
     * Add new product get model and view.
     *
     * @param product the product
     * @param model   the model
     * @return the model and view
     */
    @RequestMapping(value = "new/**", method = RequestMethod.GET)
    public ModelAndView addNewProductGet(@Valid Product product, ModelMap model) {
        if (model==null){
            return new ModelAndView("product/newProduct");
        }
        return new ModelAndView("product/newProduct", model.addAttribute("list2", productService.findAllManufacturer()).addAttribute("product", product));
    }

    /**
     * Add new product post model and view.
     *
     * @param product the product
     * @param model   the model
     * @return the model and view
     */
    @RequestMapping(value = "new/**", method = RequestMethod.POST)
    public ModelAndView addNewProductPost(@Valid Product product, ModelMap model) {
        if (model==null){
            return new ModelAndView("product/newProduct");
        }
        model.addAttribute("list2", productService.findAllManufacturer());
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

    /**
     * Update product get model and view.
     *
     * @param product the product
     * @param model   the model
     * @return the model and view
     */
    @RequestMapping(value = "update/**", method = RequestMethod.GET)
    public ModelAndView updateProductGet(@Valid Product product, ModelMap model) {
        if (model==null){
            return new ModelAndView("product/updateProduct");
        }
        return new ModelAndView("product/updateProduct", model.addAttribute("product", product).addAttribute("list2", productService.findAllManufacturer()));
    }

    /**
     * Update product post model and view.
     *
     * @param product the product
     * @param model   the model
     * @return the model and view
     */
    @RequestMapping(value = "update/**", method = RequestMethod.POST)
    public ModelAndView updateProductPost(@Valid Product product, ModelMap model) {
        if (model==null){
            return new ModelAndView("product/updateProduct");
        }
        model.addAttribute("list2", productService.findAllManufacturer());
        model.addAttribute("error2", "Please, Try Again");
//        model.addAttribute("manufacturer", product.getManufacturer());
        if (product == null) {
            return new ModelAndView("product/updateProduct", model.addAttribute("error", "Product Is Null"));
        }
        if (product.getId() == null) {
            return new ModelAndView("product/updateProduct", model.addAttribute("manufacturer", product.getManufacturer()).addAttribute("error", "Product ID Is Null"));
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
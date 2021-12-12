package org.goit.springhw8.controller;

import jakarta.validation.Valid;
import org.goit.springhw8.model.Product;
import org.goit.springhw8.service.ProductService;
import org.goit.springhw8.util.SendErrorMessage;
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

    private final SendErrorMessage sendErrorMessage;

    private final ProductService productService;

    private String viewName = "";

    public ModelAndView customModel(String viewName, ModelMap model, Object errorMessage) {
        return sendErrorMessage.customModelUser(viewName, model, errorMessage, errorMessage);
    }

    public ModelAndView customModelOk(String viewName, ModelMap model, Object errorMessage) {
        return sendErrorMessage.customModelUserOK(viewName, model, errorMessage);
    }

    /**
     * Instantiates a new Product controller.
     *
     * @param productService the product service
     */
    public ProductController(ProductService productService, SendErrorMessage sendErrorMessage) {
        this.productService = productService;
        this.sendErrorMessage = sendErrorMessage;
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
        viewName = "product/productById";
        if (id == null) {
            return new ModelAndView(viewName, model);
        }
        if (!productService.getById(id).isPresent()) {
            return customModel(viewName, model.addAttribute("list", productService.findListByEntityId(id)), "Product With The ID = " + id + ",\n Is Not Found");
        }
        return customModelOk(viewName, model.addAttribute("list", productService.findListByEntityId(id)), "");
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
        viewName = "product/productByName";
        if (name == null) {
            return new ModelAndView(viewName, model);
        }
        if (productService.findByName(name).isEmpty()) {
            return customModel(viewName, model.addAttribute("list", productService.findListByEntityId(name)), "Product With The Name = " + name + ",\n Is Not Found");
        }
        return customModelOk(viewName, model.addAttribute("list", productService.findByName(name)), "");
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
        viewName = "product/deleteProduct";
        if (id == null) {
            return new ModelAndView(viewName, model);
        }
        if (!productService.getById(id).isPresent()) {
            return customModel(viewName, model, "Manufacturer With The ID = " + id + ",\n Is Not Found");
        }
        productService.deleteById(id);
        return customModelOk("product/product", model, "Product Deleted");
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
        viewName = "product/newProduct";
        model.addAttribute("list2", productService.findAllManufacturer());

        if (product.getId() == null) {
            return customModel(viewName, model, "Product ID Is Null");
        }
        if (product.getName() == null) {
            return customModel(viewName, model, "Product Name Is Null");
        }
        if (product.getPrice() == null) {
            return customModel(viewName, model, "Product Price Is Null");
        }
        if (product.getManufacturer() == null) {
            return customModel(viewName, model, "Product`s Manufacturer Is Null");
        }
        if (product.getId().isEmpty()) {
            return customModel(viewName, model, "Product ID Is Empty");
        }
        if (product.getName().isEmpty()) {
            return customModel(viewName, model, "Product Name Is Empty");
        }
        if (product.getPrice().isNaN()) {
            return customModel(viewName, model, "Product Price Is Empty");
        }
        if (product.getPrice().isInfinite()) {
            return customModel(viewName, model, "Product Price Is Empty");
        }
        if (!Validator.validId(product.getId())) {
            return customModel(viewName, model, "Wrong Product ID");
        }
        if (!Validator.validName(product.getName())) {
            return customModel(viewName, model, "Wrong Product Name");
        }
        if (!Validator.validString(product.getPrice().toString())) {
            return customModel(viewName, model, "Product Price Wrong");
        }
        if (Validator.isValidPrice(product.getPrice().toString())) {
            return customModel(viewName, model, "Product Price Invalid Value");
        }
        if (productService.getById(product.getId()).isPresent()) {
            return customModel(viewName, model, " Product With ID " + product.getId() + " Is Used");
        }

        productService.saveEntity(product);
        return customModelOk("product/product", model, "Product Added");
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
        viewName = "product/updateProduct";
        model.addAttribute("list2", productService.findAllManufacturer());

        if (product.getId() == null) {
            return customModel(viewName, model, "Product ID Is Null");
        }
        if (product.getName() == null) {
            return customModel(viewName, model, "Product Name Is Null");
        }
        if (product.getPrice() == null) {
            return customModel(viewName, model, "Product Price Is Null");
        }
        if (product.getManufacturer() == null) {
            return customModel(viewName, model, "Product`s Manufacturer Is Null");
        }
        if (product.getId().isEmpty()) {
            return customModel(viewName, model, "Product ID Is Empty");
        }
        if (product.getName().isEmpty()) {
            return customModel(viewName, model, "Product Name Is Empty");
        }
        if (product.getPrice().isNaN()) {
            return customModel(viewName, model, "Product Price Is Nan");
        }
        if (product.getPrice().isInfinite()) {
            return customModel(viewName, model, "Product Price Is Infinite");
        }
        if (!Validator.validId(product.getId())) {
            return customModel(viewName, model, "Wrong Product ID");
        }
        if (!Validator.validName(product.getName())) {
            return customModel(viewName, model, "Invalid Product Name");
        }
        if (!Validator.validString(product.getPrice().toString())) {
            return customModel(viewName, model, "Invalid Price ");
        }
        if (Validator.isValidPrice(product.getPrice().toString())) {
            return customModel(viewName, model, "Invalid Price Value");
        }
        if (!productService.getById(product.getId()).isPresent()) {
            return customModel(viewName, model, "Not Found " + product.getId() + "");
        }

        productService.saveEntity(product);
        return customModelOk("product/product", model.addAttribute("manufacturer", product.getManufacturer()), "Product Updated");
    }

}
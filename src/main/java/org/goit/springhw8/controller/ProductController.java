package org.goit.springhw8.controller;

import jakarta.validation.Valid;
import org.goit.springhw8.model.Product;
import org.goit.springhw8.service.ProductService;
import org.goit.springhw8.util.SendError;
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

    private final SendError sendError;
    private final ProductService productService;
    private String viewName = "";

    public ModelAndView customModel(String viewName, ModelMap model, Object errorMessage) {
        return sendError.customModelUser(viewName, model, errorMessage, errorMessage);
    }

    public ModelAndView customModelOk(String viewName, ModelMap model, Object errorMessage) {
        return sendError.customModelUserOK(viewName, model, errorMessage);
    }

    /**
     * Instantiates a new Product controller.
     *
     * @param productService the product service
     */
    public ProductController(ProductService productService, SendError sendError) {
        this.productService = productService;
        this.sendError = sendError;
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
        validProductMini(viewName, id, model);
        if (id == null) {
            return new ModelAndView(viewName, model);
        }
        if (!Validator.validId(id)) {
            return customModel(viewName, model, "Wrong Product ID ");
        }
        if (!productService.getById(id).isPresent()) {
            return customModel(viewName, model, "Could Not Find Product With ID " + id);
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
        validProductMini(viewName, name, model);
        if (name == null) {
            return new ModelAndView(viewName, model);
        }
        if (!Validator.validName(name)) {
            return customModel(viewName, model, "Wrong Product Name ");
        }
        if (productService.findByName(name.toUpperCase()).isEmpty()) {
            return customModel(viewName, model, "Product Is Empty");
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
            return new ModelAndView(viewName);
        }
        validProductMini(viewName, id, model);
        if (!Validator.validId(id)) {
            return customModel(viewName, model, "Invalid Product ID ");
        }
        if (!productService.getById(id).isPresent()) {
            return customModel(viewName, model, "Could Not Find Product With ID " + id);
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
        if (!productService.getById(product.getId()).isPresent()) {
            return customModel(viewName, model, "Not Found " + product.getId() + "");
        }

        productService.saveEntity(product);
        return customModelOk("product/product", model.addAttribute("manufacturer", product.getManufacturer()), "Product Updated");
    }

    public void validProductMini(String viewName, Object attribute, ModelMap model) {
        if (model == null) {
            new ModelAndView(viewName);
            return;
        }
        if (attribute == null) {
            new ModelAndView(viewName);
            return;
        }
        if (model.isEmpty()) {
            new ModelAndView(viewName);
            return;
        }
        customModel(viewName, model, attribute);
    }
}
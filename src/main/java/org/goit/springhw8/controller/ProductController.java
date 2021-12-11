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

    private final static String ERROR = "error";
    private final static String ERROR2 = "error2";
    private final static String ERROR2MESSAGE = "Please,Try Again";
    private final static String ERROR2SUCCESSFULLY = "SUCCESSFULLY";
    private String viewName = "";
    private final ProductService productService;

    public ModelAndView customModel(String viewName, ModelMap model, Object errorMessage) {
        if (model != null) {
            return new ModelAndView(viewName, model.addAttribute(ERROR, errorMessage).addAttribute(ERROR2, ERROR2MESSAGE));
        }
        return new ModelAndView();
    }

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
        viewName = "product/list";
        return model == null ? new ModelAndView(viewName) : new ModelAndView(viewName, model.addAttribute("list", productService.getAll()));
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
        if (!Validator.validId(id)) {
            return customModel(viewName, model, "Wrong Product ID ");
        }
        if (!productService.getById(id).isPresent()) {
            return customModel(viewName, model, "Could Not Find Product With ID " + id);
        }
        return new ModelAndView("product/productById", model.addAttribute("list", productService.findListByEntityId(id)).addAttribute(ERROR2, ERROR2SUCCESSFULLY));
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
        if (!Validator.validName(name)) {
            return customModel(viewName, model, "Wrong Product Name ");
        }
        if (productService.findByName(name.toUpperCase()).isEmpty()) {
            return customModel(viewName, model, "Product Is Empty");
        }
        return new ModelAndView(viewName, model.addAttribute("list", productService.findByName(name.toUpperCase())).addAttribute("model", model).addAttribute("name", name.toUpperCase()).addAttribute(ERROR2, ERROR2SUCCESSFULLY));

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
        ModelAndView modelAndView = validProductMini(viewName, id, model);
        if (!Validator.validId(id)) {
            return customModel(viewName, model, "Invalid Product ID ");
        }
        if (!productService.getById(id).isPresent()) {
            return customModel(viewName, model, "Could Not Find Product With ID " + id);
        }
        productService.deleteById(id);
        return new ModelAndView("product/product", model.addAttribute("id", id).addAttribute(ERROR, " Product Deleted").addAttribute(ERROR2, ERROR2SUCCESSFULLY));
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
        viewName = "product/newProduct";
        if (model == null) {
            return new ModelAndView(viewName);
        }
        return new ModelAndView(viewName, model.addAttribute("list2", productService.findAllManufacturer()).addAttribute("product", product));
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
        validProduct(viewName, product, model);
        model.addAttribute("list2", productService.findAllManufacturer());
        if (productService.getById(product.getId()).isPresent()) {
            return customModel(viewName, model, " Product With ID " + product.getId() + " Is Used");
        }
        productService.saveEntity(product);
        return new ModelAndView("product/product", model.addAttribute(ERROR, "New Product Added").addAttribute(ERROR2, ERROR2SUCCESSFULLY));
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
        viewName = "product/updateProduct";
        if (model == null) {
            return new ModelAndView(viewName);
        }
        return new ModelAndView(viewName, model.addAttribute("product", product).addAttribute("list2", productService.findAllManufacturer()));
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
        validProduct(viewName, product, model);
        model.addAttribute("list2", productService.findAllManufacturer());
        if (!productService.getById(product.getId()).isPresent()) {
            return customModel(viewName, model, "Not Found " + product.getId() + "");
        }
        productService.saveEntity(new Product(product.getId(), product.getName().toUpperCase(), product.getPrice(), product.getManufacturer()));
        return new ModelAndView("product/product", model.addAttribute("manufacturer", product.getManufacturer()).addAttribute(ERROR, " Product Updated").addAttribute(ERROR2, ERROR2SUCCESSFULLY));
    }

    public ModelAndView validProduct(String viewName, Product product, ModelMap model) {
        validProductMini(viewName, product, model);
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
        product.setName(product.getName().toUpperCase());
        return customModel(viewName, model, "");

    }

    public ModelAndView validProductMini(String viewName, Object attribute, ModelMap model) {
        if (model == null) {
            return new ModelAndView(viewName);
        }
        if (attribute == null) {
            return new ModelAndView(viewName);
        }
        if (model.isEmpty()) {
            return new ModelAndView(viewName);
        }
        return customModel(viewName, model, attribute);
    }
}
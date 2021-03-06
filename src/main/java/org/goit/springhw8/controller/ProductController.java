package org.goit.springhw8.controller;

import org.goit.springhw8.model.Manufacturer;
import org.goit.springhw8.model.Product;
import org.goit.springhw8.service.ManufacturerService;
import org.goit.springhw8.service.ProductService;
import org.goit.springhw8.util.SendErrorMessage;
import org.goit.springhw8.util.Validator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

/**
 * The type Product controller.
 */
@Controller
@RequestMapping("product")
public class ProductController {

    private final SendErrorMessage sendErrorMessage;

    private final ProductService productService;

    private final ManufacturerService manufacturerService;

    private String viewName = "";

    /**
     * Custom model model and view.
     *
     * @param viewName     the view name
     * @param model        the model
     * @param errorMessage the error message
     * @return the model and view
     */
    private ModelAndView customModel(String viewName, ModelMap model, Object errorMessage) {
        return sendErrorMessage.customModel(viewName, model, errorMessage);
    }

    /**
     * Custom model ok model and view.
     *
     * @param viewName     the view name
     * @param model        the model
     * @param errorMessage the error message
     * @return the model and view
     */
    private ModelAndView customModelOk(String viewName, ModelMap model, Object errorMessage) {
        return sendErrorMessage.customModelOK(viewName, model, errorMessage);
    }

    /**
     * Instantiates a new Product controller.
     *
     * @param productService      the product service
     * @param manufacturerService the manufacturer service
     * @param sendErrorMessage    the send error message
     */
    public ProductController(ProductService productService, ManufacturerService manufacturerService, SendErrorMessage sendErrorMessage) {
        this.productService = productService;
        this.sendErrorMessage = sendErrorMessage;
        this.manufacturerService = manufacturerService;
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
        return new ModelAndView("product/list", String.valueOf(model), model.addAttribute("list", productService.getAll()));
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
            return customModel(viewName, model, "Product With The ID = " + id + ",\n Is Not Found");
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
    public ModelAndView addNewProductGet(Product product, ModelMap model) {
        return new ModelAndView("product/newProduct", String.valueOf(model), model.addAttribute("list2", productService.findAllManufacturer()).addAttribute("product", product));
    }

    /**
     * Add new product post model and view.
     *
     * @param id           the id
     * @param name         the name
     * @param price        the price
     * @param manufacturer the manufacturer
     * @param model        the model
     * @return the model and view
     */
    @RequestMapping(value = "new/**", method = RequestMethod.POST)
    public ModelAndView addNewProductPost(String id, String name, String price, String manufacturer, ModelMap model) {
        viewName = "product/newProduct";
        if (model == null) {
            return new ModelAndView(viewName);
        }

        model.addAttribute("list2", productService.findAllManufacturer());
        if (!notNullNotEmpty(viewName, name, price, model).isEmpty()) {
            if (!Validator.validName(name)) {
                return customModel(viewName, model, "Invalid Product Name");
            }
            if (!Validator.isValidPrice(price)) {
                return customModel(viewName, model, "Invalid Price Value");
            }
            if (productService.getById(id).isPresent()) {
                return customModel(viewName, model, " Product With ID " + id + " Is Used");
            }
        }
        Optional<Manufacturer> manufacturer1 = manufacturerService.getById(manufacturer);
        if (!manufacturer1.isPresent()) {
            return customModel(viewName, model, "Not Found Manufacturer");
        }

        productService.saveEntity(new Product(id, name.toUpperCase(), Double.parseDouble(price), manufacturer1.get()));
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
    public ModelAndView updateProductGet(Product product, ModelMap model) {
        return new ModelAndView("product/updateProduct", String.valueOf(model), model.addAttribute("product", product).addAttribute("list2", productService.findAllManufacturer()));
    }

    /**
     * Update product post model and view.
     *
     * @param id           the id
     * @param name         the name
     * @param price        the price
     * @param manufacturer the manufacturer
     * @param model        the model
     * @return the model and view
     */
    @RequestMapping(value = "update/**", method = RequestMethod.POST)
    public ModelAndView updateProductPost(String id, String name, String price, String manufacturer, ModelMap model) {
        viewName = "product/updateProduct";
        if (model == null) {
            return new ModelAndView(viewName);
        }

        model.addAttribute("list2", productService.findAllManufacturer());
        if (!notNullNotEmpty(viewName, name, price, model).isEmpty()) {
            if (!Validator.validName(name)) {
                return customModel(viewName, model, "Invalid Product Name");
            }
            if (!Validator.isValidPrice(price)) {
                return customModel(viewName, model, "Invalid Price Value");
            }
            if (!productService.getById(id).isPresent()) {
                return customModel(viewName, model, "Not Found " + id + "");
            }
        }
        Optional<Manufacturer> manufacturer1 = manufacturerService.getById(manufacturer);
        if (!manufacturer1.isPresent()) {
            return customModel(viewName, model, "Not Found Manufacturer");
        }

        productService.saveEntity(new Product(id, name.toUpperCase(), Double.parseDouble(price), manufacturer1.get()));
        return customModelOk("product/product", model.addAttribute("manufacturer", manufacturer1.get()), "Product Updated");
    }

    private ModelAndView notNullNotEmpty(String viewName, String name, String price, ModelMap model) {
        if (name == null || name.isEmpty()) {
            return customModel(viewName, model, "Product Name Is Null Or Empty");
        }
        if (price == null || price.isEmpty()) {
            return customModel(viewName, model, "Product Price Is Null Or Empty");
        }
        return customModel(viewName, model, "");
    }
}
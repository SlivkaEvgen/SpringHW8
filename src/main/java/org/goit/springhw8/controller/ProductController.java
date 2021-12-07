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
@RequestMapping("product")  // валидация цены и мануфактурера у продукта
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
            model.addAttribute("id", id);
            model.addAttribute("error", "Product ID Is Empty");
            model.addAttribute("error2", "Please, Try Again");
            return new ModelAndView("product/productById", model);
        }
        if (!Validator.validId(id)) {
            model.addAttribute("id", id);
            model.addAttribute("error", "WRONG Product ID ");
            model.addAttribute("error2", "Please, Try Again");
            return new ModelAndView("product/productById", model);
        }
        if (!productService.getById(id).isPresent()) {
            model.addAttribute("id", id);
            model.addAttribute("error", "Could Not Find Product With ID " + id);
            model.addAttribute("error2", "Please, Try Again");
            return new ModelAndView("product/productById", model);
        }
        model.addAttribute("id", id);
        model.addAttribute("error2", "SUCCESSFULLY");
        return new ModelAndView("product/productById", model.addAttribute("list", productService.findListById(id)));
    }

    @GetMapping("name")
    public ModelAndView findByName(String name, ModelMap model) {
        if (name == null) {
            return new ModelAndView("product/productByName", model);
        }
        if (name.isEmpty()) {
            model.addAttribute("name", name);
            model.addAttribute("error", "Product Name Is Empty");
            model.addAttribute("error2", "Please, Try Again");
            return new ModelAndView("product/productByName", model);
        }
        if (!Validator.validName(name)) {
            model.addAttribute("name", name);
            model.addAttribute("error", "WRONG Product Name ");
            model.addAttribute("error2", "Please, Try Again");
            return new ModelAndView("product/productByName", model);
        }
        if (productService.getByName(name).isEmpty()) {
            model.addAttribute("name", name);
            model.addAttribute("error", "Could Not Find Product With Name " + name);
            model.addAttribute("error2", "Please, Try Again");
            return new ModelAndView("product/productByName", model);
        }
        model.addAttribute("name", name);
        model.addAttribute("error2", "SUCCESSFULLY");
        return new ModelAndView("product/productByName", model.addAttribute("list", productService.getByName(name)));
    }

    @GetMapping("delete")
    public ModelAndView delete(String id, ModelMap model) {
        if (id == null) {
            return new ModelAndView("product/deleteProduct", model);
        }
        if (id.isEmpty()) {
            model.addAttribute("id", id);
            model.addAttribute("error", "Product ID Is Empty");
            model.addAttribute("error2", "Please, Try Again");
            return new ModelAndView("product/deleteProduct", model);
        }
        if (!Validator.validId(id)) {
            model.addAttribute("id", id);
            model.addAttribute("error", "WRONG Product ID ");
            model.addAttribute("error2", "Please, Try Again");
            return new ModelAndView("product/deleteProduct", model);
        }
        if (!productService.getById(id).isPresent()) {
            model.addAttribute("id", id);
            model.addAttribute("error", "Could Not Find Product With ID " + id);
            model.addAttribute("error2", "Please, Try Again");
            return new ModelAndView("product/deleteProduct", model);
        }
        productService.deleteById(id);
        model.addAttribute("id", id);
        model.addAttribute("error", " Product Deleted");
        model.addAttribute("error2", "SUCCESSFULLY");
        return new ModelAndView("product/product", model);
    }

    @GetMapping("new/**")
    public ModelAndView addNew(Product product, @NotNull ModelMap model) {
        return new ModelAndView("product/newProduct", model.addAttribute("product", product));
    }

    @RequestMapping(value = "new", method = RequestMethod.POST)
    public ModelAndView addNewPost(Product product, ModelMap model) {
        if (product == null) {
            model.addAttribute("error", "Product Is Null");
            model.addAttribute("error2", "Please, Try Again");
            return new ModelAndView("product/newProduct", model);
        }
        if (product.getId() == null) {
            model.addAttribute("product", product);
            model.addAttribute("error", "Product ID Is Null");
            model.addAttribute("error2", "Please, Try Again");
            return new ModelAndView("product/newProduct", model);
        }
        if (product.getId().isEmpty()) {
            // to do
            model.addAttribute("product", product);

            return new ModelAndView("product/newProduct", model);
        }
        if (!Validator.validId(product.getId())) {
            // to do
            model.addAttribute("product", product);

            return new ModelAndView("product/newProduct", model);
        }
        if (product.getName() == null) {
            model.addAttribute("product", product);
            model.addAttribute("error", "Product Name Is Null");
            model.addAttribute("error2", "Please, Try Again");
            return new ModelAndView("product/newProduct", model);
        }
        if (product.getName().isEmpty()) {
            //to do
            model.addAttribute("product", product);

            return new ModelAndView("product/newProduct", model);
        }
        if (!Validator.validName(product.getName())) {
            // to do
            model.addAttribute("product", product);

            return new ModelAndView("product/newProduct", model);
        }
        if (product.getPrice() == null) {
            model.addAttribute("product", product);
            model.addAttribute("error", "Product Price Is Null");
            model.addAttribute("error2", "Please, Try Again");
            return new ModelAndView("product/newProduct", model);
        }

        if (product.getManufacturer() == null) {
            model.addAttribute("product", product);
            model.addAttribute("error", "Manufacture Of Product Is Null");
            model.addAttribute("error2", "Please, Try Again");
            return new ModelAndView("product/newProduct", model);
        }

        if (productService.getById(product.getId()).isPresent()) {
            model.addAttribute("product", product);
            model.addAttribute("error", " Product With ID " + product.getId() + " Is Used");
            model.addAttribute("error2", "Please, Try Again");
            return new ModelAndView("product/newProduct", model);
        }
        model.addAttribute("error", "New Product Added");
        model.addAttribute("error2", "SUCCESSFULLY");
        product.setName(product.getName().toUpperCase());
        productService.saveEntity(product);
        return new ModelAndView("product/product", model);
    }

    @GetMapping("update/**")
    public ModelAndView update(Product product, @NotNull ModelMap model) {
        return new ModelAndView("product/updateProduct", model.addAttribute("product", product));
    }

    @RequestMapping(value = "update/**", method = RequestMethod.POST)
    public ModelAndView updatePost(@NotNull Product product, ModelMap model) {
        if (product.getId() == null) {
            return new ModelAndView("product/updateProduct", model.addAttribute("product", product));
        }

        if (product.getName() == null) {
            model.addAttribute("product", product);

            return new ModelAndView("product/updateProduct", model);
        }

        if (product.getPrice() == null) {
            model.addAttribute("product", product);

            return new ModelAndView("product/updateProduct", model);
        }

        if (product.getManufacturer() == null) {
            model.addAttribute("product", product);

            return new ModelAndView("product/updateProduct", model);
        }

        if (product.getId().isEmpty()) {
            model.addAttribute("product", product);

            return new ModelAndView("product/updateProduct", model);
        }

        if (product.getName().isEmpty()) {
            model.addAttribute("product", product);

            return new ModelAndView("product/updateProduct", model);
        }

        if (!Validator.validId(product.getId())) {
            model.addAttribute("error2", "Try Again");
            model.addAttribute("error", "Wrong ID");
            return new ModelAndView("product/updateProduct", model);
        }

        if (!Validator.validName(product.getName())) {
            model.addAttribute("product", product);

            return new ModelAndView("product/updateProduct", model);
        }
        model.addAttribute("error", " Product Updated");
        model.addAttribute("error2", "SUCCESSFULLY");
        product.setName(product.getName().toUpperCase());
        productService.saveEntity(product);
        return new ModelAndView("product/product", model.addAttribute("product", product));
    }
}
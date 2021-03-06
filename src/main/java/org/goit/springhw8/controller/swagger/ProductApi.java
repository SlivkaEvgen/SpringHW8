package org.goit.springhw8.controller.swagger;

import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.Operation;
import org.goit.springhw8.model.Manufacturer;
import org.goit.springhw8.model.Product;
import org.goit.springhw8.service.ManufacturerService;
import org.goit.springhw8.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * The type Product api.
 */
@Controller
@RequestMapping(value = "api/product")
public class ProductApi {

    private final ProductService productService;

    private final ManufacturerService manufacturerService;

    /**
     * Instantiates a new Product api.
     *
     * @param productService      the product service
     * @param manufacturerService the manufacturer service
     */
    public ProductApi(ProductService productService, ManufacturerService manufacturerService) {
        this.productService = productService;
        this.manufacturerService = manufacturerService;
    }

    /**
     * Gets all products.
     *
     * @return the all products
     */
    @Operation(summary = "Show All Products", description = " All Products")
    @GetMapping("list")
    @ResponseBody
    public List<Product> getAllProducts() {
        return productService.getAll();
    }

    /**
     * Gets product by id.
     *
     * @param id the id
     * @return the product by id
     */
    @Operation(summary = "Find Product by ID", description = "Show Product by ID")
    @GetMapping("/{id}")
    @ResponseBody
    public Optional<Product> getProductById(@PathVariable @ApiParam(required = true, value = " Example : 1 ") String id) {
        return productService.getById(id);
    }

    /**
     * Gets product by name.
     *
     * @param name the name
     * @return the product by name
     */
    @Operation(summary = "Find Products by Name", description = " Show Products by Name ")
    @GetMapping("/name/{name}")
    @ResponseBody
    public List<Product> getProductByName(@PathVariable @ApiParam(required = true, value = " Example : MICROWAVE ") String name) {
        return productService.findByName(name);
    }

    /**
     * Delete product by id.
     *
     * @param id the id
     */
    @Operation(summary = "Delete Product", description = "Delete Product")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteProductById(@ApiParam(required = true, value = " Example : 4 ") @PathVariable String id) {
        productService.deleteById(id);
    }

    /**
     * Add new product get product.
     *
     * @param name         the name
     * @param price        the price
     * @param manufacturer the manufacturer
     * @return the product
     */
    @Operation(summary = "New Product", description = "Create the New Product")
    @RequestMapping(value = "/new/{name}&{price}&{manufacturer}", method = RequestMethod.POST)
    @ResponseBody
    public Product addNewProductGet(
            @PathVariable(value = "name") @ApiParam(value = "Product Name; Example : Iphone ") String name,
            @PathVariable(value = "price") @ApiParam(value = "Product Price; Example : 999.00 ") String price,
            @PathVariable(value = "manufacturer") @ApiParam(value = "Manufacturer ID; Example : 1 ") String manufacturer) {
        Product product = setIntoProduct(new Product(),
                name,
                price,
                manufacturer);
        productService.saveEntity(product);
        return product;
    }

    /**
     * Update product get product.
     *
     * @param id           the id
     * @param name         the name
     * @param price        the price
     * @param manufacturer the manufacturer
     * @return the product
     */
    @Operation(summary = "Update Product ", description = "Update Product")
    @RequestMapping(value = "/update/{id}&{name}&{price}&{manufacturer}", method = RequestMethod.PUT)
    @ResponseBody
    public Product updateProductGet(
            @PathVariable(value = "id") @ApiParam(value = "Product ID; Example : 1 ") String id,
            @PathVariable(value = "name") @ApiParam(value = "Product Name; Example : Iphone ") String name,
            @PathVariable(value = "price") @ApiParam(value = "Product Price; Example : 999.00 ") String price,
            @PathVariable(value = "manufacturer") @ApiParam(value = "Manufacturer ID; Example : 1 ") String manufacturer) {
        Optional<Product> optionalProduct = productService.getById(id);
        if (!optionalProduct.isPresent()) {
            return null;
        } else {
            Product product = setIntoProduct(optionalProduct.get(),
                    name,
                    price,
                    manufacturer);
            productService.saveEntity(product);
            return product;
        }
    }

    private Product setIntoProduct(Product product, String name, String price, String manufacturer) {
        if (name == null) {
            return null;
        }
        product.setName(name.toUpperCase());
        product.setPrice(Double.valueOf(price));
        Optional<Manufacturer> optionalManufacturer = manufacturerService.getById(manufacturer);
        optionalManufacturer.ifPresent(product::setManufacturer);
        return product;
    }
}

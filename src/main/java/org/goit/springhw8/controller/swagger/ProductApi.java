package org.goit.springhw8.controller.swagger;

import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.goit.springhw8.model.Manufacturer;
import org.goit.springhw8.model.Product;
import org.goit.springhw8.service.ManufacturerService;
import org.goit.springhw8.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "api/product")
public class ProductApi {

    private final ProductService productService;
    private final ManufacturerService manufacturerService;


    public ProductApi(ProductService productService, ManufacturerService manufacturerService) {
        this.productService = productService;
        this.manufacturerService=manufacturerService;
    }

    @Operation(summary = "Show All Products", description = " All Products")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "successful operation", content =
//                    {@Content(mediaType = "application/json", schema = @Schema(implementation = Product.class))}),
//            @ApiResponse(responseCode = "404", description = "Not found", content =
//                    {@Content(mediaType = "application/json")})})
    @GetMapping("list")
    @ResponseBody
    public List<Product> getAllProducts() {
        return productService.getAll();
    }

    @Operation(summary = "Find Product by ID", description = "Show Product by ID")
    @GetMapping("id")
    @ResponseBody
    public Optional<Product> getProductById(@ApiParam(required = true, value = " Example : 1 ") String id) {
        return productService.getById(id);
    }

    @Operation(summary = "Find Products by Name", description = " Show Products by Name ")
    @GetMapping("name")
    @ResponseBody
    public List<Product> getProductByName(@ApiParam(required = true, value = " Example : MICROWAVE ") String name) {
        return productService.findByName(name);
    }

    @Operation(summary = "Delete Product", description = "Delete Product")
    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteProductById(@ApiParam(required = true, value = " Example : 4 ") @PathVariable String id) {
        productService.deleteById(id);
    }

    @RequestMapping(value = "new", method = RequestMethod.POST)
    @ResponseBody
    @Operation(summary = "New Product", description = "Create the New Product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Product.class))}),
            @ApiResponse(responseCode = "400",
                    description = "Product not found by id specified in the request",
                    content = @Content)})
    public void addNewProductGet(@PathVariable(value = "ID") @ApiParam(value = " Example : 12 ") String id,
                                 @PathVariable(value = "Name") @ApiParam(value = " Example : Iphone ") String name,
                                 @PathVariable(value = "Price") @ApiParam(value = " Example : 999.00 ") String price,
                                 @PathVariable(value = "Manufacturer ID") @ApiParam(value = " Example : 1 ") String manufacturer) {
        Product product = new Product();
        product.setId(id);
        product.setName(name);
        product.setPrice(Double.valueOf(price));
        Optional<Manufacturer> optionalManufacturer = manufacturerService.getById(manufacturer);
        optionalManufacturer.ifPresent(product::setManufacturer);
        productService.saveEntity(product);
    }

    @Operation(summary = "Update Product ", description = "Update Product")
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    @ResponseBody
    public void updateProductGet(@PathVariable(value = "ID") @ApiParam(value = " Example : 12 ") String id,
                                 @PathVariable(value = "Name") @ApiParam(value = " Example : Iphone ") String name,
                                 @PathVariable(value = "Price") @ApiParam(value = " Example : 999.00 ") String price,
                                 @PathVariable(value = "Manufacturer ID") @ApiParam(value = " Example : 1 ") String manufacturer) {
        Optional<Product> optionalProduct = productService.getById(id);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setId(id);
            product.setName(name);
            product.setPrice(Double.valueOf(price));
            Optional<Manufacturer> optionalManufacturer = manufacturerService.getById(manufacturer);
            optionalManufacturer.ifPresent(product::setManufacturer);
            productService.saveEntity(product);
        }
    }
}

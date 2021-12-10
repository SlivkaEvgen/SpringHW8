package org.goit.springhw8.service;

import org.goit.springhw8.model.Manufacturer;
import org.goit.springhw8.model.Product;
import org.goit.springhw8.repository.ManufacturerRepository;
import org.goit.springhw8.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Product service.
 */
@Service
public class ProductService extends ServiceI<Product, String> {

    private final ManufacturerRepository manufacturerRepository;

    /**
     * Instantiates a new Product service.
     *
     * @param productRepository      the product repository
     * @param manufacturerRepository the manufacturer repository
     */
    public ProductService(ProductRepository productRepository, ManufacturerRepository manufacturerRepository) {
        super(productRepository);
        this.manufacturerRepository = manufacturerRepository;
    }

    /**
     * Find all manufacturer list.
     *
     * @return the list
     */
    public List<Manufacturer> findAllManufacturer() {
        return manufacturerRepository.findAll();
    }
}

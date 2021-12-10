package org.goit.springhw8.service;

import org.goit.springhw8.model.Manufacturer;
import org.goit.springhw8.model.Product;
import org.goit.springhw8.repository.ManufacturerRepository;
import org.goit.springhw8.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService extends ServiceI<Product, String> {

    private final ManufacturerRepository manufacturerRepository;

    public ProductService(ProductRepository productRepository, ManufacturerRepository manufacturerRepository) {
        super(productRepository);
        this.manufacturerRepository = manufacturerRepository;
    }

    public List<Manufacturer> findAllManufacturer() {
        return manufacturerRepository.findAll();
    }
}

package org.goit.springhw8.service;

import org.goit.springhw8.model.Product;
import org.goit.springhw8.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends ServiceI<Product,String> {

    public ProductService(ProductRepository productRepository) {
        super(productRepository);
    }

}

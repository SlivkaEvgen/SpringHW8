package org.goit.springhw8.service;

import org.goit.springhw8.model.Product;
import org.goit.springhw8.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> findProductById(String id) {
        return productRepository.findById(Long.parseLong(id));
    }

    public List<Product> findProductByName(String name) {
        return productRepository.findByName(name);
    }

    public void deleteProduct(String id) {
        if (productRepository.findById(Long.parseLong(id)).isPresent()) {
            productRepository.deleteById(Long.parseLong(id));
        }
    }

    public void saveProduct(Product product) {
        productRepository.save(product);
    }

}

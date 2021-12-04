package org.goit.springhw8.service;

import org.goit.springhw8.model.Product;
import org.goit.springhw8.repository.RepositoryI;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService extends ServiceI<Product, String> {

    private final RepositoryI<Product, String> productRepository;

    public ProductService(RepositoryI<Product, String> productRepository) {
        super(productRepository);
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(String id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> findByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public void delete(String id) {
        if (productRepository.findById(id).isPresent()) {
            productRepository.deleteById(id);
        }
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

}

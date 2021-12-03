package org.goit.springhw8.service;

import org.goit.springhw8.model.Product;
import org.goit.springhw8.repository.RepositoryI;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService extends ServiceI<Product, Long> {

    private final RepositoryI<Product, Long> productRepository;

    public ProductService(RepositoryI<Product, Long> productRepository) {
        super(productRepository);
        this.productRepository = productRepository;
    }

    @Override
     public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
     public Optional<Product> findById(Long id) {
        return productRepository.findById(Long.parseLong(String.valueOf(id)));
    }

    @Override
    public List<Product> findByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public void delete(Long id) {
        if (productRepository.findById(Long.parseLong(String.valueOf(id))).isPresent()) {
            productRepository.deleteById(Long.parseLong(String.valueOf(id)));
        }
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

}

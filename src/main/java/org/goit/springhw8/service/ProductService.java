package org.goit.springhw8.service;

import org.goit.springhw8.model.Product;
import org.goit.springhw8.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository=productRepository;
    }

    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> findProductById(String id) {
        return productRepository.findById(Long.parseLong(id));
    }

    public Iterable<Product> findProductByName(String name) {
        return productRepository.findByName(name);
    }

    public void deleteProduct(Long id) {
        if (productRepository.findById(id).isPresent()) {
            productRepository.deleteById(id);
        }
    }

    public void saveProduct(Product product) {
        productRepository.save(product);
    }

//    public List<Product> byManufacturerId(String id){
//        System.out.println(id);
//
//        return productRepository.findAll()
//                .stream()
//                .filter(product -> product.getManufacturer().getId() == Long.parseLong(id))
//                .collect(Collectors.toList());
//    }

}

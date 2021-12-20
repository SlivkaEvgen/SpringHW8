package org.goit.springhw8.repository;

import org.goit.springhw8.model.Product;
import org.springframework.stereotype.Repository;

/**
 * The interface Product repository.
 */
@Repository
public interface ProductRepository extends RepositoryI<Product, String> {

}

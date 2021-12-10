package org.goit.springhw8.repository;

import org.goit.springhw8.model.Manufacturer;
import org.goit.springhw8.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends RepositoryI<Product, String> {

    @Query("SELECT p FROM #{#entityName} p WHERE p.manufacturer.id=?1")
    List<Manufacturer> findByManufacturerId(String manufacturerId);
}

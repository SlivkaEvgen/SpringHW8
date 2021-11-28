package org.goit.springhw8.repository;

import org.goit.springhw8.model.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {

    List<Manufacturer> findByName(String name);

}

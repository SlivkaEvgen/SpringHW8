package org.goit.springhw8.repository;

import org.goit.springhw8.model.Manufacturer;
import org.springframework.stereotype.Repository;

@Repository
public interface ManufacturerRepository extends RepositoryI<Manufacturer, String> {

}

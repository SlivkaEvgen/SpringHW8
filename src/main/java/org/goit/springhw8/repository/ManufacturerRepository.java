package org.goit.springhw8.repository;

import org.goit.springhw8.model.Manufacturer;
import org.springframework.stereotype.Repository;

/**
 * The interface Manufacturer repository.
 */
@Repository
public interface ManufacturerRepository extends RepositoryI<Manufacturer, String> {

}

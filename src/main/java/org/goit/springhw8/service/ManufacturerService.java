package org.goit.springhw8.service;

import org.goit.springhw8.model.Manufacturer;
import org.goit.springhw8.repository.ManufacturerRepository;
import org.springframework.stereotype.Service;

/**
 * The type Manufacturer service.
 */
@Service
public class ManufacturerService extends ServiceI<Manufacturer, String> {

    /**
     * Instantiates a new Manufacturer service.
     *
     * @param manufacturerRepository the manufacturer repository
     */
    public ManufacturerService(ManufacturerRepository manufacturerRepository) {
        super(manufacturerRepository);
    }

}

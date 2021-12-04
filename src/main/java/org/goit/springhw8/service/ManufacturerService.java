package org.goit.springhw8.service;

import org.goit.springhw8.model.Manufacturer;
import org.goit.springhw8.repository.ManufacturerRepository;
import org.springframework.stereotype.Service;

@Service
public class ManufacturerService extends ServiceI<Manufacturer,String> {

    public ManufacturerService(ManufacturerRepository manufacturerRepository) {
        super(manufacturerRepository);
    }

}

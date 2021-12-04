package org.goit.springhw8.service;

import org.goit.springhw8.model.Manufacturer;
import org.goit.springhw8.repository.RepositoryI;
import org.goit.springhw8.util.Validator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManufacturerService extends ServiceI<Manufacturer, String> {

    private final RepositoryI<Manufacturer, String> manufacturerRepository;

    public ManufacturerService(RepositoryI<Manufacturer, String> manufacturerRepository) {
        super(manufacturerRepository);
        this.manufacturerRepository = manufacturerRepository;
    }

    @Override
    public List<Manufacturer> getAll() {
        return manufacturerRepository.findAll();
    }

    @Override
    public Optional<Manufacturer> findById(String id) {
        return manufacturerRepository.findById(id);
    }

    @Override
    public List<Manufacturer> findByName(String name) {
        return manufacturerRepository.findByName(name);
    }

    @Override
    public void delete(String id) {
        System.out.println("SERVICE MANUFACTURER");
        if (id == null) {
            return;
        }
        if (!Validator.validId(id)) {
            return;
        }
        if (manufacturerRepository.findById(id).isPresent()) {
            manufacturerRepository.deleteById(id);
        }
    }

    @Override
    public void save(Manufacturer manufacturer) {
        System.out.println("ManufacturerService save "+ manufacturer);
        manufacturerRepository.save(manufacturer);
    }
}

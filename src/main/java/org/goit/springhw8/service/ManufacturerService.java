package org.goit.springhw8.service;

import org.goit.springhw8.model.Manufacturer;
import org.goit.springhw8.repository.ManufacturerRepository;
import org.goit.springhw8.util.Validator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManufacturerService {

    private final ManufacturerRepository manufacturerRepository;

    public ManufacturerService(ManufacturerRepository manufacturerRepository1){

        this.manufacturerRepository = manufacturerRepository1;
    }

    public List<Manufacturer> getAllManufacturers() {
        return manufacturerRepository.findAll();
    }

    public Optional<Manufacturer> findManufacturerById(String id) {
        return manufacturerRepository.findById(Long.parseLong(id));
    }

    public List<Manufacturer> findByManufacturerName(String name) {
        return manufacturerRepository.findByName(name);
    }

    public void deleteManufacturer(String id) {
        System.out.println("SERVICE MANUFACTURER");
        if (id == null) {
            Optional.of("ID == null");
        }
        if (!Validator.validId(id)) {
            Optional.of(" NO VALID ID");
        }
        if (manufacturerRepository.findById(Long.parseLong(id)).isPresent()) {
            manufacturerRepository.deleteById(Long.parseLong(id));
        }
        Optional.of("ID request completed");
    }

    public Optional<Object> saveManufacturer(Manufacturer manufacturer) {
        return Optional.of(manufacturerRepository.save(manufacturer));
    }
}

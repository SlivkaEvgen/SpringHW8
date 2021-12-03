package org.goit.springhw8.service;

import org.goit.springhw8.model.Manufacturer;
import org.goit.springhw8.repository.RepositoryI;
import org.goit.springhw8.util.Validator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManufacturerService extends ServiceI<Manufacturer, Long> {

    private final RepositoryI<Manufacturer, Long> manufacturerRepository;

    public ManufacturerService(RepositoryI<Manufacturer, Long> manufacturerRepository) {
        super(manufacturerRepository);
        this.manufacturerRepository = manufacturerRepository;
    }

    @Override
    public List<Manufacturer> getAll() {
        return manufacturerRepository.findAll();
    }

    @Override
    public Optional<Manufacturer> findById(Long id) {
        return manufacturerRepository.findById(Long.parseLong(String.valueOf(id)));
    }

    @Override
    public List<Manufacturer> findByName(String name) {
        return manufacturerRepository.findByName(name);
    }

    @Override
    public void delete(Long id) {
        System.out.println("SERVICE MANUFACTURER");
        if (id == null) {
            return;
//            Optional.of("ID == null");
        }
        if (!Validator.validId(String.valueOf(id))) {
            return;
//            Optional.of(" NO VALID ID");
        }
        if (manufacturerRepository.findById(Long.parseLong(String.valueOf(id))).isPresent()) {
            manufacturerRepository.deleteById(Long.parseLong(String.valueOf(id)));
        }
//        Optional.of("ID request completed");
    }

    @Override
    public void save(Manufacturer manufacturer) {
        manufacturerRepository.save(manufacturer);
    }
}

package org.goit.springhw8.service;

import org.goit.springhw8.model.English;
import org.goit.springhw8.repository.EnglishRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnglishService extends ServiceI<English,String> {

    private final EnglishRepository englishRepository;

    public EnglishService(EnglishRepository englishRepository) {
        super(englishRepository);
        this.englishRepository=englishRepository;
    }

    public List<English> findByUkrainianNameContainingIgnoreCase(String ukr){
        return englishRepository.findByUkrainianNameContainingIgnoreCase(ukr);
    }
}

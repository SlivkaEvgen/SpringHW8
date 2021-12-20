package org.goit.springhw8.service;

import org.goit.springhw8.model.English;
import org.goit.springhw8.repository.EnglishRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type English service.
 */
@Service
public class EnglishService extends ServiceI<English,String> {

    private final EnglishRepository englishRepository;

    /**
     * Instantiates a new English service.
     *
     * @param englishRepository the english repository
     */
    public EnglishService(EnglishRepository englishRepository) {
        super(englishRepository);
        this.englishRepository=englishRepository;
    }

    /**
     * Find by ukrainian name containing ignore case list.
     *
     * @param ukr the ukr
     * @return the list
     */
    public List<English> findByUkrainianNameContainingIgnoreCase(String ukr){
        return englishRepository.findByUkrainianNameContainingIgnoreCase(ukr);
    }
}

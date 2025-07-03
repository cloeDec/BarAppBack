package com.foreach.barapp.barapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foreach.barapp.barapp.models.ComposedOf;
import com.foreach.barapp.barapp.repository.ComposedOfRepository;

@Service
public class ComposedOfService {
    @Autowired
    private ComposedOfRepository composedOfRepository;

    public List<ComposedOf> getAllComposedOf() {
        return composedOfRepository.findAll();
    }

    public Optional<ComposedOf> getComposedOfById(Integer id) {
        return composedOfRepository.findById(id);
    }

    public ComposedOf createComposedOf(ComposedOf composedOf) {
        return composedOfRepository.save(composedOf);
    }

    public Optional<ComposedOf> updateComposedOf(Integer id, ComposedOf composedOfDetails) {
        return composedOfRepository.findById(id).map(composedOf -> {
            composedOf.setIngredient_id(composedOfDetails.getIngredient_id());
            composedOf.setQuantity(composedOfDetails.getQuantity());
            return composedOfRepository.save(composedOf);
        });
    }

    public boolean deleteComposedOf(Integer id) {
        if (composedOfRepository.existsById(id)) {
            composedOfRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
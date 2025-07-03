package com.foreach.barapp.barapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foreach.barapp.barapp.models.Ingredient;
import com.foreach.barapp.barapp.repository.IngredientRepository;

@Service
public class IngredientService {
    @Autowired
    private IngredientRepository ingredientRepository;

    public List<Ingredient> getAllIngredient() {
        return ingredientRepository.findAll();
    }

    public Optional<Ingredient> getIngredientById(Integer id) {
        return ingredientRepository.findById(id);
    }

    public Ingredient createIngredient(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    public Optional<Ingredient> updateIngredient(Integer id, Ingredient ingredientDetails) {
        return ingredientRepository.findById(id).map(ingredient -> {
            ingredient.setIngredient_name(ingredientDetails.getIngredient_name());
            return ingredientRepository.save(ingredient);
        });
    }

    public boolean deleteIngredient(Integer id) {
        if (ingredientRepository.existsById(id)) {
            ingredientRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
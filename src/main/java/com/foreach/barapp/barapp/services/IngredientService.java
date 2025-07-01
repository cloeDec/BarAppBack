package com.foreach.barapp.barapp.services;

import java.util.List;

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
}
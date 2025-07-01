package com.foreach.barapp.barapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foreach.barapp.barapp.models.Ingredient;
import com.foreach.barapp.barapp.services.IngredientService;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/ingredient")
public class IngredientController {
    @Autowired
    private IngredientService ingredientService;

    @GetMapping
    public List<Ingredient> getComposedOf() {
        return ingredientService.getAllIngredient();
    }
}
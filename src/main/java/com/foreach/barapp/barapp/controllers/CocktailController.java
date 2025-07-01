package com.foreach.barapp.barapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foreach.barapp.barapp.models.Cocktail;
import com.foreach.barapp.barapp.services.CocktailService;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/cocktailsprice")
public class CocktailController {
    @Autowired
    private CocktailService cocktailService;

    @GetMapping
    public List<Cocktail> getCocktails() {
        return cocktailService.getAllCocktails();
    }
}

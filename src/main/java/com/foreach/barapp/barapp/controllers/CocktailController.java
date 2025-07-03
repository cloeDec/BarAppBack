package com.foreach.barapp.barapp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foreach.barapp.barapp.models.Cocktail;
import com.foreach.barapp.barapp.services.CocktailService;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/cocktails")
public class CocktailController {
    @Autowired
    private CocktailService cocktailService;

    @GetMapping
    public List<Cocktail> getCocktails() {
        return cocktailService.getAllCocktails();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cocktail> getCocktailById(@PathVariable Integer id) {
        Optional<Cocktail> cocktail = cocktailService.getCocktailById(id);
        return cocktail.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Cocktail createCocktail(@RequestBody Cocktail cocktail) {
        return cocktailService.createCocktail(cocktail);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cocktail> updateCocktail(@PathVariable Integer id, @RequestBody Cocktail cocktail) {
        Optional<Cocktail> updated = cocktailService.updateCocktail(id, cocktail);
        return updated.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCocktail(@PathVariable Integer id) {
        boolean deleted = cocktailService.deleteCocktail(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}

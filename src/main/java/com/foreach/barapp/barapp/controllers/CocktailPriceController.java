package com.foreach.barapp.barapp.controllers;
import java.util.List;

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

import com.foreach.barapp.barapp.models.CocktailPrice;
import com.foreach.barapp.barapp.services.CocktailPriceService;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/cocktailsprice")
public class CocktailPriceController {
    @Autowired
    private CocktailPriceService cocktailPriceService;

    @GetMapping
    public List<CocktailPrice> getCocktailsPrice() {
        return cocktailPriceService.getAllCocktailsPrice();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CocktailPrice> getCocktailPriceById(@PathVariable Integer id) {
        return cocktailPriceService.getCocktailPriceById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public CocktailPrice createCocktailPrice(@RequestBody CocktailPrice cocktailPrice) {
        return cocktailPriceService.createCocktailPrice(cocktailPrice);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CocktailPrice> updateCocktailPrice(@PathVariable Integer id, @RequestBody CocktailPrice cocktailPrice) {
        return cocktailPriceService.updateCocktailPrice(id, cocktailPrice)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCocktailPrice(@PathVariable Integer id) {
        boolean deleted = cocktailPriceService.deleteCocktailPrice(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}


package com.foreach.barapp.barapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foreach.barapp.barapp.models.Cocktail;
import com.foreach.barapp.barapp.repository.CocktailRepository;

@Service
public class CocktailService {
    @Autowired
    private CocktailRepository cocktailRepository;

    public List<Cocktail> getAllCocktails() {
        return cocktailRepository.findAll();
    }

    public Optional<Cocktail> getCocktailById(Integer id) {
        return cocktailRepository.findById(id);
    }

    public Cocktail createCocktail(Cocktail cocktail) {
        return cocktailRepository.save(cocktail);
    }

    public Optional<Cocktail> updateCocktail(Integer id, Cocktail cocktailDetails) {
        return cocktailRepository.findById(id).map(cocktail -> {
            cocktail.setCocktail_name(cocktailDetails.getCocktail_name());
            cocktail.setDescription(cocktailDetails.getDescription());
            cocktail.setImage_url(cocktailDetails.getImage_url());
            return cocktailRepository.save(cocktail);
        });
    }

    public boolean deleteCocktail(Integer id) {
        if (cocktailRepository.existsById(id)) {
            cocktailRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

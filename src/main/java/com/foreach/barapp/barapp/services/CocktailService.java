package com.foreach.barapp.barapp.services;

import java.util.List;

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
}

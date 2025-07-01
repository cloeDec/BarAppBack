package com.foreach.barapp.barapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foreach.barapp.barapp.models.CocktailPrice;
import com.foreach.barapp.barapp.repository.CocktailPriceRepository;

@Service
public class CocktailPriceService {
    @Autowired
    private CocktailPriceRepository cocktailPriceRepository;

    public List<CocktailPrice> getAllCocktailsPrice() {
        return cocktailPriceRepository.findAll();
    }
}

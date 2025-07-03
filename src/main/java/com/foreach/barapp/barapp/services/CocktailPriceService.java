package com.foreach.barapp.barapp.services;

import java.util.List;
import java.util.Optional;

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

    public Optional<CocktailPrice> getCocktailPriceById(Integer id) {
        return cocktailPriceRepository.findById(id);
    }

    public CocktailPrice createCocktailPrice(CocktailPrice cocktailPrice) {
        return cocktailPriceRepository.save(cocktailPrice);
    }

    public Optional<CocktailPrice> updateCocktailPrice(Integer id, CocktailPrice cocktailPriceDetails) {
        return cocktailPriceRepository.findById(id).map(cocktailPrice -> {
            cocktailPrice.setSize(cocktailPriceDetails.getSize());
            cocktailPrice.setPrice(cocktailPriceDetails.getPrice());
            return cocktailPriceRepository.save(cocktailPrice);
        });
    }

    public boolean deleteCocktailPrice(Integer id) {
        if (cocktailPriceRepository.existsById(id)) {
            cocktailPriceRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
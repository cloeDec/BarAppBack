package com.foreach.barapp.barapp;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.foreach.barapp.barapp.models.Cocktail;
import com.foreach.barapp.barapp.repository.CocktailRepository;
import com.foreach.barapp.barapp.services.CocktailService;

class CocktailServiceTest {
    @Mock
    private CocktailRepository cocktailRepository;

    @InjectMocks
    private CocktailService cocktailService;


    @Test
    void testGetAllCocktails() {
        List<Cocktail> cocktails = Arrays.asList(new Cocktail(), new Cocktail());
        when(cocktailRepository.findAll()).thenReturn(cocktails);
        List<Cocktail> result = cocktailService.getAllCocktails();
        assertEquals(2, result.size());
    }

    @Test
    void testGetCocktailById() {
        Cocktail cocktail = new Cocktail();
        cocktail.setCocktail_id(1);
        when(cocktailRepository.findById(1)).thenReturn(Optional.of(cocktail));
        Optional<Cocktail> result = cocktailService.getCocktailById(1);
        assertTrue(result.isPresent());
        assertEquals(1, result.get().getCocktail_id());
    }

    @Test
    void testCreateCocktail() {
        Cocktail cocktail = new Cocktail();
        when(cocktailRepository.save(cocktail)).thenReturn(cocktail);
        Cocktail result = cocktailService.createCocktail(cocktail);
        assertNotNull(result);
    }

    @Test
    void testUpdateCocktail() {
        Cocktail existing = new Cocktail();
        existing.setCocktail_id(1);
        existing.setCocktail_name("Old");
        Cocktail update = new Cocktail();
        update.setCocktail_name("New");
        update.setDescription("desc");
        update.setImage_url("img");
        when(cocktailRepository.findById(1)).thenReturn(Optional.of(existing));
        when(cocktailRepository.save(any(Cocktail.class))).thenReturn(existing);
        Optional<Cocktail> result = cocktailService.updateCocktail(1, update);
        assertTrue(result.isPresent());
        assertEquals("New", result.get().getCocktail_name());
    }

    @Test
    void testDeleteCocktail() {
        when(cocktailRepository.existsById(1)).thenReturn(true);
        doNothing().when(cocktailRepository).deleteById(1);
        boolean deleted = cocktailService.deleteCocktail(1);
        assertTrue(deleted);
    }

    @Test
    void testDeleteCocktailNotFound() {
        when(cocktailRepository.existsById(2)).thenReturn(false);
        boolean deleted = cocktailService.deleteCocktail(2);
        assertFalse(deleted);
    }
} 
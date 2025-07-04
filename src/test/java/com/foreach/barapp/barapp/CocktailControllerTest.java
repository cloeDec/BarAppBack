package com.foreach.barapp.barapp;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.foreach.barapp.barapp.models.Cocktail;
import com.foreach.barapp.barapp.services.CocktailService;

class CocktailControllerTest {
    private MockMvc mockMvc;
    @Mock
    private CocktailService cocktailService;
    @InjectMocks
    private final ObjectMapper objectMapper = new ObjectMapper();


    @Test
    void testGetCocktails() throws Exception {
        List<Cocktail> cocktails = Arrays.asList(new Cocktail(), new Cocktail());
        when(cocktailService.getAllCocktails()).thenReturn(cocktails);
        mockMvc.perform(get("/cocktails"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2));
    }

    @Test
    void testGetCocktailByIdFound() throws Exception {
        Cocktail cocktail = new Cocktail();
        cocktail.setCocktail_id(1);
        when(cocktailService.getCocktailById(1)).thenReturn(Optional.of(cocktail));
        mockMvc.perform(get("/cocktails/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.cocktail_id").value(1));
    }

    @Test
    void testGetCocktailByIdNotFound() throws Exception {
        when(cocktailService.getCocktailById(2)).thenReturn(Optional.empty());
        mockMvc.perform(get("/cocktails/2"))
                .andExpect(status().isNotFound());
    }

    @Test
    void testCreateCocktail() throws Exception {
        Cocktail cocktail = new Cocktail();
        cocktail.setCocktail_name("Test");
        when(cocktailService.createCocktail(any(Cocktail.class))).thenReturn(cocktail);
        mockMvc.perform(post("/cocktails")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(cocktail)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.cocktail_name").value("Test"));
    }

    @Test
    void testUpdateCocktailFound() throws Exception {
        Cocktail cocktail = new Cocktail();
        cocktail.setCocktail_id(1);
        cocktail.setCocktail_name("Updated");
        when(cocktailService.updateCocktail(eq(1), any(Cocktail.class))).thenReturn(Optional.of(cocktail));
        mockMvc.perform(put("/cocktails/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(cocktail)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.cocktail_id").value(1))
                .andExpect(jsonPath("$.cocktail_name").value("Updated"));
    }

    @Test
    void testUpdateCocktailNotFound() throws Exception {
        when(cocktailService.updateCocktail(eq(2), any(Cocktail.class))).thenReturn(Optional.empty());
        mockMvc.perform(put("/cocktails/2")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(new Cocktail())))
                .andExpect(status().isNotFound());
    }

    @Test
    void testDeleteCocktailFound() throws Exception {
        when(cocktailService.deleteCocktail(1)).thenReturn(true);
        mockMvc.perform(delete("/cocktails/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    void testDeleteCocktailNotFound() throws Exception {
        when(cocktailService.deleteCocktail(2)).thenReturn(false);
        mockMvc.perform(delete("/cocktails/2"))
                .andExpect(status().isNotFound());
    }
} 
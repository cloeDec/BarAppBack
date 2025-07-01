package com.foreach.barapp.barapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foreach.barapp.barapp.models.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {
}

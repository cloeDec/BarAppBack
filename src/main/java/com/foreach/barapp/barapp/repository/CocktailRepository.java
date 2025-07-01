package com.foreach.barapp.barapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foreach.barapp.barapp.models.Cocktail;

public interface CocktailRepository extends JpaRepository<Cocktail, Integer> {
}

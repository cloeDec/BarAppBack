package com.foreach.barapp.barapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foreach.barapp.barapp.models.CocktailPrice;

public interface CocktailPriceRepository extends JpaRepository<CocktailPrice, Integer> {
}
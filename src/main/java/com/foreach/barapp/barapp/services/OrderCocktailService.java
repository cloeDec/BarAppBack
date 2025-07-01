package com.foreach.barapp.barapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foreach.barapp.barapp.models.OrderCocktail;
import com.foreach.barapp.barapp.repository.OrderCocktailRepository;

@Service
public class OrderCocktailService {
    @Autowired
    private OrderCocktailRepository orderCocktailRepository;

    public List<OrderCocktail> getAllOrderCocktail() {
        return orderCocktailRepository.findAll();
    }
}
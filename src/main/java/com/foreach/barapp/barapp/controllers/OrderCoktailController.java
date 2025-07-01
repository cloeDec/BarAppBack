package com.foreach.barapp.barapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foreach.barapp.barapp.models.OrderCocktail;
import com.foreach.barapp.barapp.services.OrderCocktailService;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/ordercocktail")
public class OrderCoktailController {
    @Autowired
    private OrderCocktailService orderCocktailService;

    @GetMapping
    public List<OrderCocktail> getOrderCocktail() {
        return orderCocktailService.getAllOrderCocktail();
    }
}
package com.foreach.barapp.barapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @GetMapping("/{id}")
    public ResponseEntity<OrderCocktail> getOrderCocktailById(@PathVariable Integer id) {
        return orderCocktailService.getOrderCocktailById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public OrderCocktail createOrderCocktail(@RequestBody OrderCocktail orderCocktail) {
        return orderCocktailService.createOrderCocktail(orderCocktail);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderCocktail> updateOrderCocktail(@PathVariable Integer id, @RequestBody OrderCocktail orderCocktail) {
        return orderCocktailService.updateOrderCocktail(id, orderCocktail)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrderCocktail(@PathVariable Integer id) {
        boolean deleted = orderCocktailService.deleteOrderCocktail(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
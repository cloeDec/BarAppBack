package com.foreach.barapp.barapp.services;

import java.util.List;
import java.util.Optional;

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

    public Optional<OrderCocktail> getOrderCocktailById(Integer id) {
        return orderCocktailRepository.findById(id);
    }

    public OrderCocktail createOrderCocktail(OrderCocktail orderCocktail) {
        return orderCocktailRepository.save(orderCocktail);
    }

    public Optional<OrderCocktail> updateOrderCocktail(Integer id, OrderCocktail orderDetails) {
        return orderCocktailRepository.findById(id).map(order -> {
            order.setOrder_date(orderDetails.getOrder_date());
            order.setOrder_status(orderDetails.getOrder_status());
            order.setCustomer_id(orderDetails.getCustomer_id());
            return orderCocktailRepository.save(order);
        });
    }

    public boolean deleteOrderCocktail(Integer id) {
        if (orderCocktailRepository.existsById(id)) {
            orderCocktailRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
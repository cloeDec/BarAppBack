package com.foreach.barapp.barapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foreach.barapp.barapp.models.OrderLine;
import com.foreach.barapp.barapp.services.OrderLineService;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/orderline")
public class OrderLineController {
    @Autowired
    private OrderLineService orderLineService;

    @GetMapping
    public List<OrderLine> getOrderLine() {
        return orderLineService.getAllOrderLine();
    }
}
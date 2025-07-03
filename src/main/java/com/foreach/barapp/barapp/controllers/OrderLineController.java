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

    @GetMapping("/{id}")
    public ResponseEntity<OrderLine> getOrderLineById(@PathVariable Integer id) {
        return orderLineService.getOrderLineById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public OrderLine createOrderLine(@RequestBody OrderLine orderLine) {
        return orderLineService.createOrderLine(orderLine);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderLine> updateOrderLine(@PathVariable Integer id, @RequestBody OrderLine orderLine) {
        return orderLineService.updateOrderLine(id, orderLine)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrderLine(@PathVariable Integer id) {
        boolean deleted = orderLineService.deleteOrderLine(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
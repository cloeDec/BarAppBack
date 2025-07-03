package com.foreach.barapp.barapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foreach.barapp.barapp.models.OrderLine;
import com.foreach.barapp.barapp.repository.OrderLineRepository;

@Service
public class OrderLineService {
    @Autowired
    private OrderLineRepository orderLineRepository;

    public List<OrderLine> getAllOrderLine() {
        return orderLineRepository.findAll();
    }

    public Optional<OrderLine> getOrderLineById(Integer id) {
        return orderLineRepository.findById(id);
    }

    public OrderLine createOrderLine(OrderLine orderLine) {
        return orderLineRepository.save(orderLine);
    }

    public Optional<OrderLine> updateOrderLine(Integer id, OrderLine orderDetails) {
        return orderLineRepository.findById(id).map(orderLine -> {
            orderLine.setQuantity(orderDetails.getQuantity());
            orderLine.setLine_cocktail_status(orderDetails.getLine_cocktail_status());
            orderLine.setPrice_size_id(orderDetails.getPrice_size_id());
            orderLine.setOrder_id(orderDetails.getOrder_id());
            return orderLineRepository.save(orderLine);
        });
    }

    public boolean deleteOrderLine(Integer id) {
        if (orderLineRepository.existsById(id)) {
            orderLineRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
package com.foreach.barapp.barapp.services;

import java.util.List;

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
}
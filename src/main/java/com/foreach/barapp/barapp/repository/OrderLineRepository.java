package com.foreach.barapp.barapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foreach.barapp.barapp.models.OrderLine;

public interface OrderLineRepository extends JpaRepository<OrderLine, Integer> {
}

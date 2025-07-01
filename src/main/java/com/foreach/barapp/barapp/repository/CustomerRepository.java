package com.foreach.barapp.barapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foreach.barapp.barapp.models.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}

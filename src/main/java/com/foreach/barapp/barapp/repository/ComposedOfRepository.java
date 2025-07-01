package com.foreach.barapp.barapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foreach.barapp.barapp.models.ComposedOf;

public interface ComposedOfRepository extends JpaRepository<ComposedOf, Integer> {
}

package com.foreach.barapp.barapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foreach.barapp.barapp.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
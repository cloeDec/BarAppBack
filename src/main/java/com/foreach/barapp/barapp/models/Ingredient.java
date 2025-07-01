package com.foreach.barapp.barapp.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ingredient")
public class Ingredient {
    @Id
    @Column(name = "ingredient_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ingredient_id;
    private String ingredient_name;
}
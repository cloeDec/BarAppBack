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
@Table(name = "cocktail_size_price")
public class CocktailPrice {
    @Id
    @Column(name = "price_size_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer price_size_id;
    private String size;
    private String price;
    private Integer cocktail_id;
}
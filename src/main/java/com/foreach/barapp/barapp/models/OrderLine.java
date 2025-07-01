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
@Table(name = "order_line")
public class OrderLine {
    @Id
    @Column(name = "order_line_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer order_line_id;
    private String quantity;
    private String line_cocktail_status;
    private String price_size_id;
    private String order_id;
}
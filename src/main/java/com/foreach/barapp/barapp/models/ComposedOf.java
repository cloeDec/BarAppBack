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
@Table(name = "composed_of")
public class ComposedOf {
    @Id
    @Column(name = "composed_of", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer composed_of;
    private Integer cocktail_id;
    private String ingredient_id;
    private String quantity;
}
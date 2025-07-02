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
@Table(name = "cocktail")
public class Cocktail {
    @Id
    @Column(name = "cocktail_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cocktail_id;
    private String cocktail_name;
    private String description;
    private String image_url;
}




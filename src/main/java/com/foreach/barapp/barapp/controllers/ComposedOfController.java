package com.foreach.barapp.barapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foreach.barapp.barapp.models.ComposedOf;
import com.foreach.barapp.barapp.services.ComposedOfService;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/composedof")
public class ComposedOfController {
    @Autowired
    private ComposedOfService composedOfService;

    @GetMapping
    public List<ComposedOf> getComposedOf() {
        return composedOfService.getAllComposedOf();
    }
}
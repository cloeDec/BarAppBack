package com.foreach.barapp.barapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @GetMapping("/{id}")
    public ResponseEntity<ComposedOf> getComposedOfById(@PathVariable Integer id) {
        return composedOfService.getComposedOfById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ComposedOf createComposedOf(@RequestBody ComposedOf composedOf) {
        return composedOfService.createComposedOf(composedOf);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ComposedOf> updateComposedOf(@PathVariable Integer id, @RequestBody ComposedOf composedOf) {
        return composedOfService.updateComposedOf(id, composedOf)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComposedOf(@PathVariable Integer id) {
        boolean deleted = composedOfService.deleteComposedOf(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
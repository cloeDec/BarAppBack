package com.foreach.barapp.barapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foreach.barapp.barapp.models.ComposedOf;
import com.foreach.barapp.barapp.repository.ComposedOfRepository;

@Service
public class ComposedOfService {
    @Autowired
    private ComposedOfRepository composedOfRepository;

    public List<ComposedOf> getAllComposedOf() {
        return composedOfRepository.findAll();
    }
}
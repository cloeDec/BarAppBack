package com.foreach.barapp.barapp.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.foreach.barapp.barapp.models.Customer;
import com.foreach.barapp.barapp.repository.CustomerRepository;
import com.foreach.barapp.barapp.security.JwtUtil;

@RestController
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> user) {
        System.out.println("Tentative de login reçue !");
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            user.get("email"),
                            user.get("password")
                    )
            );
            Customer customer = customerRepository.findByEmail(user.get("email"));
            String role = customer.getRole();
            String token = jwtUtil.generateToken(user.get("email"), role);
            Map<String, String> response = new HashMap<>();
            response.put("token", token);
            return response;
        } catch (AuthenticationException e) {
            throw new RuntimeException("Identifiants invalides");
        }
    }
}

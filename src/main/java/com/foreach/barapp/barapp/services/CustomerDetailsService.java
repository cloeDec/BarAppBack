package com.foreach.barapp.barapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.foreach.barapp.barapp.models.Customer;
import com.foreach.barapp.barapp.repository.CustomerRepository;

@Service
public class CustomerDetailsService implements UserDetailsService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        System.out.println("Tentative de connexion avec l'email : " + email);

        Customer customer = customerRepository.findByEmail(email);
        if (customer == null) {
            throw new UsernameNotFoundException("Utilisateur non trouvé avec l'email : " + email);
        }
        String role = customer.getRole();
        List<SimpleGrantedAuthority> authorities = List.of(new SimpleGrantedAuthority("ROLE_" + role));
        return new User(
            customer.getEmail(),
            customer.getPassword(),
            authorities
        );
    }
}

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
@Table(name = "Customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Customer_ID")
    private Long customerId;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "First_Name", nullable = false)
    private String firstName;

    @Column(name = "Role", nullable = false)
    private String role;

    @Column(name = "Email", nullable = false, unique = true)
    private String email;

    @Column(name = "Password", nullable = false)
    private String password;

    public Long getId() { return customerId; }
    public void setId(Long id) { this.customerId = id; }

    public String getUsername() { return email; }
    public void setUsername(String username) { this.email = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}

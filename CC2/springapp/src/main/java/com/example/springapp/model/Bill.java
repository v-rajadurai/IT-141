package com.example.springapp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Bill {
    @Id
    private int billNo;

    @JsonBackReference(value = "product-bill")
    @ManyToOne
    private Product product;
    
    @JsonBackReference(value = "customer-bill")
    @ManyToOne
    private Customer customer;


    

    
}

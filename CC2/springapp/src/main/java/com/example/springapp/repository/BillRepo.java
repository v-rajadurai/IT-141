package com.example.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springapp.model.Bill;

public interface BillRepo extends JpaRepository<Bill,Integer>{

    
} 

package com.example.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springapp.model.Bill;
import com.example.springapp.repository.BillRepo;

@Service
public class BillService {
    @Autowired
    private BillRepo billRepo;

    public Bill saveBill(Bill bill)
    {
        return billRepo.save(bill);
    }

    public List<Bill> getBills()
    {
        return billRepo.findAll();
    }
}

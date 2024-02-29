package com.example.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapp.model.Bill;
import com.example.springapp.service.BillService;

@RestController
public class BillController {
    @Autowired
    private BillService billService;
    
    @PostMapping("/bill")
    public Bill postBill(@RequestBody Bill bill)
    {
        return billService.saveBill(bill);
    }

    @GetMapping("/bills")
    public List<Bill> listBils()
    {
        return billService.getBills();
    }
}

package com.example.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import com.example.springapp.model.Product;
import com.example.springapp.repository.ProductRepo;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;

    public Product saveProduct(Product product)
    {
        return productRepo.save(product);
    }
    public List<Product> getProducts()
    {
        return productRepo.findAll();
    }

    

    public List<Product> productPaginateion(int offset,int pagesize)
    {
        return productRepo.findAll(PageRequest.of(offset, pagesize)).getContent();
    }
    public List<Product> productPaginateionList(String field)
    {
        return productRepo.findAll(Sort.by(field));
    }
    public List<Product> productPaginateionSort(int offset,int pagesize,String field)
    {
        PageRequest pageRequest=PageRequest.of(offset,pagesize,Sort.by(Sort.Direction.ASC,field));
        Page<Product> p=productRepo.findAll(pageRequest);
        return p.getContent();
    }
    
}

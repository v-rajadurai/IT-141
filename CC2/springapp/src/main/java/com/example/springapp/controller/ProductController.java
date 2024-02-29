package com.example.springapp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapp.model.Product;
import com.example.springapp.service.ProductService;

@RestController
public class ProductController {
    
    @Autowired
    private ProductService productService;

    @PostMapping("/product")

    public Product postProduct(@RequestBody Product product)
    {
        return productService.saveProduct(product);
    }



    @GetMapping("/products")
    public List<Product> listProducts()
    {
        return productService.getProducts();
    }





    @GetMapping("/api/product/sortBy/{field}")
    public ResponseEntity<List<Product>> sortProduct(@PathVariable("field") String field)
    {
        List<Product> a=productService.productPaginateionList(field);
        if(a!=null)
        {

            return new ResponseEntity<List<Product>>(a,HttpStatus.OK);
        }
        return new ResponseEntity<>(a,HttpStatus.NOT_FOUND);
    }
    @GetMapping("/api/product/{offset}/{pagesize}")
    public ResponseEntity<List<Product>> sortProduct(@PathVariable int offset,@PathVariable int pagesize)
    {
        List<Product> b=productService.productPaginateion(offset,pagesize);
        if(b!=null)
        {
            return new ResponseEntity<List<Product>>(b,HttpStatus.OK);
            
        }
        return new ResponseEntity<>(b,HttpStatus.NOT_FOUND);
    }
    @GetMapping("/api/product/{offset}/{pagesize}/{field}")
    public ResponseEntity<List<Product>> sortproduct(@PathVariable int offset,@PathVariable int pagesize,@PathVariable String field)
    {
        List<Product> c=productService.productPaginateionSort(offset,pagesize,field);
        if(c!=null)
        {

            return new ResponseEntity<List<Product>>(c,HttpStatus.OK);
        }
        return new ResponseEntity<>(c,HttpStatus.NOT_FOUND);
    }
}

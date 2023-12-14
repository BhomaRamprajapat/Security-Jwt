package com.jwt.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jwt.demo.entity.Product;
import com.jwt.demo.repository.ProductRepository;

@Service
public class ProductService 
{
 @Autowired
 private ProductRepository productRepository;
 
 public Product	addProduct(Product product)
 {
  return productRepository.save(product);
 }
 
 public List<Product> getProducts()
 {
  return productRepository.findAll();
 }
}

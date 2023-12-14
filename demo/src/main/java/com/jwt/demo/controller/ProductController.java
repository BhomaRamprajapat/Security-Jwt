package com.jwt.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.demo.dto.JwtRequest;
import com.jwt.demo.entity.Product;
import com.jwt.demo.service.JwtService;
import com.jwt.demo.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController 
{
 @Autowired
 private ProductService productService;
 
 @Autowired
 private AuthenticationManager authenticationManager;
 
 @Autowired
 private JwtService jwtService;
	
 @PostMapping("/add")
 public ResponseEntity<Product> addProduct(@RequestBody Product product)
 {
  product=productService.addProduct(product);
  
  return ResponseEntity.ok().body(product);
 }
 
 @PostMapping("/authenticate")
 public String authenticate(@RequestBody JwtRequest jwtRequest)
 {
  Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));
  
  if(authentication.isAuthenticated())
   return jwtService.generateToken(jwtRequest.getUsername());
  
  throw new UsernameNotFoundException("invalid user");
 }
}

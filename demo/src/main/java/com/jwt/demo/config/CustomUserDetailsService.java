package com.jwt.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.jwt.demo.entity.User;
import com.jwt.demo.repository.UserRepository;

@Component
public class CustomUserDetailsService implements UserDetailsService 
{
 @Autowired
 UserRepository userRepository;
	
 public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
 {
  User user=userRepository.findByName(username).orElseThrow(()->new UsernameNotFoundException("user not found!"));
  
  return new CustomUserDetails(user);
 } 
}

package com.jwt.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.jwt.demo.entity.User;
import com.jwt.demo.repository.UserRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner 
{
    @Autowired
	private UserRepository userRepository;
    
    @Autowired
    PasswordEncoder encoder;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception 
	{
	 User user=new User();
	 user.setEmail("Bhoma@gmail.com");
	 user.setName("Bhoma");
	 user.setPassword(encoder.encode("123"));
	 user.setRole("ADMIN");
	 
	 user=userRepository.save(user);
	}

}

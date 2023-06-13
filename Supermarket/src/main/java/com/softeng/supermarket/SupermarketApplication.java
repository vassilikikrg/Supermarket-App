package com.softeng.supermarket;

import com.softeng.supermarket.models.User;
import com.softeng.supermarket.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.softeng.supermarket.controllers")
@ComponentScan("com.softeng.supermarket.models")
@ComponentScan("com.softeng")
public class SupermarketApplication implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(SupermarketApplication.class, args);
    }

    @Override
    public void run(String... args){
        User user1 = new User("Antonis","test1234","test@tester.com","6971989277","Antonios","Fritzelas",false);
        userRepository.save(user1);
        userRepository.findByUsername("Antonis").forEach(
                val -> System.out.println(val)
        );
    }
}

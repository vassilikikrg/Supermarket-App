package com.softeng.supermarket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@ComponentScan("com.softeng.supermarket.controllers")
@ComponentScan("com.softeng.supermarket.models")
@ComponentScan("com.softeng")
public class SupermarketApplication {

//    @Autowired
//    UserRepository userRepository;

    public static void main(String[] args) {

        SpringApplication.run(SupermarketApplication.class, args);
    }
        @Bean
            public BCryptPasswordEncoder bCryptPasswordEncoder(){
                return new BCryptPasswordEncoder();
        }
    // implements CommandLineRunner

//    @Override
//    public void run(String... args){
//        User user1 = new User("Antonis","test1234","test@tester.com","6971989277","Antonios","Fritzelas",false);
//        userRepository.save(user1);
//        userRepository.findByUsername("Antonis").forEach(
//                val -> System.out.println(val)
//        );
//    }
}

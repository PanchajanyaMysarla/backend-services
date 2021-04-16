package com.example.mespringjpa;

import com.example.mespringjpa.entity.Customer;
import com.example.mespringjpa.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class MeSpringJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(MeSpringJpaApplication.class, args);
    }


    @Bean
    public CommandLineRunner demo(CustomerRepository repository){
        return args -> {

            repository.save(new Customer("Jack","Bauer"));
            repository.save(new Customer("Jack2","Bauer2"));
            repository.save(new Customer("Jack3","Bauer3"));


            System.out.println("Customers");

            repository.findAll().forEach(c -> System.out.println("Customer :"+c.toString()));

            System.out.println("find byid :"+repository.findById(1L));

            List<Customer> l =  repository.findByFirstName("Jack");
            System.out.println(l+"findByFirstName");

            List<Customer> ll =  repository.findByLastName("Bauer2");
            System.out.println(ll+"findByLastName");

        };
    }

}

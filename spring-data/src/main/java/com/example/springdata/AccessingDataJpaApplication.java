package com.example.springdata;

import com.example.springdata.Customer;
import com.example.springdata.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.OffsetDateTime;
import java.time.temporal.TemporalUnit;

@SpringBootApplication
public class AccessingDataJpaApplication {

    private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AccessingDataJpaApplication.class);
    }

    @Bean
    public CommandLineRunner demo(CustomerRepository repository) {
        return (args) -> {
            // save a few customers
            repository.save(new Customer("Jack", OffsetDateTime.now(),OffsetDateTime.now()));
            repository.save(new Customer("Chloe",OffsetDateTime.parse("2019-08-31T15:20:30+08:00"),OffsetDateTime.parse("2099-08-31T15:20:30+08:00")));
            repository.save(new Customer("Kim",OffsetDateTime.now(),OffsetDateTime.parse("2099-08-31T15:20:30+08:00")));
            repository.save(new Customer("Dragun",OffsetDateTime.parse("2021-08-31T15:20:30+08:00"),OffsetDateTime.parse("2099-08-31T15:20:30+08:00")));
            repository.save(new Customer("Breez",OffsetDateTime.parse("2020-08-31T15:20:30+08:00"),OffsetDateTime.parse("2020-08-31T15:20:30+08:00")));
            repository.save(new Customer("Kimy",OffsetDateTime.now().plusDays(2),OffsetDateTime.parse("2021-04-28T15:20:30+08:00")));


            // fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (Customer customer : repository.findAll()) {
                log.info(customer.toString());
            }
            log.info("");

            // fetch an individual customer by ID
            Customer customer = repository.findById(1L);
            log.info("Customer found with findById(1L):");
            log.info("--------------------------------");
            log.info(customer.toString());
            log.info("");

            // fetch customers by last name
            log.info("Customer found with findByLastName('Bauer'):");
            log.info("--------------------------------------------");
            repository.findByName("Jack").forEach(bauer -> {
                log.info(bauer.toString());
            });
            // for (Customer bauer : repository.findByLastName("Bauer")) {
            //  log.info(bauer.toString());
            // }
            log.info("");
        };
    }

}
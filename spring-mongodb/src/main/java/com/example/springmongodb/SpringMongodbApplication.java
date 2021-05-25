package com.example.springmongodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = UserRepository.class)
public class SpringMongodbApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMongodbApplication.class, args);
    }

}

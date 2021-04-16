package com.example.mespringjpa.repository;

import com.example.mespringjpa.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository  extends JpaRepository<Customer,Long> {

    List<Customer> findByLastName(String lastName);
    List<Customer> findByFirstName(String firstName);

}

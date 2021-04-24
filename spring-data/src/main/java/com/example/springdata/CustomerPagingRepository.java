package com.example.springdata;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerPagingRepository extends PagingAndSortingRepository<Customer,Integer> {
}

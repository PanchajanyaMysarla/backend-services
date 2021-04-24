package com.example.springdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping(value = "/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerPagingRepository customerPagingRepository;

    @GetMapping
    public List<Customer> getCustomers(){
       return customerService.getAllCustomers();
    }

    @PostMapping
    public void populateAllCustomersData() {
        customerService.populateCustomerData();
    }

    @GetMapping(path = "/{id}")
    public Customer getCustomerById(@PathVariable Integer id) {
        return customerRepository.findById(id);
    }


    @GetMapping(path = "paging")
    public Page<Customer> getPaginatedCustomers(@RequestParam(defaultValue = "0") Integer page,
                                                @RequestParam(defaultValue = "10") Integer size,
                                                @RequestParam(defaultValue = "name") String sortField,
                                                @RequestParam(defaultValue = "asc") String sortDirection){

        PageRequest pageRequest = PageRequest.of(
                page,
                size,
                sortDirection.equalsIgnoreCase("asc") ? Sort.by(sortField).ascending() : Sort.by(sortField).descending()
        );


       return customerPagingRepository.findAll(pageRequest);

    }
}

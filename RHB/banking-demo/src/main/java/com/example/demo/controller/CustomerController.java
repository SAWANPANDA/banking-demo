package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.model.Account;
import com.example.demo.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // CREATE CUSTOMER
    @PostMapping
    public Customer create(@RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }

    // GET ALL CUSTOMERS WITH PAGINATION
    @GetMapping
    public Page<Customer> list(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);
        return customerService.getAllCustomers(pageable);
    }

    // SEARCH CUSTOMERS WITH PAGINATION
    @GetMapping("/search")
    public Page<Customer> search(
            @RequestParam String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);
        return customerService.searchCustomers(name, pageable);
    }

    // GET ACCOUNTS BY CUSTOMER NAME (JOIN QUERY)
    @GetMapping("/accounts/by-name")
    public List<Account> accountsByCustomer(@RequestParam String name) {
        return customerService.getAccountsByCustomerName(name);
    }

    // UPDATE CUSTOMER
    @PutMapping("/{id}")
    public Customer update(@PathVariable Long id, @RequestBody Customer updatedCustomer) {
        return customerService.updateCustomer(id, updatedCustomer);
    }

    // DELETE CUSTOMER
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }

    // EXTERNAL API CALL
    @GetMapping("/ping-google")
    public String pingGoogle() {
        return customerService.pingGoogle();
    }
}

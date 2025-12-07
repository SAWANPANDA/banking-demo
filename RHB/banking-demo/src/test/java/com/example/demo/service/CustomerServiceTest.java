package com.example.demo.service;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
public class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    @Test
    void testCreateCustomer() {

        // Arrange - create customer object
        Customer customer = new Customer();
        customer.setName("John");
        customer.setEmail("john@gmail.com");

        // Mock the repository save method
        Mockito.when(customerRepository.save(any(Customer.class)))
                .thenReturn(customer);

        // Act - call the service
        Customer saved = customerService.createCustomer(customer);

        // Assert - verify saved data
        assertEquals("John", saved.getName());
        assertEquals("john@gmail.com", saved.getEmail());
    }
}

package com.example.demo.service;

import com.example.demo.model.Account;
import com.example.demo.model.Customer;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
public class AccountServiceTest {

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private AccountService accountService;

    @Test
    void testCreateAccount() {

        // Mock Customer
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setName("John");
        customer.setEmail("john@gmail.com");

        // Mock Account
        Account account = new Account();
        account.setAccountType("SAVINGS");
        account.setBalance(new BigDecimal("5000"));

        // When repository findById is called
        Mockito.when(customerRepository.findById(1L))
                .thenReturn(Optional.of(customer));

        // When saving account
        Mockito.when(accountRepository.save(any(Account.class)))
                .thenAnswer(invocation -> {
                    Account acc = invocation.getArgument(0);
                    acc.setId(1L); // simulate DB generated ID
                    return acc;
                });

        // Call service method
        Account saved = accountService.createAccount(1L, account);

        // Assertions
        assertNotNull(saved.getId());
        assertEquals("SAVINGS", saved.getAccountType());
        assertEquals(new BigDecimal("5000"), saved.getBalance());
        assertEquals(customer, saved.getCustomer());
    }
}

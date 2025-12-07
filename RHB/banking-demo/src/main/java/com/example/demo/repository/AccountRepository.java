package com.example.demo.repository;

import com.example.demo.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {

    // JOIN query between Account and Customer using customer name
    @Query("SELECT a FROM Account a JOIN a.customer c WHERE c.name = :customerName")
    List<Account> findAccountsByCustomerName(@Param("customerName") String customerName);
}

package com.example.demo.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Customer {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 
	 private String name;
	 private String email;
	 
	 @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
	 
	 private List<Account> accounts;
	 
	 public Customer() {}

	    public Customer(String name, String email) {
	        this.name = name;
	        this.email = email;
	    }

	    // Getters & Setters
	    public Long getId() { return id; }
	    public void setId(Long id) { this.id = id; }

	    public String getName() { return name; }
	    public void setName(String name) { this.name = name; }

	    public String getEmail() { return email; }
	    public void setEmail(String email) { this.email = email; }

	    public List<Account> getAccounts() { return accounts; }
	    public void setAccounts(List<Account> accounts) { this.accounts = accounts; }
	}
	 

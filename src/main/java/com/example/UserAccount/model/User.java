package com.example.UserAccount.model;

import jakarta.persistence.*;
import org.springframework.aop.target.LazyInitTargetSource;

import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Account> accounts;
}

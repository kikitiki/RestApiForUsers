package com.example.UserAccount.repository;

import com.example.UserAccount.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepo extends JpaRepository<Account,Long> {

    List<Account> findByUserId(Long userId);
}

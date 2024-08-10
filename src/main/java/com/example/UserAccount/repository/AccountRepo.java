package com.example.UserAccount.repository;

import com.example.UserAccount.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepo extends JpaRepository<Account,Long> {
}

package com.example.UserAccount.repository;

import com.example.UserAccount.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AccountRepo extends JpaRepository<Account,Long> {
    List<Account> findByUserId(Long userId);
}

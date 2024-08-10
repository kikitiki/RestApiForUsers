package com.example.UserAccount.repository;

import com.example.UserAccount.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}

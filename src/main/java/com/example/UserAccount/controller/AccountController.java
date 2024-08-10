package com.example.UserAccount.controller;

import com.example.UserAccount.dto.AccountDto;
import com.example.UserAccount.service.AccountService;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    public AccountService accountService;

    @PostMapping("/createAccount/{userId}")
    public ResponseEntity<AccountDto> createAccount(@PathVariable Long userId, @RequestBody AccountDto accountDto){
        AccountDto createAccount = accountService.createAccount(userId,accountDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createAccount);
    }
}

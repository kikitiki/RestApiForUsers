package com.example.UserAccount.controller;

import com.example.UserAccount.dto.AccountDto;
import com.example.UserAccount.service.AccountService;
import jakarta.persistence.Access;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/user/{id}")
    public ResponseEntity<List<AccountDto>> getAccountByUserId(@PathVariable Long id){
        List<AccountDto> accountDtos = accountService.getAccountByUserId(id);
        if (accountDtos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok( accountDtos);
    }
}

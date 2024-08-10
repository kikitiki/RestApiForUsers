package com.example.UserAccount.service;

import com.example.UserAccount.dto.AccountDto;
import com.example.UserAccount.model.Account;
import com.example.UserAccount.model.User;
import com.example.UserAccount.repository.AccountRepo;
import com.example.UserAccount.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    public AccountRepo accountRepo;
    @Autowired
    public UserRepo userRepo;

    public AccountDto createAccount(Long userId,AccountDto accountDto){
        User user = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found!"));

        Account account = new Account();
        account.setAccountNumber(accountDto.getAccountNumber());
        account.setBalance(accountDto.getBalance());
        account.setUser(user);

        account = accountRepo.save(account);

        return new AccountDto(account.getId(),account.getAccountNumber(),account.getBalance());
    }
}

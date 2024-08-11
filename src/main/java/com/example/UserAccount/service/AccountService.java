package com.example.UserAccount.service;

import com.example.UserAccount.dto.AccountDto;
import com.example.UserAccount.dto.UserDto;
import com.example.UserAccount.model.Account;
import com.example.UserAccount.model.User;
import com.example.UserAccount.repository.AccountRepo;
import com.example.UserAccount.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

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


    public List<AccountDto> getAccountByUserId(Long userId){
        List<Account> accounts = accountRepo.findByUserId(userId);

        List<AccountDto> accountDtos = new ArrayList<>();
        for (Account account : accounts){
            AccountDto accountDto = new AccountDto();
            accountDto.setId(account.getId());
            accountDto.setAccountNumber(account.getAccountNumber());
            accountDto.setBalance(account.getBalance());
            accountDtos.add(accountDto);
        }
        return accountDtos;
    }
}

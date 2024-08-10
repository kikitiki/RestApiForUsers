package com.example.UserAccount.service;

import com.example.UserAccount.dto.UserDto;
import com.example.UserAccount.model.User;
import com.example.UserAccount.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public UserDto createUser(UserDto userDto){
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        userRepo.save(user);
        return userDto;
    }

    public void  deleteUserById(Long id){
        userRepo.deleteById(id);
    }
}

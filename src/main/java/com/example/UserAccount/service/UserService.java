package com.example.UserAccount.service;

import com.example.UserAccount.dto.UserDto;
import com.example.UserAccount.model.User;
import com.example.UserAccount.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public UserDto updateUser(UserDto userDto,Long id){
        Optional<User> user = userRepo.findById(id);
        User updatedUser = user.get();
        updatedUser.setFirstName(userDto.getFirstName());
        updatedUser.setLastName(userDto.getLastName());
        updatedUser.setEmail(userDto.getEmail());
        userRepo.save(updatedUser);
        return userDto;
    }

    public void  deleteUserById(Long id){
        userRepo.deleteById(id);
    }
}

package com.example.UserAccount.controller;

import com.example.UserAccount.dto.UserDto;
import com.example.UserAccount.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public UserDto createUser(@RequestBody UserDto userDto){
        return userService.createUser(userDto);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserDto> updatedUser(@PathVariable Long id, @RequestBody UserDto userDto){
        return ResponseEntity.ok(userService.updateUser(userDto,id));
    }

    @GetMapping("/getUserById/{id}")
    public ResponseEntity<Optional<UserDto>> getUserById(@PathVariable Long id){
        Optional<UserDto> userDto =  userService.getUserById(id);

        return ResponseEntity.ok(userDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        userService.deleteUserById(id);
        return ResponseEntity.ok("Successfully deleted user");
    }
}

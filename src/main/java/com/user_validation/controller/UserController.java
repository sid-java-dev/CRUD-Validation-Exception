package com.user_validation.controller;

import com.user_validation.entity.User;
import com.user_validation.payLoad.UserRequest;
import com.user_validation.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping
    public ResponseEntity<User>createUser(@Valid @RequestBody UserRequest userRequest){
        return new ResponseEntity<>(userService.createUser(userRequest), HttpStatus.CREATED);
    }
    @GetMapping("/{}id")
    public ResponseEntity<User>getUserById(@PathVariable long id){
        return  new ResponseEntity<>(userService.getUserById(id),HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<User>>getAllUser(){
        return new ResponseEntity<>(userService.getAllUser(),HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<User>updateUser(@PathVariable long id,@RequestBody UserRequest userRequest){
        return new ResponseEntity<>(userService.updateUser(id,userRequest),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void>deleteUser(@PathVariable long id){
        userService.deleteUser(id);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}

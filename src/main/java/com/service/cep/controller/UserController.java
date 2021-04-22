package com.service.cep.controller;

import com.service.cep.dto.UserDto;
import com.service.cep.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService service;

    @Autowired
    public UserController(UserService service){
        this.service = service;
    }

    @PostMapping("/create-account")
    public UserDto createAccount(@RequestBody final UserDto user) {
       return service.addUser(user);
    }
}

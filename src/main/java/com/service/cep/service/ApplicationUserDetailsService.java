package com.service.cep.service;

import com.service.cep.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;

@Service
public class ApplicationUserDetailsService implements IUserDetailService {

    private final UserService userService;

    @Autowired
    public ApplicationUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDto applicationUser = userService.findByUsername(username).orElse(null);
        if (applicationUser == null) {
            throw new UsernameNotFoundException(username);
        }
        return new org.springframework.security.core.userdetails.User(applicationUser.getUsername(), applicationUser.getPassword(), emptyList());

    }
}
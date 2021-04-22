package com.service.cep.service;

import com.service.cep.converter.UserConverter;
import com.service.cep.dto.UserDto;
import com.service.cep.entity.UserEntity;
import com.service.cep.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final PasswordEncoder passwordEncoder;

    private final UserRepository repository;

    private final UserConverter converter;

    @Autowired
    public UserService(
            UserConverter converter,
            PasswordEncoder passwordEncoder,
            UserRepository repository){
        this.converter = converter;
        this.passwordEncoder = passwordEncoder;
        this.repository = repository;
    }

    public UserDto addUser(UserDto user){
        UserEntity entity = converter.fromDto(user);
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        user = converter.fromEntity(repository.save(entity));
        return user;
    }

    public Optional<UserDto> findByUsername(String username) {
        Optional<UserEntity> user = repository.findByUsername(username);
        if(user.isPresent()){
            return Optional.of(converter.fromEntity(user.get()));
        }else{
            return Optional.empty();
        }
    }

}

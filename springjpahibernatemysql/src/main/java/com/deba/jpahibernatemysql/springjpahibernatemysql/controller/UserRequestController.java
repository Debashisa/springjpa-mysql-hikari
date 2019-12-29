package com.deba.jpahibernatemysql.springjpahibernatemysql.controller;

import com.deba.jpahibernatemysql.springjpahibernatemysql.entity.User;
import com.deba.jpahibernatemysql.springjpahibernatemysql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
public class UserRequestController {

    @Autowired
    UserRepository userRepo;

    @PostMapping(value = "/user")
    public ResponseEntity<User> createRecord(@RequestBody User userRecord){

        User savedUser=userRepo.save(userRecord);

        Optional<User> optionalUser=Optional.ofNullable(savedUser);

        if(optionalUser.isPresent()){
            URI uri= ServletUriComponentsBuilder.fromCurrentRequestUri().path("/user").buildAndExpand(optionalUser.get().getId()).toUri();
            return ResponseEntity.created(uri).body(savedUser);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
}

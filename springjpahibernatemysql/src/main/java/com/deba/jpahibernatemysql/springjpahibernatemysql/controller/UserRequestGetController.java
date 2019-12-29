package com.deba.jpahibernatemysql.springjpahibernatemysql.controller;


import com.deba.jpahibernatemysql.springjpahibernatemysql.entity.User;
import com.deba.jpahibernatemysql.springjpahibernatemysql.exception.ResourceNotFound;
import com.deba.jpahibernatemysql.springjpahibernatemysql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@RestController
public class UserRequestGetController {

    @Autowired
    UserRepository userRepo;
    @Autowired
    DataSource dataSource;

    @GetMapping(value = "/user/{id}")
    public ResponseEntity<Optional<User>> getUserDetails(@PathVariable("id") long id) throws ResourceNotFound
    {
        User returnedUser=userRepo.findUserByID(id);

        Optional<User> optionalUser=Optional.ofNullable(returnedUser);

        if(optionalUser.isPresent())
        {
            return ResponseEntity.ok(optionalUser);
        }
        else
        return ResponseEntity.notFound().build();


    }

    @GetMapping(value = "/user")
    public List<User> listUsers()throws ResourceNotFound{

        System.out.println("Data source :: "+ dataSource);
        List<User> userList=userRepo.findAll();


        return userList;
    }
}

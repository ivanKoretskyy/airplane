package com.example.airplane.controller;

import com.example.airplane.model.User;
import com.example.airplane.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping("")
    public List<User> list() {
        return userService.listAllUser();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> get(@PathVariable Integer id) {
        try{
            User existingUser = userService.getUser(id);
            return new ResponseEntity<User>(existingUser, HttpStatus.OK);
        }catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public void add(@RequestBody User user){

        userService.saveUser(user);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<User> update(@RequestBody User user, @PathVariable Integer id) {
//        try {
//            User existUser = userService.getUser(id);
//            userService.saveUser(user);
//            return new ResponseEntity<>(HttpStatus.OK);
//        }catch(NoSuchElementException e) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        userService.deleteUser(id);
    }

}

package com.academy.levelupsales.controllers;

import com.academy.levelupsales.entities.User;
import com.academy.levelupsales.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "https//localhost:4200/")
public class UserController {

    @Autowired
    public UserService userService;

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user){
        return new ResponseEntity<>(userService.save(user), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id){
        User foundUser = userService.getUser(id);
        if (foundUser == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(foundUser, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Long id){
        User updateUser = userService.updateById(user, id);
        return updateUser == null
                ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(updateUser,HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> delete(@PathVariable Long id){
        User deleteUser = userService.deleteById(id);
        return deleteUser == null
                ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(deleteUser, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
    }
}

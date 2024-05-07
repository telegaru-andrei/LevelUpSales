package com.academy.levelupsales.services;

import com.academy.levelupsales.entities.User;
import com.academy.levelupsales.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User save(User user){
        return userRepository.save(user);
    }

    public User getUser(Long id){
        Optional<User> foundUser = userRepository.findById(id);
        return foundUser.orElse(null);
    }

    public User updateById(User user, Long id){
        Optional<User> foundUser = userRepository.findById(id);
        if (foundUser.isEmpty()){
            return null;
        }
        User validObject = foundUser.get();
        validObject.setFirstName(user.getFirstName());
        validObject.setLastName(user.getLastName());
        validObject.setAge(user.getAge());
        validObject.setEmail(user.getEmail());
        validObject.setPassword(user.getPassword());
        return userRepository.save(validObject);
    }

    public User deleteById(Long id){
        Optional<User> foudnUser = userRepository.findById(id);
        if (foudnUser.isEmpty()){
            return null;
        }
        userRepository.deleteById(id);
        return foudnUser.get();
    }

    public List<User> getAllUser(){
        return userRepository.findAll();
    }
}

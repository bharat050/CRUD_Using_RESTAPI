package com.example.RestApiController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Component
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void addUser(User u){
        userRepository.addUser(u);
    }
    public ArrayList<User> getUser(){

        return userRepository.getUser();
    }
    public void updateUser(int id, User u){
        userRepository.updateUser(id, u);
    }
    public void deleteUser(int id){
        userRepository.deleteUser(id);
    }
}

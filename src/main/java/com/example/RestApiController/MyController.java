package com.example.RestApiController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class MyController {

    HashMap<Integer, User> currUsers = new HashMap<>();

    @GetMapping("/getUser")
    public List<User> getUser(){
        List<User> listOfUser = new ArrayList<>();
        for(User i: currUsers.values()){
            listOfUser.add(i);
        }
        return listOfUser;
    }
    @PostMapping("/addUser")
    public void addUser(@RequestParam("id") int id, @RequestParam("name") String name,
                        @RequestParam("age") int age, @RequestParam("country") String country){

        User u1 = new User(id, name, age, country);
        currUsers.put(id, u1);
    }

    @PutMapping("/updateUser")
    public void updateUser(@RequestParam("id") int id, @RequestParam("name") String name,
                           @RequestParam("age") int age, @RequestParam("country") String country){

//        String newName = name;
//        int newAge = age;
//        String newCountry = country;
        User updateUser = currUsers.get(id);
        updateUser.setName(name);
        updateUser.setAge(age);
        updateUser.setCountry(country);
        currUsers.put(id, updateUser);
    }

    @DeleteMapping("/deleteUser")
    public void deleteUser(@RequestParam("id") int id){
        currUsers.remove(id);
    }
}

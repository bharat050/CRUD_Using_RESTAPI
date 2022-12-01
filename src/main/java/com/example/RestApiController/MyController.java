package com.example.RestApiController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {

    @Autowired
    UserService userService;

    @GetMapping("/getUser")
    public ResponseEntity<List<User>> getUser(){
        List<User> u = userService.getUser();
        return new ResponseEntity(u, HttpStatus.FOUND);
    }

    /*@PostMapping("/addUser")
    public void addUser(@RequestParam("id") int id, @RequestParam("name") String name,
                        @RequestParam("age") int age, @RequestParam("country") String country){

        User u1 = new User(id, name, age, country);
        currUsers.put(id, u1);
    }*/

    @PostMapping("/addUser")
    public ResponseEntity<String> addUserBody(@RequestBody() User u){
        userService.addUser(u);
         return new ResponseEntity<>("User been Added", HttpStatus.CREATED);
    }

    @PutMapping("/updateUser")
    public ResponseEntity<String> updateUserBody(@RequestParam("id") int id, @RequestBody() User u){
        userService.updateUser(id, u);
        return new ResponseEntity<>("Updated",HttpStatus.ACCEPTED);
    }
    /*@PutMapping("/updateUser")
    public void updateUser(@RequestParam("id") int id, @RequestParam("name") String name,
                           @RequestParam("age") int age, @RequestParam("country") String country){

        String newName = name;
        int newAge = age;
        String newCountry = country;
        User updateUser = currUsers.get(id);
        updateUser.setName(name);
        updateUser.setAge(age);
        updateUser.setCountry(country);
        currUsers.put(id, updateUser);
    }
    */
    @DeleteMapping("/deleteUser")
    public ResponseEntity<String> deleteUser(@RequestParam("id") int id){
        userService.deleteUser(id);
        return new ResponseEntity<>("Deleted the User", HttpStatus.ACCEPTED);
    }
}

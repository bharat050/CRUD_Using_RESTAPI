package com.example.RestApiController;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;

@Component
@Repository
public class UserRepository {


    HashMap<Integer, User> users = new HashMap<>();

    public void addUser(User u){
        users.put(u.getId(), u);
    }

    public ArrayList<User> getUser(){
        return new ArrayList<>(users.values());
    }

    public void updateUser(int id,User u){
        users.put(id, u);
    }

    public void deleteUser(int id){
        users.remove(id);
    }
}

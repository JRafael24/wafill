package com.hachico.iwafill.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hachico.iwafill.Model.UserModel;


@RestController
public class UserController {
    
    //fetch one data
    //http:localhost:8080/user
    @GetMapping("/user")
    public UserModel getUser(){
        return new UserModel(1, "John Rafael", "rafael@gmail.com", "rafael101010");
    }

    //fetch mutiple data
    //http://localhost:8080/users
    @GetMapping("/users")
    public List<UserModel> getUsers(){
        List<UserModel> users = new ArrayList<>();
        users.add(new UserModel(1, "Paeng", "paeng@gmail.com", "paeng1212" ));
        users.add(new UserModel(2, "jarlloy", "jarlloy@gmail.com", "jarlloybakloy" ));
        users.add(new UserModel(3, "Consi", "consi@gmail.com", "badjao" ));
        return users;

    }

    //http://localhost:8080/user/lala
    @GetMapping("/user/{name}")
    public UserModel getUserFromName(@PathVariable("name")String name){
        return new UserModel(1, "lala", "lala@gmail.com", "lala1212");
    }
}

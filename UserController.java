package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
    private UserService userService;

    @GetMapping
    public List<User> getUsers() throws IOException {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) throws IOException {
        return userService.findById(id);
    }

    @PostMapping
    public void createUser(@RequestBody User user) throws IOException {
        userService.createUser(user);
    }
/*
    @PutMapping("/{id}")
    public void updateUser(@PathVariable int id, @RequestBody User user) throws IOException {
        user.setUserId(id); // Ensure the user ID is set
        userService.updateUser(user);
    }*/

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) throws IOException {
        userService.deleteUser(id);
    }
    
}

package com.tohir153.travelEngine.Controller;

import com.tohir153.travelEngine.Services.UserService;
import com.tohir153.travelEngine.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    @Autowired
    private UserService userService;
    // Define the endpoint for user profile
    @GetMapping
    public List<Users> getAllUsers() {
        return userService.findAllUsers();
    }
}

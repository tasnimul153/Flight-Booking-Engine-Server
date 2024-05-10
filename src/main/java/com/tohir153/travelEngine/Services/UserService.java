package com.tohir153.travelEngine.Services;

import com.tohir153.travelEngine.Users;
import com.tohir153.travelEngine.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UsersRepository userRepository;

    public List<Users> findAllUsers() {
        return userRepository.findAll();
    }
}

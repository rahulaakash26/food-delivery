package com.redlizard.controllers;

import com.redlizard.exception.ResourceNotFoundException;
import com.redlizard.model.User;
import com.redlizard.model.UserProfile;
import com.redlizard.repositories.UserProfileRepository;
import com.redlizard.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserProfileController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserProfileRepository userProfileRepository;

    @PostMapping("/user/{userId}/user-profile")
    public UserProfile createUserProfile(@PathVariable(value = "userId") Long userId, @RequestBody UserProfile userProfile) {
        return userRepository.findById(userId).map(user -> {
            userProfile.setUser(user);
            return userProfileRepository.save(userProfile);
        }).orElseThrow(()->new ResourceNotFoundException());

    }
}

package com.redlizard.services;

import com.redlizard.model.User;

public interface UserService {
    User findUserByEmail(String email);
    User saveUser(User user);
}

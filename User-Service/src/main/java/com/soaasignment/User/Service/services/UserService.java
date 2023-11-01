package com.soaasignment.User.Service.services;

import com.soaasignment.User.Service.entities.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);

    List<User> getAllUser();

    User getUser(String userId);

    User getUserName(String userId);
}

package com.user_validation.service;

import com.user_validation.entity.User;
import com.user_validation.payLoad.UserRequest;

import java.util.List;

public interface UserService {
    User createUser(UserRequest userRequest);
    User getUserById(long id);
    List<User> getAllUser();
    User updateUser(long id,UserRequest userRequest);
    void deleteUser(long id);
}

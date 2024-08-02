package com.user_validation.service.impl;

import com.user_validation.entity.User;
import com.user_validation.exception.UserException;
import com.user_validation.exception.UserNotFoundException;
import com.user_validation.payLoad.UserRequest;
import com.user_validation.repository.UserRepository;
import com.user_validation.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User createUser(UserRequest userRequest) {
        Optional<User> optionalUser = findByEmail(userRequest.getEmail());
        if (!optionalUser.isEmpty()) {
            throw new UserException("User already exists");
        }
        User user = new User();
        user.setName(userRequest.getName());
        user.setEmail(userRequest.getEmail());
        user.setMobile(userRequest.getMobile());
        user.setAge(userRequest.getAge());
        user.setNationality(userRequest.getNationality());
        return userRepository.save(user);
    }

    @Override
    public User getUserById(long id) {
       return userRepository.findById(id).orElseThrow(
                ()->new UserNotFoundException("User not found with id: "+id)
        );
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(long id, UserRequest userRequest) {
        User user = getUserById(id);
        if(user!=null){
            user.setNationality(userRequest.getName());
            user.setEmail(userRequest.getEmail());
            user.setMobile(userRequest.getMobile());
            user.setAge(userRequest.getAge());
            user.setNationality(userRequest.getNationality());
            return userRepository.save(user);
        }
        return null;
    }

    @Override
    public void deleteUser(long id) {
        User user = getUserById(id);
        if(user!=null){
            userRepository.deleteById(id);
        }
    }

}

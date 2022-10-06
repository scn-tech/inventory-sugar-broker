package com.inventory.service;

import com.inventory.entity.User;
import com.inventory.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {

    @Autowired
    public UserRepository repository;

    public User authUser(User user) {
        return repository.findByUserNameAndPassword(user.getUserName(), user.getPassword());
    }

}

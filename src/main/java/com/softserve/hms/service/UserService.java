package com.softserve.hms.service;

import com.softserve.hms.domain.User;

import java.util.List;

public interface UserService {
    public void createUser(User user);
    public List<User> findAll();
    public List<User> findByFirstName(String firstName);
}

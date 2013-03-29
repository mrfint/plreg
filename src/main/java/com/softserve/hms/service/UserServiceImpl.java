/* Copyright Homeaway, Inc 2005-2013. All Rights Reserved.
 * No unauthorized use of this software.
 */
package com.softserve.hms.service;

import com.softserve.hms.domain.User;
import com.softserve.hms.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User service implementation
 *
 * @author aborovyk
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public void createUser(User user) {
        userDao.createUser(user);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public List<User> findByFirstName(String firstName) {
        return userDao.findUserByFName(firstName);
    }
}

/* Copyright Homeaway, Inc 2005-2013. All Rights Reserved.
 * No unauthorized use of this software.
 */
package com.softserve.hms.service;

import com.softserve.hms.domain.User;
import org.springframework.stereotype.Service;

/**
 * User service implementation
 *
 * @author aborovyk
 */
@Service
public class UserService {

    public User createUser(String login, String plainPassword) {
        User user = new User();
        user.setLogin(login);
        user.setPassword(plainPassword);
        return user;
    }

    public String getUser(String login) {
        return null;
    }
}

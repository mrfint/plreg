package com.softserve.hms.repository;

import com.softserve.hms.domain.User;
import java.util.List;

public interface UserDao {
    public List<User> findAll();
    public List<User> findUserByFName(String fName);
    public void createUser(User user);
}

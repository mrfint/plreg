package com.softserve.hms.repository;

import com.softserve.hms.domain.Person;
import com.softserve.hms.domain.User;

import java.util.List;

public interface UserDao {
    public String findFirsNameById(Integer id);
    public List<User> findAll();
    public List<User> findPersonByFName(String name);
}

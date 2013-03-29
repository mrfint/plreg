package com.softserve.hms.rest;

import com.softserve.hms.domain.User;
import com.softserve.hms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserRestController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/rest/user", method = RequestMethod.POST)
    @ResponseBody
    public void save(@RequestBody User user) {
        userService.createUser(user);
    }

    @RequestMapping(value="/rest/user", method = RequestMethod.GET, produces="application/json")
    @ResponseBody
    public List<User> findAll() {
        return userService.findAll();
    }

    @RequestMapping(value="/rest/user/{first-name}", method = RequestMethod.GET, produces="application/json")
    @ResponseBody
    public List<User> findByFirstName( @PathVariable("first-name") String firstName) {
        return userService.findByFirstName(firstName);
    }
}

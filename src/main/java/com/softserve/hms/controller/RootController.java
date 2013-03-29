package com.softserve.hms.controller;

import com.softserve.hms.domain.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
public class RootController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String root() {
        return "redirect:login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String homePage(Model model, Principal principal) {
        //User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("currentUser", principal.getName());
        return "home";
    }

    @RequestMapping(value = "/loggedout", method = RequestMethod.GET)
    public String loggedOut() {
        return "redirect:login";
    }
}

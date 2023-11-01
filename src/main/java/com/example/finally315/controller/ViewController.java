package com.example.finally315.controller;

import com.example.finally315.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.security.Principal;

@Controller
@RequestMapping("/page")
public class ViewController {

    private final UserService userService;

    public ViewController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String printUsers(ModelMap model, Principal principal) {
        model.addAttribute("userAuth", userService.findByUsername(principal.getName()));
        return "index";
    }

    @GetMapping("/user")
    public String show(ModelMap model, Principal principal) {
        model.addAttribute("user", userService.findByUsername(principal.getName()));
        return "user";
    }


}

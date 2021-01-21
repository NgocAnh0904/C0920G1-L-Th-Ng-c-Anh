package com.codegym.demo.controller;

import com.codegym.demo.response.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("user")
public class DashBoardController {

    @ModelAttribute("user")
    public User getUser(){
        return new User();
    }

    @GetMapping(value = {"","/"})
    public String loginA(@ModelAttribute User user, Model model) {
        model.addAttribute("user",user);
        return "views/dashboard";
    }

}

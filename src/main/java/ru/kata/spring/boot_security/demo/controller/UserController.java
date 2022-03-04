package ru.kata.spring.boot_security.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kata.spring.boot_security.demo.service.UserService;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping()
    public String startPage(Model model) {
        model.addAttribute("User", userService.getAllUsers());
        return "user";
    }
}

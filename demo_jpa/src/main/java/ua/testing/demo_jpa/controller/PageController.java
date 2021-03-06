package ua.testing.demo_jpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    @RequestMapping("/")
    public String mainPage(){
        return "home";
    }

    @RequestMapping("/home")
    public String homePage(){
        return "home";
    }

    @RequestMapping("/all_user")
    public String userPage(){
        return "users/index";
    }
}

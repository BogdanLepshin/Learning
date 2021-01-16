package ua.testing.demo_jpa.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.testing.demo_jpa.dto.UserDTO;
import ua.testing.demo_jpa.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;


@Slf4j
@Controller
@RequestMapping(value = "/")
public class LoginFormController {

    private final UserService userService;

    @Autowired
    public LoginFormController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("user", new UserDTO());
        model.addAttribute("users", userService.getAllUsers().getUsers());
    }

    @GetMapping("login")
    public String login(Principal principal, Authentication auth) {
        if (principal != null) {
            return "redirect:/users";
        }
        return "login";
    }

    @GetMapping("users")
    public String getAllUser(Model model) {
        //model.addAttribute("users", userService.getAllUsers().getUsers());
        log.info("{}", userService.getAllUsers());
        return "users/index";
    }
}

package ua.testing.demo_jpa.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.testing.demo_jpa.dto.UserDTO;
import ua.testing.demo_jpa.service.UserService;

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
    public String login() {
        //model.addAttribute("user", new UserDTO());
        return "login";
    }

    //@ResponseStatus(HttpStatus.CREATED)
    @PostMapping("login")
    public String loginFormController(@ModelAttribute UserDTO user, Model model) {
        log.info("CONTROLLER");
        if (!userService.findByUserLoginAndPassword(user).isPresent()) {
            model.addAttribute("error_msg", "Wrong email or password");
            return "login";
        }
        log.info("{}", userService.findByUserLoginAndPassword(user));
        log.info("{}", user);
        return "redirect:/users";
    }

    @GetMapping("users")
    public String getAllUser(Model model) {
        //model.addAttribute("users", userService.getAllUsers().getUsers());
        log.info("{}", userService.getAllUsers());
        return "users/index";
    }
}

package ua.testing.demo_jpa.controller;

import antlr.BaseAST;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ua.testing.demo_jpa.dto.RegisterForm;
import ua.testing.demo_jpa.dto.UserDTO;
import ua.testing.demo_jpa.entity.RoleType;
import ua.testing.demo_jpa.entity.User;
import ua.testing.demo_jpa.service.UserService;

import javax.validation.Valid;
import java.security.Principal;

@Slf4j
@Controller
public class RegistrationController {

    private final UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("registerForm", new RegisterForm());
    }

    @GetMapping("/register")
    public String registration(Principal principal) {
        if (principal != null) {
            return "redirect:/users";
        }
        return "register";
    }

    @PostMapping("/register")
    public String addUser(@ModelAttribute("registerForm") @Valid RegisterForm registerForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "register";
        }
        User user = User.builder()
                .firstName(registerForm.getFirstName())
                .lastName(registerForm.getLastName())
                .email(registerForm.getEmail())
                .password(registerForm.getPassword())
                .role(RoleType.ROLE_USER)
                .build();
        if (!userService.saveNewUser(user)) {
            model.addAttribute("error_user_exists", "");
            return "register";
        }

        return "redirect:/login";
    }


}

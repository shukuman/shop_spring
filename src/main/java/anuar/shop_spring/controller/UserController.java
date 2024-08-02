package anuar.shop_spring.controller;

import anuar.shop_spring.entity.User;
import anuar.shop_spring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping
public class UserController {

    private final UserService userService;

    @GetMapping(path = "/users")
    public String showAllUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping(path = "/user-create")
    public String createUserForm(User user, Model model) {
        model.addAttribute("user", user);
        return "user-create";
    }

    @PostMapping(path = "/user-create")
    public String createUser(User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }
}

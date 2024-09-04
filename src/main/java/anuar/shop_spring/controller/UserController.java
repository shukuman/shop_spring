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
    public String getAllUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping(path = "/register")
    public String getRegisterPage() {
        return "register_page";
    }

    @GetMapping(path = "/login")
    public String getLoginPage() {
        return "login_page";
    }
}

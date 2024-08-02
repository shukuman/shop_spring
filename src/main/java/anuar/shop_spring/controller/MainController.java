package anuar.shop_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/main")
public class MainController {

    @GetMapping
    public String getMainPage() {
        return "main";
    }
}

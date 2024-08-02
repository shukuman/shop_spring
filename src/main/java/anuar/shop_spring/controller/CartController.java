package anuar.shop_spring.controller;

import anuar.shop_spring.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/cart")
public class CartController {

    private final CartService cartService;
}
